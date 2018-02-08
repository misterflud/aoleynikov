# CRUD2


## Task

Create CRUD in web page:
- 	Create
- 	Read
- 	Update
- 	Delete

The main difference with CRUD is absence the JSP and using just client languages for client side.



## Technology
 	
- 	JavaEE	
- 	CSS
- 	HTML
- 	JavaScript
- 	SQL
- 	Mockito
-	MVC	
-	Apache connection pool
- 	AJAX
-	JSON
- 	Postgresql

## Structure

-	main.java.aoleynikov.ru.job4j
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
-	test.java.aoleynikov.ru.job4j
	+ 	controller
		+	UsersControllerTest.java
		
## Task list 

- [x] Copies all files from crud to here. 
- [x] Creates HTML pages for each JSP.
- [x] Does successful connection between html, filter, servlet, server.
- [ ] Understands why html forms creates url without /crud2/ (root). 
- [ ] Creates connection between server and JavaScript (AJAX, JSON). 
- [ ] Creates all logic on user page like in JSP.
- [ ] Logic in DAO is the same like in crud, but service should be different.
- [ ] Adds comments.

## Realisation

06.02.2018
Using Filter creates this mistake javax.servlet.ServletRequestWrapper.isAsyncStarted(ServletRequestWrapper.java:409) and a lot of more...   

08.02.2018

 
## Notes

02.02.2018
Main problem in css, because how it works doesn't clear. Background has "weight" 13 Mb. Maybe will be better use one HTML and 
load adding html by JavaScript. But now its work like three pages.

06.06.2018
We should remember that Apache server has self structure for each files (default behavior). If we want to access from html page to static resources we should 
put CSS, JavaScript, images in root application (webapp), not in META-INF. Of course, we can change behavior of server for example we can write servlet and catch all HTTP request (/*) and manage access to structure of project.
If we want to use Filter (<filter> </filter>), we should understand that each request will be caught (and /*.css, /*js, etc too).    

08.02.2018
I 2 days tried do connection between html and server. A lot of pitfalls: browser has cash (save css, html) and changing not showing without reopen, Filter and servlet create request-loop, etc.
 














