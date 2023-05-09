# QASE
Это тестовый проект, целью которого является прокачать навыки написания автоматизированных тестов
с помощью: ** в качестве инструмента автоматизации использовался Selenium WebDriver
**Здесь описать проект!!!!!**
**'таких-то инстументов, подставить свои' и подходов****


1. Log in valid data
⋅⋅*Description: User log in with valid data

| Steps                                    | Expected result         | Severity | Priority |
|:-----------------------------------------|-------------------------|----------|----------|
| Open page https://app.qase.io/login      | Account is activated    | Blocker  | High     |
| Enter email address in the 'Email' field |                         |          |          |
| Enter password in the 'Password' field   |                         |          |          |
| Click button 'Login'                     |                         |          |          |

2. Log in invalid data
   ⋅⋅*Description: User log in with invalid data e.g. random email and password

| Steps                                           | Expected result         | Severity | Priority |
|:------------------------------------------------|-------------------------|----------|----------|
| Open page https://app.qase.io/login             | Account isn't activated | Blocker  | High     |
| Enter random email address in the 'Email' field | appear note 'These      |          |          |
| Enter random password in the 'Password' field   | credentials do not      |          |          |
| Click button 'Login'                            | match our records.'     |          |          |

3. Create new project
   ⋅⋅*Description: User log in and create new project on page https://app.qase.io/projects
   ⋅⋅*Pre-conditions: log in new user https://app.qase.io/login e.g. Email and Password use from Credentials.class

| Steps                                                | Expected result              | Severity | Priority |
|:-----------------------------------------------------|------------------------------|----------|----------|
| open page https://app.qase.io/projects               | open page                    | Blocker  | High     |
| Click button 'Create new project'                    | https://app.qase.io/project/ |          |          |
| Enter letters in the 'Project name' field            | /_Project name_              |          |          |
| Enter letters in the 'Description' field             |                              |          |          |
| Select in the field 'Project access type' **Public** |                              |          |          |
| Click button 'Create project'                        |                              |          |          |

4. Update settings project
   ⋅⋅*Description: after created new project, change 'Project name'
   ⋅⋅*Pre-conditions: log in new user https://app.qase.io/login e.g. Email and Password use from Credentials.class

| Steps                                                | Expected result              | Severity | Priority |
|:-----------------------------------------------------|------------------------------|----------|----------|
| Open page https://app.qase.io/projects               | appeared alert with notation | Major    | Medium   |
| Click on 'Demo Project'                              | 'Project settings were       |          |          |
| Click button 'Settings' in the list on the left      | successfully updated!'       |          |          |
| Enter letters in the 'Project name' field            |                              |          |          |
| Select in the field 'Project access type' **Public** |                              |          |          |
| Click button 'Update settings'                       |                              |          |          |

5. Create suite
   ⋅⋅*Description: after created new project, create suite in current project
   ⋅⋅*Pre-conditions: log in new user https://app.qase.io/login e.g. Email and Password use from Credentials.class

| Steps                                      | Expected result                      | Severity | Priority |
|:-------------------------------------------|--------------------------------------|----------|----------|
| Open page https://app.qase.io/projects     | appeared alert with notation         | Critical | High     |
| Click on 'Demo Project'                    | 'Suite was successfully created.'    |          |          |
| Click button '+Suite'                      | the list of Suite located new Suite  |          |          |
| Enter letters in the 'Suite name' field    |                                      |          |          |
| Enter letters in the 'Description' field   |                                      |          |          |
| Enter letters in the 'Preconditions' field |                                      |          |          |
| Click button 'Create'                      |                                      |          |          |

6. Create test case
   ⋅⋅*Description: after created new project, create test case in current project and in the certain Suite
   ⋅⋅*Pre-conditions: log in new user https://app.qase.io/login e.g. Email and Password use from Credentials.class

