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
    <label for="username">Username</label>
    <input type="text" id="username" name="username" placeholder="Your username..">

    <label for="username">Password</label>
    <input type="text" id="password" name="password" placeholder="Your password..">

    <label for="profile">profile</label>
    <select id="profile" name="profile">
      <option value="admin">Admin</option>
      <option value="teacher">Teacher</option>
      <option value="strudent">Student</option>
    </select>
  
    <input type="submit" value="Login">
  </form>
</div>

</body>
</html>
