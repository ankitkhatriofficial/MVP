# MVP Apis
## _@Author 'Ankit Khatri'_

#### Detailed Documentation of the Apis

- There are three Apis developed.
- 1) For saving Details of trainig center to the database
- 2) For retrieving all the training centers from the database
- 3) For retrieving the training centers based on some filteration

## Rest Apis (End Points)
---------------------------------------------
```sh
1) HttpRequest (POST)
End point: http://localhost:6000/training-centers
Parameters(Request Body): {
   centerCode (Primary Key/Id) -> String, 
   centerName -> String,
   student_capacity -> Integer,
   course_offered -> List of String,
   contactEmail -> String,
   contactPhone -> String/Number,
   createdOn ->. Date,
   address -> Object{
       buildingNo -> String,
       city -> String,
       state -> String,
       pincode -> String/Number
   }
Output : "Returns the newly created training center details"
}
```

`Example:` `{
  "centerName" : "Flex Club",
  "contactPhone" : 9814161728,
  "address" : {
    "city" : "Ashok Nagar",
    "buildingNo" : "9861",
    "state" : "Delhi",
    "pincode" : 110096,
    "student_capacity" : 15
  },
  "email" : "flexclub@gmail.com"
}`

```sh
2) HttpRequest (GET)
End point: http://localhost:6000/training-centers
Output : "Returns all the records of training centers"
```

```sh
3) HttpRequest (POST)
End point: http://localhost:6000/training-centers/filter
Parameters(Request Body): {
        Any field available in TrainingCenter model
   }
Output : "Returns the matched records based on filter value provided"
}
```
`Example1:` `{"centerName" : "Flex Club", "contactPhone" : 9814161728}`

------------------------------------------
# Setup Project on localhost

### Requirements
```sh
1) Java Jdk (14 or upper version)
2) Eclipse editor
3) Lombok (Jar file to be added in eclise editor)
```

- Steps:
- Import the project as a exisiting maven project
- In com.MVP package, run `SenpiperBackendAssignmentApplication.java` file
- The project will start on localhost as default port 6000

# HighLights of the Assignment
- Full Spring `MVC` (Model, View, Controller) pattern used 
- Validation of inputed data using hibernate validator
- Exception handling through `ExceptionHandler` in Spring Boot
- Code strcutured & clarity of the code along with proper comments
- Documentation Attached
