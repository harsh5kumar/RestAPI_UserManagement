# RestAPI_UserManagement

REST application of user management using Spring Boot and Spring Data. This application will perform basic CRUD(Create, Read , Update , Delete) operations on the User table.
The curl commands for APIs are:

READ:-

$curl http://localhost:8080/users

READ byid:-

$curl http://localhost:8080/user/id

CREATE:=

$curl -X POST -H "Content-Type: application/json" -d
"{\"userName\":\"user_name\",\"firstName\":\"first_name\",\"lastName\":\"last_name\",\"mobileNumber\":\"mob_no\",
\"emailID\":\"eml_id@mail.com\",\"address1\":\"address\",\"address2\":\"address\"}" http://localhost:8080/user

UPDATE:=

$curl -X PUT -H "Content-Type: application/json" -d {json data}

DELETE:-

$curl -X DELETE http://localhost:8080/user/id



