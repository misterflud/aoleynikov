<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>User Management</h1>
        <h2>
        	<a href="get">Get User or Users</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="add">Add user</a>
        </h2>
	</center>
	
	
	
    <div align="center">
		<form action="addUser" method="post">
        <table border="1" cellpadding="3">
            <caption>
            	<h2>
            		Add New User
            	</h2>
            </caption>         
            <tr>
                <th>Name: </th>
                <td>
                	<input type="text" name="name" size="45"
                			
                		/>
                </td>
            </tr>
            <tr>
                <th>Login: </th>
                <td>
                	<input type="text" name="login" size="45"
                			 
                	/>
                </td>
            </tr>
            <tr>
                <th>Email: </th>
                <td>
                	<input type="text" name="email" size="45"
                			 
                	/>
                </td>
            </tr>

            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>		
	
	
</body>
</html>