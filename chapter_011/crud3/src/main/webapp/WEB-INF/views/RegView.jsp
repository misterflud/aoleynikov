<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <div align="center">
		<form action="users" method="post">
        <table border="1" cellpadding="3">
            <caption>
            	<h2>
            		Authorization
            	</h2>
            </caption>         
            <tr>
                <th>Login: </th>
                <td>
                	<input type="text" name="login" size="45"
                			 
                	/>
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                	<input type="text" name="password" size="45"
                			 
                	/>
                </td>
            </tr>

            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Ok" />
            	</td>
            </tr>
        </table>
        </form>
    </div>
    
    <c:if test="${error != null}">
    	<div align="center">
			<center>
				<font color="red"><h1>Type of error:</font></h1>
		        <h2>
		        	<font color="red"><c:out value = "${error}" /></font>
		        </h2>
			</center>
		</div>
 	</c:if>
		
    
</body>
</html>