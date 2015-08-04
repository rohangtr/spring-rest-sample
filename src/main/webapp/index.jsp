<!DOCTYPE html>
<html>

<head>
  <title>Employee View</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<script src= "http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>

<body>

<div ng-app="empApp" ng-controller="employeeController"> 

<table border="1" style="width:100%">
  <tr  ng-repeat="x in employees">
    <td>{{ x.id }}</td>
    <td>{{ x.firstName }}</td>
    <td>{{ x.lastName }}</td>
    <td>{{ x.email}}</td>
  </tr>
</table>

</div>

<script>
var app = angular.module('empApp', []);
app.controller('employeeController', function($scope, $http) {
    $http.get("http://localhost:8090/springrestsample/employee")
    .success(function (response) {$scope.employees = response;});
});
</script>

</body>
</html>
