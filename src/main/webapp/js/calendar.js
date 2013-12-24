//calendar.html controller
function Calendar($scope, $http, $location) {

	// load weekdays array
	//	$scope.weekdays = [];
	//	$http.get($location.path()+'/spring/months/')
	//	.success(function(data) {
	//	$scope.weekdays = data;
	//	})
	//	.error(function(data) {
	//	alert("error loading data!");
	//	});

	// load months array
	//	$scope.months = [];
	//	$http.get('data/months.json')
	//	.success(function(data) {
	//	$scope.months = data;
	//	})
	//	.error(function(data) {
	//	alert('error loading month data!');
	//	});

	// for view, put current month and year into scope
	var today = new Date();
	$scope.year = today.getFullYear();
	$scope.month = today.getMonth();

	// initialize calendar table
	$scope.constructCalendar = function() {

		$scope.days = new Array(5);

		// get current date
		var today = new Date();
		var month = today.getMonth();
		var year = today.getFullYear();

		// starting day: 1st day of month
		var x = 0; // week index
		var y = 0; // day index

		// initialize first week
		$scope.days[x] = new Array(7);

		// loop over days
		for (var i=1; i<=31; i++) {

			// set date to current month and year, with day 'i'
			today.setFullYear(year, month, i);

			// if new month, stop (i.e. current month exceeded)
			if (today.getMonth() != month)
				break;

			// get position in matrix: days index
			y = today.getDay() == 0 ? 6 :  today.getDay() - 1;

			// is weekend day?
			var daytype = y >= 5 ? 0: 100;

			// set into array
			$scope.days[x][y] = {weekday:today.getDay(), date:today.getDate(), type:daytype};

			// step a day further
			y++;
			if (y == 7) {
				y = 0;
				x++;
			}
			// initialize array each starting week: starts a new week day
			if (y == 0) {
				$scope.days[x] = new Array(7);
			}
		} // for
	};

	$scope.init = function() {
		$scope.constructCalendar();
	};

	// compute the number of working days in month
	$scope.workingdays = function() {
		var count = 0;
		angular.forEach($scope.days, function(day) {
			angular.forEach(day, function(d) {
				count += (d.type / 100.0);
			});
		});
		return count;
	};

	// saving data
	$scope.save = function($http) {
		alert("saving ..."+$scope.workingdays());
	};

} // Calendar
