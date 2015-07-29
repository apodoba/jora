<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="helloApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello AngularJS - Hello World</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.17/angular.min.js"></script>
<script>
	var helloApp = angular.module("helloApp", []);
	helloApp.controller("HelloCtrl", [ '$scope', '$http',
			function($scope, $http) {
				$http({
					method : 'GET',
					url : '/web/tickets'
				}).success(function(data, status, headers, config) {
					$scope.tickets = data;
				}).error(function(data, status, headers, config) {
					console.log(data);
				});
			} ]);
</script>
</head>
<body ng-controller="HelloCtrl">
	<header class="navbar navbar-static-top" id="top" role="banner">
	<div class="container">
		<div class="navbar-header">
			<button class="navbar-toggle" type="button" data-toggle="collapse"
				data-target=".bs-navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="/" class="navbar-brand">Hello-AngularJS</a>
		</div>
	</div>
	</header>
	<div class="container">
		<div class="page-header" style="margin: 0">
			<h1>Hello World</h1>
		</div>

		<div>
			<table class="table">
				<tr>
					<th style="background-color:#f1f1f1">Type</th>
					<th style="background-color:#f1f1f1">Name</th>
					<th style="background-color:#f1f1f1">Status</th>
					<th style="background-color:#f1f1f1">Description</th>
					<th style="background-color:#f1f1f1">Priority</th>
				</tr>
				<tr ng-repeat="ticket in tickets">
					<td ng-if="$odd" style="background-color:#f9f9f9">
						<img data-ng-src="images/type/{{ticket.type.type}}.png" class="img-circle">
					</td>
					<td ng-if="$odd" style="background-color:#f9f9f9">{{ticket.name}}</td>
					<td ng-if="$odd" style="background-color:#f9f9f9">{{ticket.status.status}}</td>
					<td ng-if="$odd" style="background-color:#f9f9f9">{{ticket.description}}</td>
					<td ng-if="$odd" style="background-color:#f9f9f9">
						<img data-ng-src="images/priority/{{ticket.priority.priority}}.png" class="img-circle">
					</td>

					<td ng-if="$even">
						<img data-ng-src="images/type/{{ticket.type.type}}.png" class="img-circle">
					</td>
					<td ng-if="$even">{{ticket.name}}</td>
					<td ng-if="$even">{{ticket.status.status}}</td>
					<td ng-if="$even">{{ticket.description}}</td>
					<td ng-if="$even">
						<img data-ng-src="images/priority/{{ticket.priority.priority}}.png" class="img-circle">
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
