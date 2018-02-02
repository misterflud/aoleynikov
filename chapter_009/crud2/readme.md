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
- [ ] Creates connection between server and JavaScript (AJAX, JSON). 
- [ ] Creates all logic on user page like in JSP.
- [ ] Logic in DAO is the same like in crud, but service should be different.
- [ ] Adds comments.

## Realisation


 
## Notes

02.02.2018
Main problem in css, because how it works does't clear. Background has "weight" 13 Mb. Maybe will be better use one HTML and 
load adding html by JavaScript. But now its work like three pages.


















