# Cucumber + Selenium WebDriver + TestNG with POM
This is a sample project to demonstrate what is Cucumber BDD framework and how it can be used to automate web application. TestNG is used as test framework.
# Page Object Model
POM Pattern technique provides a solution for working with multiple web pages and prevents unwanted code duplication and enables an uncomplicated solution for code maintenance. In general, every page in our application will be represented by a unique class of its own and the page element inspection will be implemented in every class.
# Cucumber BDD
Behavior-Driven Development (BDD) is a software development process that emerged from test-driven development(TDD).It illustrates the methods of developing a feature based on its behavior. The behavior is basically explained Domain Specific Language

# How it Works?
1. Describe Behaviours - Feature
2. Write Step Definition - StepDefinition (Verification Steps for Feature)
3. Run and fail - TestRunner (dryRun = true - This will ensure that all feature implemented in StepDefinition or not)
4. Write StepDefinition - Create all verification script.
5. Execute Test and check the Report.

# How to run this project?
1. Clone the code into a local machine : git clone <URL>
2. Compile the code in local machine. Make sure dependencies are resolved without any error : mvn clean compile
3. Execute the test : You have to pass parameter. 1. browser_name - chrome/firefox   2. Application URL : https://www.babbel.com/
  
  mvn clean verify -Dbrowser_name=firefox -Durl=https://www.babbel.com/
  
  OR  run through shall script
  <project_home> : sh start.sh
  
# View Report
  
  
