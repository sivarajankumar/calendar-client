'use strict';
angular.module('calendar', [])
    .config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/calendar', {templateUrl: 'views/calendar.html', controller: Calendar})
            .when('/todo', {templateUrl: 'views/todo.html', controller: Todo})
            .otherwise({redirectTo: '/calendar'})
        ;
}]);
