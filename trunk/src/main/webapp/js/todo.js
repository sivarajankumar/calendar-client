function Todo($scope, $http, $location) {

	var today = new Date();
	$scope.year = today.getFullYear();
	$scope.month = today.getMonth();

	$scope.change = function() {
		$scope.url = $location.absUrl().substr(0, $location.absUrl().lastIndexOf('#')) + 'spring/calendar/'+$scope.year+'/'+$scope.month;    

		$http.get($scope.url)
		.success(function(data) {
			$scope.weeks = data.month.weeks;
			angular.forEach($scope.weeks, function(week) {
				fillWeekDays(week);
				sortWeekDays(week);
			});
		})
		.error(function() {
			alert("ERROR!");
		});
	}

}