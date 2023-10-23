### Tu run the program,application.properties file should be filled which contains
```
spring.datasource.driver-class-name=
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=
spring.jpa.properties.hibernate.dialect=
```
### API requests are
- To get loads of particular shipperid we can use http://localhost:8080/load?shipperId=shipper:UUID
- To get load of particular load id we can use  http://localhost:8080/load/{load}
- To add load we use post request http://localhost:8080/load and request body needs
```
"loadingPoint": "delhi",
"unloadingPoint": "jaipur",
"productType": "chemicals",
"truckType": "canter",
"noOfTrucks": "1",
"weight": "100",
"comment": "",
"shipperId" : “shipper:<UUID>”,
"Date" : “dd-mm-yyyy”
```
- To update a load we use put request for  http://localhost:8080/load/{load} and request body needs (shipperId remains constant)
 ```
"loadingPoint": "alwar",
"unloadingPoint": "jaipur",
"productType": "chemicals",
"truckType": "canter",
"noOfTrucks": "1",
"weight": "100",
"comment": "",
“Date” : “dd-mm-yyyy”	
 ```

-To delete a load use delete request http://localhost:8080/load/{load}