| Steps                                              | Expected result                       | Severity  | Priority |
|:---------------------------------------------------|---------------------------------------|-----------|----------|
| Open page https://app.qase.io/projects             | appeared alert with notation          | Critical  | High     |
| Click on 'Demo Project'                            | 'Test case was created successfully!' |           |          |
| Click button '+' on the right from names the suite |                                       |           |          |
| Click button '+create case'  in dropdown list      |                                       |           |          |
| Enter letters in the 'Title' field                 |                                       |           |          |
| Enter letters in the 'Preconditions' field         |                                       |           |          |
| Choose type in 'Status' field                      |                                       |           |          |
| Enter letters in the 'Description' field           |                                       |           |          |
| Choose type in 'Severity' field                    |                                       |           |          |
| Choose type in 'Priority' field                    |                                       |           |          |
| Choose type in 'Type' field                        |                                       |           |          |
| Choose type in 'Layer' field                       |                                       |           |          |
| Choose type in 'Is flaky' field                    |                                       |           |          |
| Choose type in 'Milestone' field                   |                                       |           |          |
| Choose type in 'Behavior' field                    |                                       |           |          |
| Choose type in 'Automation status' field           |                                       |           |          |
| Enter letters in the 'Conditions' field            |                                       |           |          |
| Enter letters in the 'Pre-conditions' field        |                                       |           |          |
| Enter letters in the 'Post-conditions' field       |                                       |           |          |
| Click button 'add step'                            |                                       |           |          |
| Fill 'step action' some characters                 |                                       |           |          |
| Click button 'Save'                                |                                       |           |          |

7. Create shared step
   ⋅⋅*Description: Create shared step in current project
   ⋅⋅*Pre-conditions: log in new user https://app.qase.io/login e.g. Email and Password use from Credentials.class

| Steps                                              | Expected result        | Severity | Priority |
|:---------------------------------------------------|------------------------|----------|----------|
| Open page https://app.qase.io/projects             | appeared title step on | Major    | Medium   |
| Click on 'Demo Project'                            | "Shared steps page"    |          |          |
| Click button Shared steps' in the list on the left |                        |          |          |
| Enter letters in the 'Shared step title' field     |                        |          |          |
| Click + 'add step'                                 |                        |          |          |
| Enter letters in the 'Action' field                |                        |          |          |
| Enter characters  in the 'Input data' field        |                        |          |          |
| Enter characters  in the 'Expected result' field   |                        |          |          |
| Click picture and upload attachment                |                        |          |          |
| Click button 'Create'                              |                        |          |          |

8. Start new test run
   ⋅⋅*Description: Start new test run in current project
   ⋅⋅*Pre-conditions: log in new user https://app.qase.io/login e.g. Email and Password use from Credentials.class

| Steps                                            | Expected result                 | Severity  | Priority |
|:-------------------------------------------------|---------------------------------|-----------|----------|
| Open page https://app.qase.io/projects           | compare title when you          | Critical  | High     |
| Click on 'Demo Project'                          | create new test run and title   |           |          |
| Click button 'Test Runs' in the list on the left | on dashboard. They match        |           |          |
| Click button 'Start new test run'                |                                 |           |          |
| Save title new test run                          |                                 |           |          |
| Enter letters in the 'Description' field         |                                 |           |          |
| Click '+Add/modify tests from repository'        |                                 |           |          |
| Check the box next to suite                      |                                 |           |          |
| Click button 'Done'                              |                                 |           |          |
| Click button 'Start a run'                       |                                 |           |          |

9. Create new defect
   ⋅⋅*Description: create new defect in current project
   ⋅⋅*Pre-conditions: log in new user https://app.qase.io/login e.g. Email and Password use from Credentials.class

| Steps                                          | Expected result           | Severity  | Priority |
|:-----------------------------------------------|---------------------------|-----------|----------|
| Open page https://app.qase.io/projects         | name of defect appears in | Critical  | High     |
| Click on 'Demo Project'                        | the defect table          |           |          |
| Click button 'Defects' in the list on the left |                           |           |          |
| Click button 'Create new defects'              |                           |           |          |
| Enter letters in the 'Defect title' field      |                           |           |          |
| Enter letters in the 'Actual result' field     |                           |           |          |
| Choose type in 'Severity' field                |                           |           |          |
| Click button 'Create defect'                   |                           |           |          |

10. Change the name workspace
   ⋅⋅*Description: change the name workspace
   ⋅⋅*Pre-conditions: log in new user https://app.qase.io/login e.g. Email and Password use from Credentials.class

| Steps                                           | Expected result         | Severity | Priority  |
|:------------------------------------------------|-------------------------|----------|-----------|
| Open page https://app.qase.io/projects          | in the list on the left | Major    | Medium    |
| Click on 'Demo Project'                         | updated Workspace name  |          |           |
| Click button 'Workspase'                        |                         |          |           |
| Click button 'Settings' in the list on the left |                         |          |           |
| Enter letters in the 'Workspace name' field     |                         |          |           |
| Click button 'Update setting'                   |                         |          |           |
| Choose type in 'Severity' field                 |                         |          |           |
| Click button 'Create defect'                    |                         |          |           |
