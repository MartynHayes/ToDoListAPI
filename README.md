# ToDoListAPI

## **Why am we doing this?**

I am building the final project to demonstrate the skills and techniques I have learned throughout this QA bootcamp.  I will follow agile methodology and solid pricinples throughout the project.  I will plan the project and keep track of progress using Jira.  The final project will be built using Spring Boot, Java and Maven.  I am going to build an api with create, read, update and delete functionality(CRUD).  The api will be a simple to do list.  It will enable the users to keep track of tasks via a web dashboard.  Postman will be used to simulate the http requests from the user.  I need to provide a CRUD interface they can use to manage their to-do lists from their desktops.  The api will receive http requests from postman in the form of json files, implement crud functionality using Java, convert to sql and then save to a MySQL local server.  I will use Git Hub as a version controller.

I will then rigorously test the application using unit tests and integration tests.  The testing will be implemented using Mockito, JUnit and MockMvc.  Once the testing has been completed I will create a jar build file complete with all dependencies.

## **How I expect the challenge to go?**
I believe the final project will be very challenging.  Bringing together so many newly learnt skills to create a functioning application sounds very daunting.  However using Jira to plan each step carefully and to break the work into smaller more manageable tasks will definitely help.  I will use the syllabus on QA community to refresh my memory on any particular tasks that I am unsure of.

I am confident that I can code the main body of the application with crud methods without too many problems.  The testing stage is where I foresee the most possible issues.  I haven't yet fully got to grips with using Mockito or MockMvc.  

## **What went well?**
I felt that the planning stage went well.  I was able to concisely communicate what I wanted to achieve from each Jira sprint by breaking the work down into smaller tasks. I decided to work on a simple project which I could then build on if time allowed.  As I had hoped the coding of the main classes also went well with only a few minor syntax issues which were easiy resolved.  The project gave me ample experience of using Git Hub as the version control which I am now comfortable with.  Using Postman to create http requests went very smoothly.   

## **What didn't go as planned?**
The main issues I had all involved the testing of the application.  I spent a long time building the unit tests for the crud methods and the integration tests for the application.  In writing the tests I came up against many syntax problems within Java and Mockito.  After a lot of troubleshooting I was able to produce a number of unit tests.  The next issue was getting these tests to perform as I needed them to.  This stage again took far longer than I had planned.  This extra time that was used in the testing phase of the build ultimately meant that my hope of expanding the projects complexity was not fulfilled.

## **Possible improvements for future revisions of the project**
I would like to greatly expand the functionality of the project.  This would include adding the ability to organise and search by task priority.  Adding a deadline field for tasks which could then be triggered to send email notifications to the user when a task nears a set date or time.  Adding more tables for particular to do lists, for example a shopping list or a wish list.  I would like to add the ability to send your list to a friend through email or possibly through social media.  

Another possible future revision could be tailoring the application towards the busy professional.  In this instance the application could take on workflow management tasks with the ability to share lists between colleagues and update them simultaneously in a Kanban fashion.

I would also like to create a front end graphical user interface(GUI).  This would give me the ability to customise the look and feel of the apllication.  The gui would also allow for user validation and the receiving of user data. 


## **Risk Assesment**
### Scope
The scope of this risk assesment is from the initial inout from a user to the data being add or retrieved from the database.  It will include not just the software element of the the applcation but also the IT infrastructure necessary to run it.


|     **Threat**                 |  **Vulnerabilities**       |      **Mititgation**               |  **Likelihood**  |  **Impact**    |  **Risk**    |
| :---                           |  :---                      |                     :---           |  :---            |  :---          |  :---        |
|  Project purpose and need is   |  Time wasted on non        |  Complete a plan to define         |  Moderate        |  High          |  High        |
|  not well defined.             |  essential features.       |  project purpose and priorities.   |                  |                |              |
|  Development technically too   |  Developer lack of         |  Plan all aspects of development   |  Low             |  High          |  High        |
|  difficult.                    |  experience.               |  to predict possible issues.       |                  |                |              |
|  Redesign required.            |  Inadequate design.        |  Plan to the best of ability       |  Low             |  Moderate      |  Low         |              
|                                |                            |  following solid principles.       |                  |                |              |
|  Unauthorised users accessing  |  Open access to sensitive  |  Add user validation &             |  Moderate        |  High          |  Moderate    |
|  the database.                 |  content.                  |  authorisation.  Encrypt data.     |                  |                |              |
|  Inadequate testing pre        |  Project deployed with     |  Ensure application is rigorously  |  Moderate        |  Moderate      |  Moderate    |
|  deployment.                   |  bugs.                     |  tested before deployment.         |                  |                |              |
|  Failure of hardware causing   |  Database is on one local  |  Host the database on the cloud or |  Low             |  High          |  Low         |
|  loss of data.                 |  server.                   |  in backup physical location.      |                  |                |              |
|  Failure to complete required  |  Inexperience in software  |  Use the project brief to define,  |  Moderate        |  Moderate      |  Moderate    | 
|  documentation.                |  doumnentation.            |  plan and schedule all             |                  |                |              |
|                                |                            |  documentation.                    |                  |                |              |



### Screenshots to show Postman http requests



![Postman-create](https://user-images.githubusercontent.com/66129652/160181860-a6fe5b30-144a-4b0d-ac31-1cff24a9496b.png)



![Postman-findbyid](https://user-images.githubusercontent.com/66129652/160182092-27ecba51-fde5-4894-ade1-7d78cb50cc7f.png)



### Screenshot to show unit test coverage


![Coverage-screenshot](https://user-images.githubusercontent.com/66129652/160182377-92bf6f96-8cc4-4bdd-a3b7-dc3414598207.png)



### Screenshot to show database persistence

![Database persistance-screenshot](https://user-images.githubusercontent.com/66129652/160182231-4c497f61-105f-40b1-a23c-a46f7dd74260.png)



