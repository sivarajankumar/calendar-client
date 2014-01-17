var months = [
	                 {name: "jan.", index:0},
	                 {name: "feb.", index:1},
	                 {name: "mar.", index:2},
	                 {name: "apr.", index:3},
	                 {name: "may.", index:4},
	                 {name: "jun.", index:5},
	                 {name: "jul.", index:6},
	                 {name: "aug.", index:7},
	                 {name: "sep.", index:8},
	                 {name: "oct.", index:9},
	                 {name: "nov.", index:10},
	                 {name: "dec.", index:11}
	                 ];

/**
 * Reference data: day name, day index on ui-table (<td />), day index in fetched data.      
 */  
var ref = [
           {name:"lun.", index_ui:0, index_data:2},
           {name:"mar.", index_ui:1, index_data:3},
           {name:"mer.", index_ui:2, index_data:4},
           {name:"jeu.", index_ui:3, index_data:5},
           {name:"ven.", index_ui:4, index_data:6},
           {name:"sam.", index_ui:5, index_data:7},
           {name:"dim.", index_ui:6, index_data:1}
           ];

/**
 * Checks whether a day array contains (name property) contains a day with name dayname.
 */     
function dayExists(days, dayname) {
	var i;
	for (i=0; i<days.length; i++) {
		if (days[i].name == dayname) {
			return true;
		}
	}
	return false;
};

function getNextDayType(type) {
	if (type == 'off') {
		return 'off';
	}
	if (type == 'hide') {
		return 'hide';
	}
	if (type == 'none') {
		return 'half';
	}
	if (type == 'half') {
		return 'full';
	}
	if (type == 'full') {
		return 'none';
	}
}

/**
 * Adds to week.days array a day ref.
 */      
function addIfNotExists(week, dayref) {
	if (dayExists(week.days, dayref.name)) {
		return;
	}
	week.days.unshift({"name":dayref.name, "dayOfWeek":dayref.index_data, "dayOfMonth":-1, "type":"hide"});
};

/**
 * Sort week days: sunday whose index is 0 is placed at the last position, greatest.
 */     
function sortWeekDays(week) {
	// sort days
	week.days.sort(function(a, b) {
		if (a.dayOfWeek == 1) {
		    return 1;
		} else if (b.dayOfWeek == 1) {
			return -1;
		} else {
			return a.dayOfWeek - b.dayOfWeek;
		}
	});
};


/**
 * Fill week with referenced (empty) data for missing days (days not in this month)
 */     
function fillWeekDays(week) {
	angular.forEach(ref, function(refDay) {
		addIfNotExists(week, refDay);
	});
};
