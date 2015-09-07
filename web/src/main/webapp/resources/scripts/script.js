// create the module and name it joraApp
var joraApp = angular.module('joraApp', ['ngRoute', 'ngCookies', 'ui.bootstrap', 'oi.select']);

// configure our routes
joraApp.config(function($routeProvider, $httpProvider) {
	$httpProvider.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
	$httpProvider.defaults.withCredentials = true;
	$httpProvider.defaults.transformRequest.unshift(function (data, headersGetter) {
	    var key, result = [];
	    if (typeof data === "string")
	      return data;
	    for (key in data) {
	      if (data.hasOwnProperty(key))
	        result.push(encodeURIComponent(key) + "=" + encodeURIComponent(data[key]));
	    }
	    return result.join("&");
	});
	$routeProvider.when('/', {
		templateUrl : 'resources/views/tickets.html',
		controller : 'mainController'
	})

	.when('/users', {
		templateUrl : 'resources/views/users.html',
		controller : 'usersController'
	})

	.when('/t/ticket/:ticketId', {
		templateUrl : 'resources/views/ticket.html',
		controller : 'ticketController'
	})
	
	.when('/t/edit/ticket/:ticketId', {
		templateUrl : 'resources/views/edit_ticket.html',
		controller : 'editTicketController'
	})

	.when('/admin', {
		templateUrl : 'resources/views/admin.html',
		controller : 'adminController'
	})
	.when('/login', {
		templateUrl : 'resources/views/login.html',
		controller : 'loginController'
	})

	.otherwise({
		redirectTo : '/'
	});
	;
});

joraApp.value('redirectToUrlAfterLogin', { url: '/' });

joraApp.factory('loginService', function($location, redirectToUrlAfterLogin) {
    return {
        redirectToLogin: function(status) {
        	if(status === 401 || status === 403) {
        		if($location.path().toLowerCase() != '/login') {
        			redirectToUrlAfterLogin.url = $location.path();
        		}else {
        			redirectToUrlAfterLogin.url = '/';
        		}
        		$location.path("/login");
        	}
        },
        redirectAfterLogin: function() {
			$location.path(redirectToUrlAfterLogin.url);
        },
        logout: function() {
        	redirectToUrlAfterLogin.url = $location.path();
        }
    };
});


joraApp.controller('mainController', function($scope, $http, loginService, $location, $modal) {
			$scope.message = $scope.count + 1;
			$http({
				method : 'GET',
				url : '/web/t/tickets',
				withCredentials: true
			}).success(function(data, status, headers, config) {
				$scope.tickets = data;
			}).error(function(data, status, headers, config) {
				loginService.redirectToLogin(status);
			});
			
			$scope.logout = function(){
				$http({
		        method: "POST",
		        url: "/web/logout"
		        })
		        .success(function(data, status, headers, config) {
		        	loginService.logout();
		    	});
			};
			
			$scope.editTicket = function (ticket) {
			  var modalInstance = $modal.open({
			    templateUrl: 'resources/views/edit_ticket.html',
				scope: $scope,
				controller: EditTicketController,
				resolve: {
					tickets: function(){
						return $scope.tickets;
					},
				    ticket: function(){
				        return ticket;
				    }
				}
			  });
			  
			  modalInstance.result.then(function (result) {
				  if(result == "success"){
					  $.ajax({
						    xhrFields: {
						        withCredentials: true
						    },
						    type: "GET",
						    url: "/web/t/tickets",
						    async: false,
						    success :  function(data) {
						    	$scope.tickets = data;
					        },
					        error: function(data) {
					        	loginService.redirectToLogin(status);
					        }
						});
					  $scope.success = "Ticket was successfully updated";
				  }else{
					  $scope.error = "Error occurred during update";
				  }
		      }, function () {
		    	  console.info('Modal dismissed at: ' + new Date());
		      });
			}
});
			
