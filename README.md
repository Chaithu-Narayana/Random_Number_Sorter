# Random_Number_Sorter
Assignment to sort random numbers and display using a GUI - The requirement as per understanding is to generate random unordered numbers and sort them using an algorithm that employs swapping of positions to do the job. Once sorted, display them on a GUI interface with the details of original input, sorted output, no. of position changes, time taken for the process. The app should also be able to display the history of the earlier sorts.

Solution Proposed:
-------------------

The tech Stack used to achieve this solution and the associated reasons for selecting them is as below:

-Spring boot : To harness the power of using an embedded Servlet Container (Tomcat), database (H2) and Spring-MVC configuration without the need to set them up separately, avoiding boiler-plate code/configuration.  
-Java 8 : To make use of the latest features and simplify the code, namely Lambda Expressions and Streams.  
-H2 Database : The requirement demands a history of sorts even after restart. H2 database supplies a useful parameter 'DB_CLOSE_ON_EXIT=FALSE' that persits the results on the local system. So, even when the app is restarted, the results are not lost. All other in-memory databases lose the data when restarted.  
-Spring-MVC : For easy interaction among different layers in the web application - mapping GUI with the middleware.  
-Spring-Data-JPA : The DB operations in the assignments are simple CRUD operations. So, the choice of JPA to perform these simple operations and avoid boiler-plate code.  
-Embedded Tomcat : Needed for development, may not be needed for deployment and demo purposes.  
-JSP : Interactive GUI developed using JSP technology.  
-Maven : Advanced build tool to generate a deployable binary that can be shipped across.  


Steps to Set-up the app:
-------------------------

1. Download the source code from https://github.com/Chaithu-Narayana/Random_Number_Sorter
2. Build the code using Maven (version 3 and above) from the location of pom.xml in the downloaded sources from step-1 on a command prompt
    Command to run : mvn clean install
3. Go to the generated location of the jar file and run the below to launch the app.
java -jar randomsort-1.0-SNAPSHOT.jar
4. Once the process on step-3 above starts, launch the homepage using the below URL
http://localhost:8081/index/
5. This applications takes the no. of random integers to be generated from the user as an input.
6. Based on the input from the user, it generates the numbers and sorts them accordingly.
7. The results are displayed with the help of an interactive GUI.

Note: If step-4 throws a 404 error (happens on windows 7 and few machines), please close the process and follow the below step to launch the app:
a. On your eclipse or IDE, go to Application.java class
b. Right-Click and 'Run As' -> 'Java Application'
c. Wait for the application to start
d. Follow steps from step-4 above.
