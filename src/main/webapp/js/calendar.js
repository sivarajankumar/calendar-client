//calendar.html controller
function Calendar($scope, $http, $location) {

	$scope.init = function() {
	
		var cp = contextPath($location.absUrl(), '#');
		var url = cp + 'spring/calendar/getAll';
		$http.get(url)
		.success(function(data) {
			$scope.data = data;
			angular.forEach(data, function(d) {
				d.date = new Date(d.modificationDate);
				d.month = months[d.month].name;
			});
		})
		.error(function() {
			alert("ERROR!");
		});
	
	};

} // Calendar
