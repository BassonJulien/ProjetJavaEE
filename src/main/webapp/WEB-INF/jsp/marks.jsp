<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8" />
<title>Operation List</title>


<style>
#news {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#news td, #news th {
	border: 1px solid #ddd;
	padding: 8px;
}

#news tr:nth-child(even) {
}

#news tr:hover {
	background-color: #ddd;
}

#news th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}

.good td {
	background-color: #C9EF9D;
}

.bad td {
	background-color: #CE6352;
}

</style>
</head>
<body>
<%@ include file="navbar.jsp" %>


	<br />
	<br />
	<div>
		<table id="news">
			<tr>
				<th>Course</th>
				<th>Means</th>
				<th>marks</th>
				
			</tr>
			<c:forEach items="${meanList}" var="meanList">
			<c:if test="${meanList.courseMean >= 10 }">
				 
				<tr bgcolor="#C9EF9D">
					<td>${meanList.courseName}</td>
					<td>${meanList.courseMean}</td>
					<td>${meanList.marks}</td>
					
				</tr>
				
				</c:if>
				
				<c:if test="${meanList.courseMean < 10 }">
				<tr bgcolor="#CE6352">
					<td>${meanList.courseName}</td>
					<td>${meanList.courseMean}</td>
					<td>${meanList.marks}</td>
					
				</tr>
				
				</c:if>
			</c:forEach>
		</table>
	</div>
</body>

</html>