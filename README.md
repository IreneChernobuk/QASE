  This is a test project, the purpose of which is to develop skills in automating testing process of the
 user interface *qase.io* veb application in the **Java** and using support **Maven** and **Selenium WebDriver**.
  
***
  As a pattern for the organization of the project code I chose **Page Object**. This allowed me to put the page 
  elements and methods in separate class.
***
  In this project, as a framework for running tests and organizing them, I chose **TestNG**. 
      With the help of annotations *TestNG*, I thought about running tests in parallel and structuring them:
      _control of the order of execution, creating groups, description of the test methods._
***
In the project, I decided to write additional text information to the log, for with i used special library **log4j**.  
***
I prepared the text data using JavaFaker и Builder Pattern.
***
I provided for running tests using Allure Report.
***
In this test project, I provided for running tests from several browsers: _Chrome, Firefox, Remote (macOS 13,
browserVersion - 16)_ on a cloud server SauseLabs.
I solved this challenge with the help of GOF Design-patterns-Factory.
Management WebDriver realize using the library Java WebDriverManager automated method.
***
In the project, I provided for running tests using XML Test Suites. This allowed me to flexibly configure tests, 
splitting tests into groups and running them in parallel.
***
To analyze the test results for restarting, I created class RetryAnalyzer. In this case, if the test fails, 
it will run 3 times.
***
I chose Cucumber as a testing tool that supports BDD infrastructure. 
***
Tool CI is Jenkins: project build, running tests and и generating report.
***
I developed 10 API tests for the main methods using library RestAssured


# **_I have compiled 10 test case for testing this project:_**
1. **Log in valid data**
* Description: User log in with valid data
* Severity: Blocker
* Priority: High
* Steps: 
    * Open page https://app.qase.io/login
    * Enter email address in the 'Email' field
    * Enter password in the 'Password' field
    * Click button 'Login'  
* Expected result: Account is activated

2. **Log in invalid data**
* Description: User log in with invalid data e.g. random email and password  
* Severity: Blocker
* Priority: High
* Steps:
   * Open page https://app.qase.io/login
   * Enter random email address in the 'Email' field
   * Enter random password in the 'Password' field
   * Click button 'Login'
* Expected result: Account isn't activated appear note 'These credentials do not match our records.'

3. **Create new project**
* Description: User log in and create new project on page https://app.qase.io/projects
* Pre-conditions: log in new user https://app.qase.io/login e.g. Email and Password use from Credentials.class
* Severity: Blocker
* Priority: High
* Steps:
   * Open page https://app.qase.io/projects
   * Click button 'Create new project'
   * Enter letters in the 'Project name' field
   * Enter letters in the 'Description' field
   * Select in the field 'Project access type' **Public**
   * Click button 'Create project'
* Expected result: Opened page https://app.qase.io/project//_Project name_

4. **Update settings project**
* Description: after created new project, change 'Project name'
* Pre-conditions: log in new user https://app.qase.io/login e.g. Email and Password use from Credentials.class
* Severity: Major
* Priority: Medium
* Steps:
   * Open page https://app.qase.io/projects
   * Click on 'Demo Project'
   * Click button 'Settings' in the list on the left
   * Enter letters in the 'Project name' field
   * Select in the field 'Project access type' **Public**
   * Click button 'Update settings'
* Expected result: appeared alert with notation 'Project settings were successfully updated!'

5. **Create suite**
* Description: after created new project, create suite in current project
* Pre-conditions: log in new user https://app.qase.io/login e.g. Email and Password use from Credentials.class  
* Severity: Critical
* Priority: High
* Steps:
   * Open page https://app.qase.io/projects
   * Click on 'Demo Project'
   * Click button '+Suite'
   * Enter letters in the 'Suite name' field
   * Enter letters in the 'Description' field
   * Enter letters in the 'Preconditions' field
   * Click button 'Create'
* Expected result: appeared alert with notation 'Suite was successfully created.' the list of Suite located new Suite.

6. **Create test case**
* Description: after created new project, create test case in current project and in the certain Suite
* Pre-conditions: log in new user https://app.qase.io/login e.g. Email and Password use from Credentials.class
* Severity: Critical
* Priority: High
* Steps:
   * Open page https://app.qase.io/projects
   * Click on 'Demo Project'
   * Click button '+' on the right from names the suite
   * Click button '+create case'  in dropdown list
   * Enter letters in the 'Title' field
   * Enter letters in the 'Preconditions' field
   * Choose type in 'Status' field
   * Enter letters in the 'Description' field
   * Choose type in 'Severity' field
   * Choose type in 'Priority' field
   * Choose type in 'Type' field
   * Choose type in 'Layer' field
   * Choose type in 'Is flaky' field
   * Choose type in 'Milestone' field
   * Choose type in 'Behavior' field
   * Choose type in 'Automation status' field
   * Enter letters in the 'Conditions' field
   * Enter letters in the 'Pre-conditions' field
   * Enter letters in the 'Post-conditions' field
   * Click button 'add step'
   * Fill 'step action' some characters
   * Click button 'Save'
* Expected result: appeared alert with notation 'Test case was created successfully!'

7. **Create shared step**
* Description: Create shared step in current project
* Pre-conditions: log in new user https://app.qase.io/login e.g. Email and Password use from Credentials.class  
* Severity: Major
* Priority: Medium
* Steps:
   * Open page https://app.qase.io/projects
   * Click on 'Demo Project'
   * Click button Shared steps' in the list on the left
   * Enter letters in the 'Shared step title' field
   * Click + 'add step'
   * Enter letters in the 'Action' field
   * Enter characters  in the 'Input data' field
   * Enter characters  in the 'Expected result' field
   * Click button 'Create'
* Expected result: appeared title step on "Shared steps page"

8. **Start new test run**
* Description: Start new test run in current project  
* Pre-conditions: log in new user https://app.qase.io/login e.g. Email and Password use from Credentials.class  
* Severity: Critical
* Priority: High
* Steps:
   * Open page https://app.qase.io/projects
   * Click on 'Demo Project'
   * Click button 'Test Runs' in the list on the left
   * Click button 'Start new test run'
   * Save title new test run
   * Enter letters in the 'Description' field
   * Click '+Add/modify tests from repository'
   * Check the box next to suite
   * Click button 'Done'
   * Click button 'Start a run'
* Expected result: compare title when you create new test run and title on dashboard. They match. 

9. **Create new defect**
* Description: create new defect in current project
* Pre-conditions: log in new user https://app.qase.io/login e.g. Email and Password use from Credentials.class  
* Severity: Critical  
* Priority: High
* Steps:
   * Open page https://app.qase.io/projects
   * Click on 'Demo Project'
   * Click button 'Defects' in the list on the left
   * Click button 'Create new defects'
   * Enter letters in the 'Defect title' field
   * Enter letters in the 'Actual result' field
   * Choose type in 'Severity' field
   * Click button 'Create defect'
* Expected result: name of defect appeared in the defect table

10. **Change the name workspace**
* Description: change the name workspace
* Pre-conditions: log in new user https://app.qase.io/login e.g. Email and Password use from Credentials.class  
* Severity: Major
* Priority: Medium
* Steps:
   * Open page https://app.qase.io/projects
   * Click on 'Demo Project'
   * Click button 'Workspase'
   * Click button 'Settings' in the list on the left
   * Enter letters in the 'Workspace name' field
   * Click button 'Update setting'
* Expected result: in the list on the left updated Workspace name