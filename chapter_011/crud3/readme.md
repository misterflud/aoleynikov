# CRUD3


## Task

Create CRUD in web page:
- 	Create
- 	Read
- 	Update
- 	Delete

The main difference with CRUD, CRUD2 is using Spring Framework. Maybe it will be different in design views and business logic.



## Technology
 	


## Structure


		
## Task list 

- [x] Create simple application for Spring.
- [x] Changes structure and deletes web.xml.
- [x] Changes structure of project for Spring.
- [ ] Adds Filter.
- [ ] Selects HTML pages or JSP.
- [ ] Creates Spring beans.
- [ ] Adds Structure in readme.md.

## Realisation

25.02.2018
I deleted all files and created new controller (jsp are stayed). After that I started project on server and it has worked still.
Start url: http://localhost:8080/crud3/users.do
The next steps is project without web.xml.

26.02.2018
I deleted web.xml and adds config package with spring settings. Changes the pom.xml of crud3 (adds maven-war-plugin).   

27.02.2018
Spring opens a lot of tricks, but in the start I think to stop on changing of controller. Maybe in future I will use ORM instead JNDI and connection database. 

28.02.2018 
Adds @RequestMap for each action (almost). next steps is session and filter.
 
 
## Notes

25.02.2018
Spring is very useful framework, but it's not the spherical horse in vacum. Programmer should do a lot of work with environments (IDE, maven, servers etc). 
I wasted time to solve 6 error in Eclipse, some errors creates when web.xml has mistakes, but IDE doesn't show where exactly problem, some errors are solved restart IDE. When you adds new server (tomcat) 
Eclipse does't adds files in workspace folder "Server" and id creates errors when project will deploy -- solve is deletes server and adds again.  

26.02.2018
Remember about maven -- it cann't show the problem in pom.xml. It creates strange situation when server starts with some files from project, but HTTP request doesn't work. When you delete the web.xml you should add in pom.xml maven-war-plugin.    

27.02.2018
I feels that Spring help me to create project and it becomes easier than using just servlets. 

28.02.2018
Spring creates twice the controller, i don't know why. 






