

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="datechange.addDates" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>date1 is ${date1} date 2 is ${date2}</h3>
	<%
		String s1 = (String) request.getAttribute("date1");
		String s2 = (String) request.getAttribute("date2");
		addDates ad=(addDates)request.getAttribute("dateAddObj");
		String ans=ad.addDate(s1, s2);
		out.print(ans);
	%>

</body>
</html>