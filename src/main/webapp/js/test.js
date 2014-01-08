function Test($scope, $http, $location) {

	$scope.save = function() {
	    var data = [
		{name: "mahieddine", age: 10},
		{name: 'ichir', age: 15},
		{name: 'hello', age: 34}
	    ];
	    var url = contextPath($location.absUrl(), '#') + 'spring/person/post';
	    $http.post(
		url,
		data
	    )
		.success(function(data, status, headers, config) {
		    alert('OK');
		}).error(function(data, status, headers, config) {
		    alert('KO!');
		});
	};
}