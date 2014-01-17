//calendar.html controller
function Calendar($scope, $http, $location) {

	/**
	 * loads and formats data on load.
	 */
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
	};

	// saving data
	$scope.save = function($http) {
		alert("saving ..."+$scope.workingdays());
	};

} // Calendar
