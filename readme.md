### Basic Crud Spring Boot with h2 in memory data base


##### For Test
`mvn test`

##### For Run
`mvn spring-boot:run`


##### Access Services - examples
Get all persons

`Get http://localhost:8037/persons/all`
 
Get person by id

`Get http://localhost:8037/persons/1` 

Create person by post json ie: `{"firstName":"John","lastName":"Keynes","age":"29","favouriteColor":"red",hobby:["shopping","football"]}`

`POST http://localhost:8037/persons/add` 

Delete person by id

`DELETE http://localhost:8037/persons/delete/1` 