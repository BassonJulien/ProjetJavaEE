<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111;
}
</style>
</head>
<body>
<c:choose>
    <c:when test="${profile.equals('student')}">
        <ul>
  <li><a class="active" href="${pageContext.request.contextPath}/home">Home</a></li>
  <li><a href="${pageContext.request.contextPath}/news">News</a></li>
  <li><a href="${pageContext.request.contextPath}/timeTable">Time table</a></li>
  <li><a href="${pageContext.request.contextPath}/marks">My marks</a></li>
</ul>
    </c:when>    
    <c:when test="${profile.equals('admin')}">
        <ul>
  <li><a class="active" href="${pageContext.request.contextPath}/home">Home</a></li>
  <li><a href="${pageContext.request.contextPath}/newsManage">News Management</a></li>
  <li><a href="${pageContext.request.contextPath}/accountManage">Accounts management</a></li>
  <li><a href="${pageContext.request.contextPath}/timeTableManage">Time Table management</a></li>
</ul>
    </c:when>
     <c:when test="${profile.equals('teacher')}">
        <ul>
  <li><a class="active" href="${pageContext.request.contextPath}/home">Home</a></li>
  <li><a href="${pageContext.request.contextPath}/news">News</a></li>
  <li><a href="${pageContext.request.contextPath}/marksManage">Marks management</a></li>
</ul>
    </c:when> 
</c:choose>




</body>
</html>