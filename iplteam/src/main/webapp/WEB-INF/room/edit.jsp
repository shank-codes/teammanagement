<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit player details</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
${msg }

<%@ taglib prefix="dlithe" uri="http://www.springframework.org/tags/form" %>
<dlithe:errors path="player.*"/>

<form action="change" method="post">
<table>
<tr><td><input type="number" name="pid" value="${one.getPid() }" required></td></tr>
<tr><td><input type="text" name="pname" value="${one.getPname() }" required></td></tr>
<tr><td><input type="text" name="ptype" value="${one.getPtype() }" required></td></tr>
<tr><td><input type="number" name="pmatches" value="${one.getPmatches() }" required></td></tr>
<tr><td><input type="number" name="pruns" value="${one.getPruns() }" required></td></tr>
<tr><td><input type="number" name="pwickets" value="${one.getPwickets() }" required></td></tr>
<tr>
<td><input type="submit" value="Update to list"></td>
<td><input type="reset" value="Clear"></td>
</tr>
</table>
</form>
<br><br>
<a href="back">Back To Home</a> <br>
<a href="logout">Logout</a>

</body>
</html>