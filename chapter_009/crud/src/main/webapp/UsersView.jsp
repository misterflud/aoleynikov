<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 10.07.2017
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="aoleynikov.servlets.SingletonPrintOut" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="<%=request.getContextPath()%>/echo" method="post">
    Login: <input type="text" name="login"/>
    <input type="submit" name = "get" value="Get user"/>
</form>
<br/>
<table>
    <tr>
        <td><%=SingletonPrintOut.getInstance().getString()%></td>
    </tr>
    <tr>
        <td></td>
    </tr>
</table>
</body>
</html>
