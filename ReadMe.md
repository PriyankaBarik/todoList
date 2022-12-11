**********************************************************************************
service description and made assumptions :
**********************************************************************************
a)RESTful API has been created for following services-

1.Create a To-Do List
2.Edit Description
3.Fetch all To-Do List
4.Fetch by Specific ID
5.Update Description
6.Mark as "Done"
7.Mark as "Not Done"

b)Assumptions-

1.Each To-Do has an unique ID which is auto-generated.
2.By default To-Do is "Done"
3.Created date is current date.
4.Edited date is current date as well and End date needs to be filled in the following format=YYYY-MM-DD
5. date will "expired" when due date is over

**********************************************************************************
Tech Stacks:
**********************************************************************************
Java Version: 1.8
spring-boot-starter-web
spring-boot-starter-data-jpa
spring-boot-starter-validation
spring-boot-maven-plugin
h2database
springfox-swagger-ui

**********************************************************************************
How to:
**********************************************************************************
Build: Maven build
Run as Spring-boot application

**********************************************************************************
APIs:

POST=/createtodo
POST=/edittodo/{id}
GET=/getByid/{id}
GET=/listoftodo
GET=/markDone/{id}
GET=/markNotDone/{id}


Swagger api=http://localhost:8089/swagger-ui.html#/

h2console= http://localhost:8089/h2-console/