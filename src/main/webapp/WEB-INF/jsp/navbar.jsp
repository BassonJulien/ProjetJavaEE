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
.logout {
    float: right;

}

.logout a:hover {
    background-color: #ff0000;

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
  			<a href="${pageContext.request.contextPath}/student/home">Home</a>
  			<a href="${pageContext.request.contextPath}/student/news">News</a>
  			<a href="${pageContext.request.contextPath}/student/timeTable">Time table</a>
  			<a href="${pageContext.request.contextPath}/student/marks">My marks</a>
  			<div class="logout"><a href="${pageContext.request.contextPath}/home">Log out</a> </div>
		</div>
    </c:when>  
      
    <c:when test="${profile.equals('admin')}">
        <div class="topnav">
  			<a href="${pageContext.request.contextPath}/admin/home">Home</a>
  			<a href="${pageContext.request.contextPath}/admin/newsManage">News Management</a>
  			<a href="${pageContext.request.contextPath}/admin/timeTableManage">Time table Management</a>
  			<a href="${pageContext.request.contextPath}/admin/accountManage">Accounts management</a> 
  			<div class="logout"><a href="${pageContext.request.contextPath}/home">Log out</a> </div>
  			
		</div>
    </c:when>
    
     <c:when test="${profile.equals('teacher')}">
		<div class="topnav">
  			<a href="${pageContext.request.contextPath}/teacher/home">Home</a>
  			<a href="${pageContext.request.contextPath}/teacher/news">News</a>
  			<a href="${pageContext.request.contextPath}/teacher/marksManagement">Marks management</a> 
  			<div class="logout"><a href="${pageContext.request.contextPath}/home">Log out</a> </div>
  			
		</div>
    </c:when> 
    
</c:choose>
</body>
</html>