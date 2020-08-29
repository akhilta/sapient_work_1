<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="percapitacls.outputFormat" %>
    <%@ page import="java.util.ArrayList" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Showing contents</title>
</head>

<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<body>
<%
ArrayList<outputFormat> al= (ArrayList<outputFormat>)request.getAttribute("list");
String s;

%>

<table>
  <tr>
    <th>Country/state</th>
    <th>gender</th>
    <th>average</th>
    
  </tr>
  
  <%
    for(outputFormat t:al){%>
        <tr>
            <td><%=  t.country %></td>
           
            <td><%= t.gender %></td>
            
            <td><%= t.average %></td>
           
            
            
        </tr>
      <%}%>
</table>





</body>
</html>