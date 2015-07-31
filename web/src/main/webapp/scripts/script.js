/*var helloApp = angular.module("helloApp", []);
helloApp.controller("HelloCtrl", [ '$scope', '$http', function($scope, $http) {
	$http({
		method : 'GET',
		url : '/web/tickets'
	}).success(function(data, status, headers, config) {
		$scope.tickets = data;
	}).error(function(data, status, headers, config) {
		console.log(data);
	});
} ]);*/

var joraApp = angular.module('joraApp', []);

// create the controller and inject Angular's $scope
joraApp.controller('mainController', function($scope) {

	// create a message to display in our view
	$scope.message = 'Everyone come and see how good I look!';
});

// configure our routes
joraApp.config(function($routeProvider) {
	$routeProvider

	// route for the home page
	.when('/', {
		templateUrl : 'views/index.html',
		controller : 'mainController'
	})

	// route for the tickets page
	.when('/tickets', {
		templateUrl : 'views/tickets.html',
		controller : 'ticketsController'
	})

	// route for the users page
	.when('/users', {
		templateUrl : 'views/users.html',
		controller : 'usersController'
	})

	.when('/admin', {
		templateUrl : 'views/admin.html',
		controller : 'adminController'
	});
});

// create the controller and inject Angular's $scope
joraApp.controller('mainController', function($scope) {
	// create a message to display in our view
	$scope.message = 'Everyone come and see how good I look!';
});

joraApp.controller('ticketsController', [ '$scope', '$http', function($scope, $http) {
	$http({
		method : 'GET',
		url : '/web/tickets'
	}).success(function(data, status, headers, config) {
		$scope.tickets = data;
	}).error(function(data, status, headers, config) {
		console.log(data);
	});
	$scope.message = 'ticketsController This is just a demo';
} ]);

joraApp.controller('usersController', function($scope) {
	$scope.message = 'Contact us! JK. This is just a demo.';
});

joraApp.controller('adminController', function($scope) {
	$scope.message = 'AdminController This is just a demo.';
});