<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

<style>
input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.form {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

.error {
	color: red;
}

.button {
	background-color: white;
	color: black;
	border: 2px solid #008CBA;
}

.button:hover {
	background-color: #008CBA;
	color: white;
}

.button2 {
	background-color: white;
	color: black;
	border: 2px solid #f44336;
}

.button2:hover {
	background-color: #f44336;
	color: white;
}

#planning {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#planning td, #planning th {
	border: 1px solid #ddd;
	padding: 8px;
}

#planning tr:nth-child(even) {
	background-color: #f2f2f2;
}

#planning tr:hover {
	background-color: #ddd;
}

#planning th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>

</head>
<body>
	<%@ include file="navbar.jsp"%>

	<h1>Manage Time</h1>
	<div class="row">
		<div class="column">
			<div class="form">
			</div>
		</div>
		<div class="column">
			<div class="form2">
				
						<table id="planning">
							<tr>
								<c:forEach var="day" items="${courseDayList}" varStatus="row">
									<th>${day}</th>
								</c:forEach>
							</tr>

							<tr>
								<c:forEach var="item" items="${heightAM}" varStatus="row">
									<c:choose>
										<c:when test="${item.split('-')[1] != null}">
											<td>${item.split('-')[0]}</td>
										</c:when>
										<c:otherwise>
											<td>free</td>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							<tr>
							<tr>
								<c:forEach var="item" items="${tenAM}" varStatus="row">
									<c:choose>
										<c:when test="${item.split('-')[1] != null}">
											<td>${item.split('-')[0]}</td>
										</c:when>
										<c:otherwise>
											<td>free</td>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							<tr>
							<tr>
								<c:forEach var="item" items="${noon}" varStatus="row">
									<c:choose>
										<c:when test="${item.split('-')[1] != null}">
											<td>${item.split('-')[0]}</td>
										</c:when>
										<c:otherwise>
											<td>free</td>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							<tr>
							
							<tr>
								<c:forEach var="item" items="${twoPM}" varStatus="row">
									<c:choose>
										<c:when test="${item.split('-')[1] != null}">
											<td>${item.split('-')[0]}</td>
										</c:when>
										<c:otherwise>
											<td>free</td>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							<tr>
							<tr>
								<c:forEach var="item" items="${fourPM}" varStatus="row">
									<c:choose>
										<c:when test="${item.split('-')[1] != null}">
											<td>${item.split('-')[0]}</td>
										</c:when>
										<c:otherwise>
											<td>free</td>
										</c:otherwise>
									</c:choose>
								</c:forEach>	
							<tr>
							<tr>
								<c:forEach var="item" items="${sixPM}" varStatus="row">
									<c:choose>
										<c:when test="${item.split('-')[1] != null}">
											<td>${item.split('-')[0]}</td>
										</c:when>
										<c:otherwise>
											<td>free</td>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							<tr>
						</table>
			</div>
		</div>

	</div>

</body>
</html>