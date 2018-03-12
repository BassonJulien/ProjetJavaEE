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
	background-color: #f2f2f2;
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

.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 16px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}

.button2 {
    background-color: white; 
    color: black; 
    border: 2px solid #008CBA;
}

.button2:hover {
    background-color: #008CBA;
    color: white;
}

.button3 {
    background-color: white; 
    color: black; 
    border: 2px solid #f44336;
}

.button3:hover {
    background-color: #f44336;
    color: white;
}
</style>
</head>
<body>

	<br />
	<br />
	<div>
		<table id="news">
			<tr>
				<th>Title</th>
				<th>Description</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${news}" var="news">
				<tr>
				<form:form action="updateNews" method="post">
					<td>${news.title}</td>
					<td>${news.description}</td>
					<td><button type = "submit" name = "update" value="${news.title}" class="button button2">Update</button></td>
					<td><button type = "submit" name = "delete" value="${news.title}" class="button button3">Delete</button></td>
					</form:form>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>

</html>