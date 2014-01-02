function Todo($scope, $http, $location) {

	$scope.years = arrayRange(2014, 2020);
	$scope.months = arrayRange(0, 11);

	$scope.init = function() {
		var today = new Date();
		$scope.year = today.getFullYear();
		$scope.month = today.getMonth();

		$scope.change();    
	};

	$scope.dayClick = function(day) {
		day.type = getNextDayType(day.type);
	};
	
	$scope.totalWorking = function() {
		var totalWorking = 0;
		angular.forEach($scope.weeks, function(week) {
			angular.forEach(week.days, function(day) {
				if (day.type == 'full') {
					totalWorking++;
				} else if (day.type == 'half') {
					totalWorking += 0.5;
				}
			});
		});
		
		return totalWorking;
	};
	
	$scope.change = function() {

		var cp = contextPath($location.absUrl(), '#');
		$scope.url = cp + 'spring/calendar/'+$scope.year+'/'+$scope.month;    

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

	$scope.save = function() {
		alert("saving ...");
	};

}