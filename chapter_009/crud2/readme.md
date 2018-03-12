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
- [x] Understands why html forms creates url without /crud2/ (root). Should adds "." before crud2.
- [x] Creates connection between server and JavaScript (AJAX, JSON). 
- [x] Creates all logic on user page like in JSP.
- [x] Logic in DAO is the same like in crud, but service should be different.
- [ ] Fixes CSS and Html.
- [ ] Adds comments.

## Realisation

06.02.2018
Using Filter creates this mistake javax.servlet.ServletRequestWrapper.isAsyncStarted(ServletRequestWrapper.java:409) and a lot of more...   

08.02.2018
Servlet in and should write in response all information. I think it happens by usual Streams. AND when we use JSP, inside JSP all write in response, but when we want send HTML and use forward it doesn't work, because in web.xml writes just one servlet (/) in all forward call the same servlet (creates request-response-loop). In this situation I wrote in web.xml for pattern *.css, *.html, *.js etc for default servlet. Of course I can write in Stream html textf but for this already created tools (default).    

12.02.2018
Now all html are corrected, almost. Base all pages can open from html.   I am trying send ajax request from html to server and create response.

16.02.2018
Something are adding tag in my html <tbody>. I a lot of time wasted to understand why specificity doesn't work..   

07.03.2018
Now almost  functional is work, next step is fixing css and html to create project is more beauty.

12.03.2018
Crud is worked.
 
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

09.02.2018
When called methods HTTP from JSP (I now that JSP creates Html) like this <form action="authUser" method="post"> url is localhostblablabla/crud2/authUser. But if I use usual html, url path is localhostblablabla/authUser. WHY.

13.02.2018
I understand why url from jsp and html is different. We can write like this "./authUser" in html and after that url will be localhostblablabla/crud2/authUser.
AJax and JavaScript are good tools, but a lot of mistakes not clear for me. I trying send simple JSON object and ajax sends request, server send response, but JSON CANN'T parse it. Why.

14.02.2018
I change jquery code and now it works. 

16.02.2018
I understand main aim CSS, HTML, JavaScript, Jquery, but a lot of information inside each technology... It becomes to slow creation cite.

07.03.2018
Remember that comments in html and javascript are different and if you write <!-- --> in script tag in html page that doesn't work, because comments for javascript is /** **/.








