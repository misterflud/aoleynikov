# CRUD on JSP


## Task

Create CRUD in web page:
- 	Create
- 	Read
- 	Update
- 	Delete



## Technology
 	
- 	JavaEE	
- 	JSP
- 	TomCat
- 	JDBC
- 	SQL
- 	Mockito
-	MVC	
-	Apache connection pool
-	JNDI
-	HTML
-	JSTL
- 	Postgresql

## Structure

-	main.java.aoleynikov.servlets
	+ 	controller
		+	AuthFilter.java
		+	JsonController.java
		+	UsersController.java
	+ 	dao
		+	ConnectionWithDataBase.java
	+ 	model
		+	AdminRole.java
		+	AnonUser.java
		+	BaseUser.java
		+	GeteerRole.java
		+	Role.java
		+	User.java
		+	UserRole.java
	+ 	service
		+	Service.java	
	+ 	util
		+	DBUtil.java
-	test.java.aoleynikov.servlets
	+ 	controller
		+	UsersControllerTest.java
		
## Realisation

  This web application describes standard web page with different roles (administrator and user). 
There are API for adding users to dataBase. All users should write password when starting work with site. 
User can change self-information (not password and not login). Administrator adds users and changes all informations.


AddUsers.jsp is view's MVC. Creates HTML for users site;
UsersViews.jsp is view's MVC. Creates HTML for users site.
UsersController.java is Controller's MVC. Manages all logic in program. Can select models, views. Gets HTTP methods (requests), Sends response to user;
Service.java is bridge between Controller and other Resources;
ConnectionWithDataBaseDao.java is DAO. Manages database.
 
## Notes

First realization was done by Scriptlets, the last realization was done on JSTL and JSP. 
For managing connection I used Apache connection pool and JNDI. JNDI created problem for testing web application by Mockito, 
because JNDI works just with starting server but mockito is not..


















