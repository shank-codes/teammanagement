<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add player</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
${msg }

<%@ taglib prefix="dlithe" uri="http://www.springframework.org/tags/form" %>
<dlithe:errors path="player.*"/>

<form action="newstock" method="post">
<table>
<tr><td><input type="text" name="pname" placeholder="Enter name of the player" required></td></tr>
<tr><td><input type="text" name="ptype" placeholder="Bat/Bowl/WK/Allrounder" required></td></tr>
<tr><td><input type="number" name="pmatches" placeholder="Number of matches" required></td></tr>
<tr><td><input type="number" name="pruns" placeholder="Runs scored" required></td></tr>
<tr><td><input type="number" name="pwickets" placeholder="Wickets taken" required></td></tr>
<tr>
<td><input type="submit" value="Add to list"></td>
<td><input type="reset" value="Clear"></td>
</tr>
</table>
</form>
<br><br>
<a href="back">Back To Home</a> <br>
<a href="logout">Logout</a>

</body>
</html>