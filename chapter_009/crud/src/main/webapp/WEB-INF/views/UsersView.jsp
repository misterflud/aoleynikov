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

	<center>
		<h1>User Managment</h1>
        <h2>
        	<a href="get">Get User or Users</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="add">Add user</a>
        </h2>


		<form action="getUser" method="post">
			Login: <input type="text" name="login"/>
    		<input type="submit" name = "getUser" value="Get User"/>
		</form>
		
		<form action="getAll" method="post">
    		<input type="submit" name = "ShowAll" value="Show All users"/>
		</form>	
		
	</center>

            	
    <c:if test="${user != null}">
	    <div align="center">
	        <table border="1" cellpadding="4">
	            <caption><h2>List of Users</h2></caption>
	            <tr>
	                <th>Name</th>
	                <th>Login</th>
	                <th>Email</th>
	                <th>CreatedDate</th>
	            </tr>
	            <tr>
	               <td><c:out value="${user.name}" /></td>
	               <td><c:out value="${user.login}" /></td>
	               <td><c:out value="${user.email}" /></td>
	               <td><c:out value="${user.timeOfCreate}" /></td>
	               <td><c:out value="${user.userRole}" /></td>
	            </tr>
	            
	            <a href="edit?login=<c:out value='${user.login}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                <c:if test="${user.userRole == 1}">   
                	<a href="delete?login=<c:out value='${user.login}' />">Delete</a>
                </c:if>    
	        </table>
	    </div>	        
    </c:if>
    
    <c:if test="${listUser != null}">
	    <div align="center">
	        <table border="1" cellpadding="4">
	            <caption><h2>List of Users</h2></caption>
	            <tr>
	                <th>Name</th>
	                <th>Login</th>
	                <th>Email</th>
	                <th>CreatedDate</th>
	            </tr>
	            <c:forEach var="user" items="${listUser}">
	                <tr>
	                    <td><c:out value="${user.name}" /></td>
	                    <td><c:out value="${user.login}" /></td>
	                    <td><c:out value="${user.email}" /></td>
	                    <td><c:out value="${user.timeOfCreate}" /></td>
	                    <td> </td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>	       		
     </c:if>
            	

</body>
</html>
