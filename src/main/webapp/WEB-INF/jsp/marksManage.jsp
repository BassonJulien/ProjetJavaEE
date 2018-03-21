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
</style>
</head>
<body>
	<%@ include file="navbar.jsp"%>

	<h1>marks management</h1>


	<div class="form">

		<form action="marksManage" method="POST">

			<label for="groupClass">course - class</label> 
			<select name="courseClass" onchange="this.form.submit()">
				<c:forEach var="item" items="${courseClass}" varStatus="row">
				<c:choose>
  					<c:when test="${ empty defaultCourseClass}">
  						<option value="" selected disabled hidden>Choose here</option>
					</c:when>
					
					<c:otherwise >
  						<option value="dada" selected disabled hidden>${defaultCourseClass}</option>
					</c:otherwise>
					</c:choose>
					<option value="${item}">${item}</option>
				</c:forEach>
			</select> 
			<label for="groupClass">student - class</label>
			<select name="student">
			<c:forEach var="item" items="${studentList}" varStatus="row">

				<option value="${item}">${item}</option>
			</c:forEach>
			</select>


			<label for="courseClass">Mark(0-20)</label> 
			<input name="mark" type="text" placeholder="enter a mark between 0 and 20" value="" /> 
			<input type="submit" value="add mark">


		</form>

	</div>

</body>
</html>