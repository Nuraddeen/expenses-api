# expense-api
A simple expenses management api using Scala and Akka-Http.


This is an api for creating and viewing expenses.

## System Requirements 
- JDK >= 14.0.1 (https://www.oracle.com/java/technologies/javase-downloads.html)
- Sbt  >= 1.5.1 (https://www.scala-sbt.org/download.html)

**STEPS TO KEEP THE APP UP & RUNNING**


#1 clone the repo

  $ git clone https://github.com/Nuraddeen/expenses-api

#2 open the directory

  $ cd expenses-api

#3 build and run the app

  $ sbt run
  
  The app will be built and the server will be started and will be listening to port 8080. (http:localhost:8080)
  
  
  
#4 Test the app

  To create an expense, use postman or any other tool to send a **POST** resquest to the server url
  **http:localhost:8080/api/expenses** wih the following data:
  
  **date**: (String)
  
  **value**: (Float)
  
  **reason**: (String)

    e.g
    {
        "date": "2021-01-03",
        "value": 300,
        "reason": "Food"
    }

  A success/failure response will be returned accordingly
 
 To view list of all expenses added, just send a **GET** request to the server url
    **http:localhost:8080/api/expenses**  and the list of expenses will be returned. or EMPTY if no expense record has been created yet
    
 ** Cheers !!**