var EditTicketController = function ($scope, $modalInstance, ticket, tickets) {
	
	$.ajax({
	    xhrFields: {
	        withCredentials: true
	    },
	    type: "GET",
	    url: "/web/type/types",
	    async: false,
	    success :  function(data) {
	    	$scope.types = data;
        },
        error: function(data) {
        	loginService.redirectToLogin(status);
        }
	});
	
	$.ajax({
	    xhrFields: {
	        withCredentials: true
	    },
	    type: "GET",
	    url: "/web/type/statuses",
	    async: false,
	    success :  function(data) {
	    	$scope.statuses = data;
        },
        error: function(data) {
        	loginService.redirectToLogin(status);
        }
	});
	
	$.ajax({
	    xhrFields: {
	        withCredentials: true
	    },
	    type: "GET",
	    url: "/web/type/priorities",
	    async: false,
	    success :  function(data) {
	    	$scope.priorities = data;
        },
        error: function(data) {
        	loginService.redirectToLogin(status);
        }
	});
	
	$.ajax({
	    xhrFields: {
	        withCredentials: true
	    },
	    type: "GET",
	    url: "/web/t/ticket/" + ticket.id,
	    async: false,
	    success :  function(data) {
	    	$scope.ticket = data;
        },
        error: function(data) {
        	loginService.redirectToLogin(status);
        }
	});
	
	$.ajax({
	    xhrFields: {
	        withCredentials: true
	    },
	    type: "GET",
	    url: "/web/user/users/",
	    async: false,
	    success:  function(data) {
	    	$scope.users = data;
        },
        error: function(data) {
        	loginService.redirectToLogin(status);
        }
	});
	
	 $scope.tickets = tickets;
	 
	 $scope.contains = function (item, items) {
		 for(var i=0; i<items.length; i++){
			 if(items[i].id == item.id){
				 return true;
			 }
		 }
		 return false;
	 };
	 
	 $scope.save = function () {
		 $.ajax({
			    xhrFields: {
			        withCredentials: true
			    },
			    type: "POST",
			    url: "/web/t/edit/",
			    async: false,
			    data: JSON.stringify($scope.ticket),
			    contentType: "application/json; charset=utf-8",
			    success: function(data, textStatus, jqXHR){
		        	$scope.result = "success";
			    },
			    error: function (jqXHR, textStatus, errorThrown){
		        	$scope.result = "error";
			    }
			});

		 $modalInstance.close($scope.result);
	 };

	 $scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	 };
}
joraApp.controller('usersController', function($scope) {
	$scope.message = 'Look! I am an user page.';
});

joraApp.controller('adminController', function($scope) {
	$scope.message = 'Look! I am an admin page.';
});

joraApp.controller('editTicketController', function($scope) {
	$scope.message = 'Look! I am an user page.';
});

joraApp.controller('loginController', function($scope, $http, loginService, $cookies, $browser) {
	$scope.login = function(){
		$http({
        method: "POST",
        url: "/web/login",
        data: {
       	 password: $scope.credentials.password,
       	 username: $scope.credentials.username,
        }})
        .success(function(data, status, headers, config) {
        	if($cookies.get('AUTORIZE')){
        		loginService.redirectAfterLogin();
            	$scope.error = false;
        	}else {
        		$scope.error = true;
        	}
    	})
    	.error(function(data, status, headers, config) {
    		$scope.error = true;
    	});
	}
});


joraApp.controller('ticketController', function($scope, $routeParams, $http, $location, $cookies, loginService) {
			$scope.ticketId = $routeParams.ticketId;
			$http({
				method : 'GET',
				url : '/web/t/ticket/' + $scope.ticketId
			}).success(function(data, status, headers, config) {
				$scope.ticket = data;
				$scope.estimateHours = data.estimate/60 - ((data.estimate/60) % 1);
				$scope.estimateMinutes = data.estimate - $scope.estimateHours * 60;
			}).error(function(data, status, headers, config) {
				loginService.redirectToLogin(status);
			});

			$http({
				method : 'GET',
				url : '/web/t/comments/' + $scope.ticketId
			}).success(function(data, status, headers, config) {
				$scope.comments = data;
			}).error(function(data, status, headers, config) {
				loginService.redirectToLogin(status);
			});

			$http({
				method : 'GET',
				url : '/web/t/logtime/' + $scope.ticketId
			}).success(function(data, status, headers, config) {
				$scope.logHours = data/60 - ((data/60) % 1);
				$scope.logMinutes = data - $scope.logHours * 60;
			}).error(function(data, status, headers, config) {
				loginService.redirectToLogin(status);
			});

			$scope.changeCollapseIcon = function(type) {
				var icon = $("#" + type);
				if (icon.hasClass("glyphicon-hand-up")) {
					icon.removeClass("glyphicon-hand-up");
					icon.addClass("glyphicon-hand-down");
				} else {
					icon.removeClass("glyphicon-hand-down");
					icon.addClass("glyphicon-hand-up");
				}
			};
		});
