<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Players</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>

${msg }

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sujith"%>

<table border="4" cellspacing="4" cellpadding="4">
<tr><th>player ID</th><th>Player name</th><th>Player type</th>
<th>No. of matches</th><th>Runs scored</th><th>Wickets taken</th>
<th>Actions</th></tr>

<sujith:forEach var="hai" items="${all }">
<tr>
<td>${hai.getPid() }</td><td>${hai.getPname() }</td><td>${hai.getPtype() }</td>
<td>${hai.getPmatches() }</td><td>${hai.getPruns() }</td><td>${hai.getPwickets() }</td>
<td><ol type="A">
<li><a href="editable?id=${hai.getPid() }">Edit</a></li>
<li><a href="deletable?id=${hai.getPid() }">Delete</a></li>
</ol></td>
</tr>
</sujith:forEach>
</table>
<br><br>
<a href="back">Back To Home</a> <br>
<a href="logout">Logout</a>
</body>
</html>