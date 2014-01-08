'use strict';
angular.module('calendar', [])
    .config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/calendar', {templateUrl: 'views/calendar.html', controller: Calendar})
            .when('/todo', {templateUrl: 'views/todo.html', controller: Todo})
            .when('/test', {templateUrl: 'views/test.html', controller: Test})
            .otherwise({redirectTo: '/todo'})
        ;
}]);
