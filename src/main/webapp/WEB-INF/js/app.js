/**
 * Created with JetBrains WebStorm.
 * User: michir
 * Date: 13/02/13
 * Time: 11:50
 * To change this template use File | Settings | File Templates.
 */

'use strict';

angular.module('calendar', [])
    .config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/calendar', {templateUrl: 'views/calendar.html', controller: Calendar})
            .when('/calendar/todo', {templateUrl: 'views/todo.html', controller: Todo})
            .otherwise({redirectTo: '/calendar'})
        ;
}]);
