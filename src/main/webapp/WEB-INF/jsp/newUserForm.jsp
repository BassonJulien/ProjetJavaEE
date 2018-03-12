<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
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
<body>
<div class="form">
  <form:form  method="POST" modelAttribute="userValidator">
  
  	<label for="civility">Civility</label>
    	<form:select path="civility">
      		<form:option value="mister">Mr</form:option>
      		<form:option value="miss">Miss</form:option>
    	</form:select>
    	
    <label for="surname">Surname</label>
    <form:input path="surname" />
    <form:errors path="surname" cssClass="error"/>
    <br>

    <label for="name">Name</label>
    <form:input path="name" />
    <form:errors path="name" cssClass="error"/>
    <br>
    
    <label for="name">Email</label>
    <form:input path="email" />
    <form:errors path="email" cssClass="error"/>
    <br>
    
    <label for="name">Password</label>
    <form:input path="password" />
    <form:errors path="password" cssClass="error"/>
    <br>
    
    <label for="name">Confirm Password</label>
    <form:input path="confirmPassword" />
    <form:errors path="confirmPassword" cssClass="error"/>
    <br>
    
	

    <label for="profile">Profile</label>
    <form:select path="profile">
      <form:option value="admin">Admin</form:option>
      <form:option value="teacher">Teacher</form:option>
      <form:option value="student">Student</form:option>
    </form:select>
  
    <input type="submit" value="Create account">
  </form:form>
</body>
</html>
