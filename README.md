- Developed this REST API for an Payment Application. This REST API performs all the fundamental CRUD operations of any Payment Application platform with user validation at every step. This a individual project and completed the project within 2 days.

# Functionalities
-   User can register/login
-   See Balance
-   Credit Money
-   Debit Money
-   Check Transaction


## Backend Work
-  Proper Exception Handling
-  Data Stored in the database(mySQL)

## Installation and Run
-  You can clone this repo and start the serve on localhost
-   Before running the API server, we should update the database config inside the application.properties file.
-   Update the port number, username and password as per our local database config.
    -   server.port=8888
    -   spring.datasource.url=jdbc:mysql://localhost:3306/paymentapp
    -   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    -   spring.datasource.username=**Your UserName**
    -   spring.datasource.password=**YourPassword**
    -   spring.jpa.hibernate.ddl-auto=update
    -   spring.jpa.show-sql=true
    -   spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER

-to check the swagger
http://localhost:8888/swagger-ui/

# Tech Stacks

-   Java Core
-   Spring Data JPA
-   Spring Boot
-   Hibernate
-   MySQL
<p>
   <img src="https://img.icons8.com/color/64/000000/java.png"/>
   <img src="https://img.icons8.com/color/48/null/spring-logo.png"/>
   <img src="https://github.com/efat56/striped-pear-8171/blob/main/Images/hibernate_logo_icon_171004.png" />
   <img src="https://img.icons8.com/ios/50/null/mysql-logo.png"/>
</p>




# Backend

## Swagger UI
![image](https://github.com/spvhantale/PaymentApplication/blob/main/ScreenShotTest%20Case/AllController.png)

## Customer-Registration
![image](https://github.com/spvhantale/PaymentApplication/blob/main/ScreenShotTest%20Case/Registration1.png)

## Customer-Login
![image](https://github.com/spvhantale/PaymentApplication/blob/main/ScreenShotTest%20Case/Login1.png)

## Credit-Money
![image](https://github.com/spvhantale/PaymentApplication/blob/main/ScreenShotTest%20Case/CreditAmount1.png)

## Debit-Money
![image](https://github.com/spvhantale/PaymentApplication/blob/main/ScreenShotTest%20Case/DebitAmount1.png)

## Transaction
![image](https://github.com/spvhantale/PaymentApplication/blob/main/ScreenShotTest%20Case/Tran1.png)
![image](https://github.com/spvhantale/PaymentApplication/blob/main/ScreenShotTest%20Case/TransactionResponse1.png)
## Balance
![image](https://github.com/spvhantale/PaymentApplication/blob/main/ScreenShotTest%20Case/BalanceCheck1.png)
![image](https://github.com/spvhantale/PaymentApplication/blob/main/ScreenShotTest%20Case/CheckBalanceResponse1.png)



<p align="center"> <img src="https://64.media.tumblr.com/d0635fa4e4bf417b33f24bd481c21f88/tumblr_ppcabrYCWy1ue08b9o1_540.gif" alt="" /> </p>
