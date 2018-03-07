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
</style>
<body>

<div class="form">
  <form action="/action_page.php">
  
  	<label for="civility">Civility</label>
    	<select id="civility" name="civility">
      		<option value="mister">Mr</option>
      		<option value="miss">Miss</option>
    	</select>
    	
    <label for="surname">Surname</label>
    <input type="text" id="surname" name="surname" placeholder="Your surname..">

    <label for="name">Name</label>
    <input type="text" id="name" name="name" placeholder="Your name..">
	
	<label for="mail">Mail</label>
  	<input type="text" id="mail" name="mail" placeholder="Your mail adress..">
	

	<label for="password">Password</label>
  	<input type="text" id="password" name="password" placeholder="Your password..">

	<label for="cpassword">Confirm Password</label>
  	<input type="text" id="cpassword" name="cpassword" placeholder="Confirm your password..">
	

    <label for="profile">Profile</label>
    <select id="profile" name="profile">
      <option value="admin">Admin</option>
      <option value="teacher">Teacher</option>
      <option value="strudent">Student</option>
    </select>
  
    <input type="submit" value="Create account">
  </form>
</div>

</body>
</html>
