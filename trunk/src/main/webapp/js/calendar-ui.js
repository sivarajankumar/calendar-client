// JavaScript Document
function TableCtrl($scope, $http) {

  /**
   * Mock data.
   */
  $scope.month = {
    "name":"November",
    "weeks" : [
      {
        "index":"0",
        "days":[
          {"name":"fri", "index":"5", "day":"1", "type":"on"},
          {"name":"sat", "index":"6", "day":"2", "type":"we"},
          {"name":"sun", "index":"0", "day":"3", "type":"we"}
        ]
      },
      {
        "index":"1",
        "days":[
          {"name":"mon", "index":"1", "day":"4", "type":"on"},
          {"name":"tue", "index":"2", "day":"5", "type":"on"},
          {"name":"wed", "index":"3", "day":"6", "type":"on"},
          {"name":"thu", "index":"4", "day":"7", "type":"on"},
          {"name":"fri", "index":"5", "day":"8", "type":"on"},
          {"name":"sat", "index":"6", "day":"9", "type":"we"},
          {"name":"sun", "index":"0", "day":"10", "type":"we"}
        ]
      },
      {
        "index":"2",
        "days":[
          {"name":"mon", "index":"1", "day":"11", "type":"on"},
          {"name":"tue", "index":"2", "day":"12", "type":"on"},
          {"name":"wed", "index":"3", "day":"13", "type":"on"},
          {"name":"thu", "index":"4", "day":"14", "type":"on"},
          {"name":"fri", "index":"5", "day":"15", "type":"on"},
          {"name":"sat", "index":"6", "day":"16", "type":"we"},
          {"name":"sun", "index":"0", "day":"17", "type":"we"}          
        ]
      },
      {
        "index":"3",
        "days":[
          {"name":"mon", "index":"1", "day":"18", "type":"on"},
          {"name":"tue", "index":"2", "day":"19", "type":"on"}
        ]
      }
            
    ]
  };

  /**
   * Checks whether a day array contains (name property) contains a day with name dayname.
   */     
  dayExists = function(days, dayname) {
    for (i=0; i<days.length; i++) {
      if (days[i].name == dayname) {
        return true;
      }
    }
    return false;
  };
 
  /**
   * Adds to week.days array a day ref.
   */      
  addIfNotExists = function(week, dayref) {
      if (dayExists(week.days, dayref.name)) {
        return;
      }
      // unshift or push?
      week.days.unshift({"name":dayref.name, "index":dayref.index_data, "day":-1, "type":"off"});
  };
  
  /**
   * Sort week days: sunday whose index is 0 is placed at the last position, greatest.
   */     
  sortWeekDays = function(week) {
      // sort days
      week.days.sort(function(a, b) {
        if (a.index == 0) {
          return 1;
        } else if (b.index == 0) {
          return -1;
        } else {
          return a.index - b.index;
        }
      });
  };

  /**
   * Reference data: day name, day index on ui-table (<td />), day index in fetched data.      
   */  
  var ref = [
    {name:"mon", index_ui:0, index_data:1},
    {name:"tue", index_ui:1, index_data:2},
    {name:"wed", index_ui:2, index_data:3},
    {name:"thu", index_ui:3, index_data:4},
    {name:"fri", index_ui:4, index_data:5},
    {name:"sat", index_ui:5, index_data:6},
    {name:"sun", index_ui:6, index_data:0}
  ];
  
  /**
   * Fill week with referenced (empty) data for missing days (days not in this month)
   */     
  fillWeekDays = function(week) {
      angular.forEach(ref, function(refDay) {
        addIfNotExists(week, refDay);
      });
  };
  
  /**
   * Initializes and Re-treats week days: adds empty days for those not in this month, sort days to put sunday on last
   */     
  $scope.init = function() {
    $scope.daysCount = 0;
    angular.forEach($scope.month.weeks, function(week) {
      $scope.daysCount += week.days.length;
      fillWeekDays(week);
      sortWeekDays(week);
    });
  };  
    
}
