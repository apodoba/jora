// create the module and name it joraApp
var joraApp = angular.module('joraApp', [ 'ngRoute' ]);

// configure our routes
joraApp.config(function($routeProvider) {
	$routeProvider

	.when('/', {
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

/*joraApp.controller('mainController', [ '$scope', '$http', sessionService,
		function($scope, $http) {
			$http({
				method : 'GET',
				url : '/web/t/tickets'
			}).success(function(data, status, headers, config) {
				$scope.tickets = data;
			}).error(function(data, status, headers, config) {
				console.log(data);
			});
			$scope.isLoggedIn = sessionService.isLoggedIn;
			$scope.logout = sessionService.logout;
			$scope.message = 'Everyone come and see how good I look!';
		} ]);*/

joraApp.controller('usersController', function($scope) {
	$scope.message = 'Look! I am an user page.';
});

joraApp.controller('adminController', function($scope) {
	$scope.message = 'Look! I am an admin page.';
});

joraApp.controller('ticketController', [ '$scope', '$routeParams', '$http',
		function($scope, $routeParams, $http) {
			$scope.ticketId = $routeParams.ticketId;
			$http({
				method : 'GET',
				url : '/web/t/ticket/' + $scope.ticketId
			}).success(function(data, status, headers, config) {
				$scope.ticket = data;
				$scope.estimateHours = data.estimate/60 - ((data.estimate/60) % 1);
				$scope.estimateMinutes = data.estimate - $scope.estimateHours * 60;
			}).error(function(data, status, headers, config) {
				console.log(data);
			});

			$http({
				method : 'GET',
				url : '/web/t/comments/' + $scope.ticketId
			}).success(function(data, status, headers, config) {
				$scope.comments = data;
			}).error(function(data, status, headers, config) {
				console.log(data);
			});

			$http({
				method : 'GET',
				url : '/web/t/logtime/' + $scope.ticketId
			}).success(function(data, status, headers, config) {
				$scope.logHours = data/60 - ((data/60) % 1);
				$scope.logMinutes = data - $scope.logHours * 60;
			}).error(function(data, status, headers, config) {
				console.log(data);
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


joraApp.factory('sessionService', function($http, $base64) {
    var session = {};
    session.login = function(data) {
        alert('user logged in with credentials ' + data.name + " and " + data.password);
        localStorage.setItem("session", data);
    };
    session.logout = function() {
        localStorage.removeItem("session");
    };
    session.isLoggedIn = function() {
        return localStorage.getItem("session") !== null;
    };
    return session;
});
joraApp.factory('blogService', function($resource) {
    var service = {};
    return service;
});
joraApp.factory('accountService', function($resource) {
    var service = {};
    service.register = function(account, success, failure) {
        var Account = $resource("/basic-web-app/rest/accounts");
        Account.save({}, account, success, failure);
    };
    service.getAccountById = function(accountId) {
        var Account = $resource("/basic-web-app/rest/accounts/:paramAccountId");
        return Account.get({paramAccountId:accountId}).$promise;
    };
    service.userExists = function(account, success, failure) {
        var Account = $resource("/basic-web-app/rest/accounts");
        var data = Account.get({name:account.name, password:account.password}, function() {
            var accounts = data.accounts;
            if(accounts.length !== 0) {
                success(account);
            } else {
                failure();
            }
        },
        failure);
    };
    service.getAllAccounts = function() {
          var Account = $resource("/basic-web-app/rest/accounts");
          return Account.get().$promise.then(function(data) {
            return data.accounts;
          });
      };
    return service;
});

/*joraApp.controller("loginController", function($scope, sessionService, accountService, $state) {
	debugger
    $scope.login = function() {
        accountService.userExists($scope.account, function(account) {
            sessionService.login($scope.account);
            $state.go("home");
        },
        function() {
            alert("Error logging in user");
        });
    };
});
*/
joraApp.controller('loginController', function($scope, sessionService) {
	$scope.message = 'Look! I am an admin page.';
});

joraApp.controller('mainController', function($scope, $http, sessionService) {
		$http({
        	method : 'GET',
        	url : '/web/t/tickets'
        }).success(function(data, status, headers, config) {
        	$scope.tickets = data;
        }).error(function(data, status, headers, config) {
        	console.log(data);
        });
		$scope.isLoggedIn = sessionService.isLoggedIn;
		$scope.logout = sessionService.logout;
		$scope.message = 'Everyone come and see how good I look!';
});