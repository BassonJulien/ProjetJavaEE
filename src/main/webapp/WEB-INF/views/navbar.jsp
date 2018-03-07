<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Intranet du turfu</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
    box-sizing: border-box;
}

body {
  margin: 0;
}

/* Style the header */
.header {
    background-color: #f1f1f1;
    padding: 20px;
    text-align: center;
}

/* Style the top navigation bar */
.topnav {
    overflow: hidden;
    background-color: #333;
}

/* Style the topnav links */
.topnav a {
    float: left;
    display: block;
    color: #f2f2f2;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

/* Change color on hover */
.topnav a:hover {
    background-color: #ddd;
    color: black;
}
</style>
</head>
<body>

<div class="header">
  <h1>Intranet</h1>
</div>

<c:choose>

    <c:when test="${profile.equals('student')}">
        <div class="topnav">
  			<a href="${pageContext.request.contextPath}/home">Home</a>
  			<a href="${pageContext.request.contextPath}/news">News</a>
  			<a href="${pageContext.request.contextPath}/timeTable">Time table</a>
  			<a href="${pageContext.request.contextPath}/marks">My marks</a>
		</div>
    </c:when>  
      
    <c:when test="${profile.equals('admin')}">
        <div class="topnav">
  			<a href="${pageContext.request.contextPath}/home">Home</a>
  			<a href="${pageContext.request.contextPath}/newsManage">News Management</a>
  			<a href="${pageContext.request.contextPath}/timeTableManage">Time table Management</a>
  			<a href="${pageContext.request.contextPath}/accountManage">Accounts management</a> 
		</div>
    </c:when>
    
     <c:when test="${profile.equals('teacher')}">
		<div class="topnav">
  			<a href="${pageContext.request.contextPath}/home">Home</a>
  			<a href="${pageContext.request.contextPath}/news">News</a>
  			<a href="${pageContext.request.contextPath}/marksManagement">Marks management</a> 
		</div>
    </c:when> 
    
</c:choose>
</body>
</html>