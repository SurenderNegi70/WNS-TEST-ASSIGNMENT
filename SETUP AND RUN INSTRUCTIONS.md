# WNS-TEST-ASSIGNMENT- Instructions on how to set up and run your solution to question 2
## Pre-requisites
- jdk -1.8 or more
- Selenium jars
- Browser drivers (Chrome driver or relavent) 
- Browser (Chrome or relavent)
- Eclipse editor or relavent

# Maven project setup
- create a java project
- Right click on java project > configure > convert to maven project
- Create new pom > Enter Group id & Artifact id >(It will create a pom.xml file)
- Open pom.xml and add parent dependencies.
- Now paste selenium dependency/testNG dependencies..etc from mvn repository to the pom.xml > Inside the parent dependency.
- Now after saving the project all the selenium jars are now automatically will get into your project.
- To verify selenium jars in maven project > click on the maven dependencies folder, which is automatically created by maven, after putting the selenium dependencies into the pom.xml
- If jars are not available inside the maven dependencies folder > Click on the project and click on build automatically.

# Create a java class to write selenium code
- You can write your selenium code in normal java class or testNG class.
- Right click on the src > And create a class.
- Then write your selenium script inside the main method.

# Write code for the given Test Scenarios:
1.	Open the following URL: https://www.moneycorp.com/en-gb/ 
2.	Change the language and region from the top right corner to USA (English). See example snippet. 
3.	Click Find out more for “Foreign exchange solutions” Validate if you have arrived on the page
4.	Search for the word “international payments” using the search box
5.	Validate if you have arrived on the result page
6.	Validate that each article in the list displays a link that starts with https://www.moneycorp.com/en-us/ 

# Run the script:
- After writting the code into the java class or testNG class. Right click on the code and run as: java application or run as testNG
