// create the module and name it joraApp
var joraApp = angular.module('joraApp', ['ngRoute', 'ngCookies']);

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
        	if(status === 401) {
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
        }
    };
});


joraApp.controller('mainController', [ '$scope', '$http', 'loginService',
		function($scope, $http, loginService) {
			$scope.message = $scope.count + 1;
			$scope.message = 'Everyone come and see how good I look!';
			$http({
				method : 'GET',
				url : '/web/t/tickets',
				withCredentials: true
			}).success(function(data, status, headers, config) {
				$scope.tickets = data;
			}).error(function(data, status, headers, config) {
				loginService.redirectToLogin(status);
			});
}]);
			

joraApp.controller('usersController', function($scope) {
	$scope.message = 'Look! I am an user page.';
});

joraApp.controller('adminController', function($scope) {
	$scope.message = 'Look! I am an admin page.';
});

joraApp.controller('loginController', function($scope, $http, loginService, $cookies) {
	$scope.message = 'Look! I am an login page.';
	$scope.login = function(){
		$http({
        method: "POST",
        url: "/web/login",
        data: {
       	 password: $scope.credentials.password,
       	 username: $scope.credentials.username,
        }})
        .success(function(data, status, headers, config) {
        	loginService.redirectAfterLogin();
        	debugger
        	console.log($cookies.session);
    	})
    	.error(function(data, status, headers, config) {
    		console.log("error login", status);
    	});
	}
});


joraApp.controller('ticketController', [ '$scope', '$routeParams', '$http',  '$location',
		function($scope, $routeParams, $http, $location, $cookies) {
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
		} ]);
