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

	/*
	 * .otherwise({ redirectTo : '/' })
	 */;
	;
});

joraApp.controller('mainController', [ '$scope', '$http',
		function($scope, $http) {
			$http({
				method : 'GET',
				url : '/web/t/tickets'
			}).success(function(data, status, headers, config) {
				$scope.tickets = data;
			}).error(function(data, status, headers, config) {
				console.log(data);
			});
			$scope.message = 'Everyone come and see how good I look!';
		} ]);

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
				$scope.logtime = data;
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
