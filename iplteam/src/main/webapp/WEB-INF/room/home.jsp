<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>

<h1>Welcome to Team management </h1>
<a href="list">Check Player performance</a>
<br><br>
<a href="add">Add New player</a>
<br><br>
<a href="logout">Logout</a>

</body>
</html>