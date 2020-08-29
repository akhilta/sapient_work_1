<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date-Time-Calculator</title>
</head>
<body>
<h2>hello world of learners</h2>
<h3> format DD-MM-YYYY(day-month-year)</h3>

<form action="/spring/date-time" method="post">
<h3> enter date 1</h3>
<input type="text" name="date1">
<h3> enter date 2</h3>
<input type="text" name="date2">
<br>
<label for="operations">Choose an operatioin:</label>
<select id="cars" name="operation">
  <option value="Add">Add</option>
  <option value="Subtract">Subtract</option>
  
</select>
<br><br><br>
<input type="submit" name="submit" value="submit">
 
</form>
</body>
</html>