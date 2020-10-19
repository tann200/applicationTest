# applicationTest
This is a test application for lease product, which uses java and selenide to run some UI tests with different inputs.
The project consists of 2 modules named main and test.

In this project main module are located the following:

* Configuration classes for environment and logging
* enums used in Application model.
* helpers for TestNG and Allure reporter
* Models for application
* resources folder for config.properties file

In this project test module are located the following:

* PageObject classes which hold the methods and selectors
* testData class, which contains the basic test data and can be expanded
* tests package with tests for different application types and TestBase class, where importing of pageObjects is done
and where additional configuration changes can be stored.
* resources folder, which contains the testSuite file and properties for allure report logging.



## Set up

Clone or download the project to your local machine and import it to Your IDE as a gradle project. All the depdendencies
this project needs, should be downloaded by gradle after initial import.


Configuration for application url is located in "src/main/resources/config.properties"
Currently the url is set up for the live environment, but can be easily changed for other
environments or overriden from bamboo or jenkins.

## Test execution

* To run the tests locally during implementation, right click and run
 on TestNg.xml.

* To run the tests with gradle on unix machine, use command ./gradlew test in IDE terminal

* To run the tests with gradle on windows machine, use command gradle.bat test in IDE terminal

* In order to get an AllureReport after testrun use ./gradlew test allureReport