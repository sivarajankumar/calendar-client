function Todo($scope, $http, $location) {

	$scope.years = arrayRange(2014, 2020);
	$scope.months = months;

	$scope.init = function() {
		var today = new Date();
		$scope.year = today.getFullYear();
		$scope.month = $scope.months[today.getMonth()];

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
		var url = cp + 'spring/calendar/get/'+$scope.year+'/'+$scope.month.index;    

		$http.get(url)
		.success(function(data) {
			$scope.data = data;
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
		var url = contextPath($location.absUrl(), '#') + 'spring/calendar/save';
		var postData = $scope.data;
		$http.post(
				url,
				postData
		)
		.success(function(data, status, headers, config) {
			if (data.code == 0) {
				$scope.log = "OK";
			} else {
				$scope.log = {
						message: data.message,
						code: data.code
				};
			}
		}).error(function(data, status, headers, config) {
			$scope.log = {
					data: data,
					status: status,
					headers: headers,
					config: config
			};
		});
	};

}