<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

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

img {
  display: block;
  max-width:230px;
  max-height:95px;
  width: auto;
  height: auto;
}
</style>
</head>
<body>
<%@ include file="navbar.jsp" %>

<h1>News</h1>


<table id="news">
			<tr>
				<th>Title</th>
				<th>Description</th>
				<th>Image</th>
			</tr>
			<c:forEach items="${news}" var="news">
				<tr>
					<td>${news.title}</td>
					<td>${news.description}</td>
					<td><img width=100 height="100" src="${news.image}">
					</td>
					
				</tr>
			</c:forEach>
		</table>

</body>
</html>