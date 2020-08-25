<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="feecalculator.TransactionFormat" %>
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
ArrayList<TransactionFormat> al= (ArrayList<TransactionFormat>)request.getAttribute("list");
String s;
for(TransactionFormat t:al){
	s=""+t.tranid+"/t"+t.clientid+"/t"+t.secid;
	//out.write("<h3>"+s+"</h3> <br>");
}
%>

<table>
  <tr>
    <th>ClientID</th>
    <th>TransID</th>
    <th>Date</th>
    <th>Priority</th>
    <th>ProcessingFees</th>
  </tr>
  
  <%
    for(TransactionFormat t:al){%>
        <tr>
            <td><%= t.clientid %></td>
           
            <td><%= t.tranid %></td>
            
            <td><%= t.date %></td>
           
            <td><%= t.priority %></td>
           
            <td><%= t.processingfee %></td>
            
        </tr>
      <%}%>
</table>





</body>
</html>