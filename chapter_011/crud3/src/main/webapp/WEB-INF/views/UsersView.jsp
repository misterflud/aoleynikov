<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 10.07.2017
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>

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

            	
    <c:if test="${getEditUser != null}">
		<form name  = "1"  method="post">
		    <div align="center">
		        <table border="1" cellpadding="4">
		            <caption><h2>List of Users</h2></caption>
		            <tr>
		                <th>Name</th>
		                <th>Login</th>
		                <th>Email</th>
		                <th>CreatedDate</th>
		                <th>UserRole</th>
		                <c:if test = "${userOrAdmin == true and userOrAdmin != null}"> 
		                	<div>
		                		<th>Delete</th>
		                		<th>Save</th>
		                	</div>
		                </c:if>
		            </tr>
		            <tr>
		               <td>
		                   <input type="text" name="name" size="20"
	                			value="<c:out value='${getEditUser.name}' />"
	                		/>
		               </td>
		               <td>	
		               		<c:out value='${getEditUser.login}' />
		               		<input type="hidden" name="login" size="20"
	                			value="<c:out value='${getEditUser.login}' />"
	                		/>     		               	                
		               		
		               </td>
		               <td>
		               
		               		<input type="text" name="email" size="20"
	                			value="<c:out value='${getEditUser.email}' />"
	                		/>               
		               </td>
		               <td>
		               		<c:out value='${getEditUser.timeOfCreate}' />		               
		               </td>
		               <td>
		               		<c:if test = "${isAdmin == true}"> 
		               		    <input type="text" name="userRole" size="20"
	                				value="<c:out value='${getEditUser.userRole.id}' />"
	                			/>	
		               		</c:if>
		               		<c:if test = "${isAdmin == false}"> 

		               			<c:out value='${getEditUser.userRole.name}' />
		               		    <input type="hidden" name="userRole" size="20"
	                				value="<c:out value='${getEditUser.userRole.id}' />"
	                			/>	
		               		</c:if>	
		               			               		               
		               </td>
	 
	 
				       <c:if test = "${sameUser == true or isAdmin == true}">          			
				            	<td>
				            		<input formaction ="saveEdit" type="submit" value="Save" />
				            	</td>	                			 
		                	   	  	
			                	<td>
					            	<input formaction ="deleteUser" type="submit" value="Delete" />
					            </td>
		             	</c:if> 
		            </tr>  
		        </table>
		    </div>
		 </form>     
    </c:if>
    
    <c:if test="${listUser != null}">
	    <div align="center">
	        <table border="1" cellpadding="5">
	            <caption><h2>List of Users</h2></caption>
	            <tr>
	                <th>Name</th>
	                <th>Login</th>
	                <th>Email</th>
	                <th>CreatedDate</th>
	                <th>UserRole</th>
	            </tr>
	            <c:forEach var="user" items="${listUser}">
	                <tr>
	                    <td><c:out value="${user.name}" /></td>
	                    <td><c:out value="${user.login}" /></td>
	                    <td><c:out value="${user.email}" /></td>
	                    <td><c:out value="${user.timeOfCreate}" /></td>  
	                    <td><c:out value="${user.userRole.name}" /></td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>	       		
     </c:if>
            	

</body>
</html>
