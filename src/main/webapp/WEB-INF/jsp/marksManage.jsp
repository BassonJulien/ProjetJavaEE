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
		<form:form method="POST" action="marksManage"
			modelAttribute="markValidator">
			<label for="groupClass">course - class</label>
			<form:select path="courseClass">
				<form:options type="submit" name="course" items="${courseClass}" />
			</form:select>

			<label for="groupClass">student - class</label>

			<form:select path="studentClass">
				<form:options name="student" items="${studentList}" />
			</form:select>


			<label for="courseClass">Mark(0-20)</label>
			<form:input path="mark" />
			<input type="submit" value="add mark">








		</form:form>

	</div>

</body>
</html>