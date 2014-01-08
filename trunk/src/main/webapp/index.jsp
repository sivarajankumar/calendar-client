<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html ng-app="calendar">
<head>
	<title>Calendar</title>
	
	<link rel="stylesheet" href="<c:url value="css/app.css" />">
	<link rel="stylesheet" href="<c:url value="css/calendar.css" />">
	
	<script src="<c:url value="lib/angular.js" />"></script>
	<script src="<c:url value="js/app.js" />"></script>
	<script src="<c:url value="js/calendar.js" />"></script>
	<script src="<c:url value="js/todo.js" />"></script>
	<script src="<c:url value="js/calendar-ui.js" />"></script>
	<script src="<c:url value="js/utils.js" />"></script>
	<script src="<c:url value="js/test.js" />"></script>

</head>
<body>

	<div class="header">CRA Project</div>
	<div class="navigation">
        <a href="<c:url value="#todo" />">Time sheet</a><br />
    	<a href="<c:url value="#calendar" />">Time sheets history</a><br/>
        <a href="<c:url value="#test" />">Tests</a><br />
    </div>
	<div class="main">
		<div ng-view></div>
	</div>
	<div class="footer">
		<img style="width: 16px;" src="<c:url value="/img/cal.png" />" />
		&copy;&nbsp;<a href="http://java.michir.com">Mahieddine M. ICHIR</a>
	</div>

</body>
</html>