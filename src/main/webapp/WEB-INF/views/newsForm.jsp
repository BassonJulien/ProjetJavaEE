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
    <label for="title">Titlle</label>
    <input type="text" id="title" name="title" placeholder="title">

    <label for="description">Description</label>
    <input type="text" id="description" name="description" placeholder="description">

	<label for="image">Image URL</label>
    <input type="text" id="image" name="image" placeholder="image">
    
    <input type="radio" name="active" value="active"> Active<br>
    <br>
    
    Expiration date:
    <input type="date" name="endDate">
    
    <input type="submit" value="Create news">
  </form>
</div>

</body>
</html>
