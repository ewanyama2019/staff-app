# Organizational Internal News and Information API

#### By **Eric Wafula Wanyama, June 8th, 2019**

## Description
This web app REST API for querying and retrieving news and information. 

## Behavior of the programm

 | Behavior                                       |  Input | Output    |
 | ---------------------------------------------- | ------ | --------- |
 |Create a department name  | Enter the name of the department     |  Department will be added on the options |
 |Adding a staff-member| click add staff-member   |  new staff-member will be added with an input |
 |Displaying the records| click on home page  |  all the sections will be displayed as a link for more information|


 ## API Technical Documentation / Specifications
| Path                                     |  Operation | Description   |Request Format|
 | ---------------------------------------------- | ------ | --------- |---------------|
 | https://staffnewsapp.herokuapp.com/departments| GET  | List all departments||
 | https://staffnewsapp.herokuapp.com/api/users| GET| List all staff||
 | https://staffnewsapp.herokuapp.com/api/ |GET|List general news||
 | https://staffnewsapp.herokuapp.com/api/news/:id/news| GET| News per department id||
 | https://staffnewsapp.herokuapp.com/api/department |POST| Add department|    { "name ": "NSO", "description": "NSO department"  }|   
 | https://staffnewsapp.herokuapp.com/api/news/:id/news |POST| Add news for a department|   {"news_headlines":"Test2","news_details":"Testing Nes Items", "department_id ": 1}|    
 | https://staffnewsapp.herokuapp.com/api/user |POST| Add staff to department| { "user_name": "jdoe", "first_name": "John", "middle_name": "Steven","sir_name": "Doe", "ek_number": "9991", "department_id": 2 }|    
 | https://staffnewsapp.herokuapp.com/api/add-generalnews |POST| Add News|    { "newsitems": "Hello time","newscategoryid": 0,"newstitle": "Hello newstitle" } |

   
   

 
## Setup/Installation Requirements

* create a new folder on your desired location in your local machine
* git init using your terminal
* git clone https://github.com/ewanyama2019/staff-app.git
* make sure you have intellij installed in you laptop.
* launch intellij and go to files>open project.
* enjoy the code.

###DB setup
* CREATE DATABASE staff_app
* \c staff_app
* CREATE TABLE departments (id serial PRIMARY KEY, name varchar, description varchar);
* Table structure  
                  id | name | description 
                  ----+------+-------------

* CREATE TABLE staff_members (id serial PRIMARY KEY, user_name varchar, first_name varchar, middle_name varchar, sir_name varchar, ek_number varchar, department_id int);
* Table structure:
                  id | user_name | first_name | middle_name | sir_name | ek_number | department_id 
                  ----+-----------+------------+-------------+----------+-----------+---------------

* CREATE TABLE departmental_news (id serial PRIMARY KEY, news_headlines varchar, news_details varchar, department_id int);
* Table structure:
                  id | news_headlines | news_details | department_id 
                  ----+----------------+--------------+---------------


* CREATE TABLE general_news (id serial PRIMARY KEY, news_headlines varchar, news_details varchar);
Table structure: 
                  staff_app=# SELECT * FROM general_news;
                  id | news_headlines | news_details 
                  ----+----------------+--------------

* you can th use UNSERT INTO statements to insert test data int the table and test the API using POSTMAN application

## Known Bugs

currently there a bug affecting addition of News. 

## Technologies Used
* java
* JUnit
* Spark
* postgressql

**Main Languages used:**

* java for web application and spark as a frame work


**Other Technologies:**

* none

## live link:

$< https://staffnewsapp.herokuapp.com/ >

# clone into repository

$ git clone  https://github.com/ewanyama2019/staff-app.git
### Open using your favorite editor and view the code or just open the index.html on the browser

## Feedback

Incase of any issues or feedback please add using any of below links.

* [Issues]( https://github.com/ewanyama2019/staff-app.git.issues). To submit any issues.

* [email](wafulawanyama@gmail.com) for any other feedback.

## Support and contact details

 Contact me on [email](wafulawanyama@gmail.com) or on my github account <https://github.com/ewanyama2019>


## License

This project is licensed under the MIT License

**_Eric Wafula Wanyama_** Copyright (c) 2019