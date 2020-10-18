# applicationTest
test application for lease product

## Set up

Clone or download the project to your local machine.
Import it in Your IDE as a gradle project.

Configuration for application url is located in "src/main/resources/config.properties"
Currently the url is set up for the live environment, but can be easily changed for other
environments or overriden from bamboo or jenkins.

## Test execution

* To run the tests locally during implementation, right click and run
 on TestNg.xml.

* To run the tests with gradle, use command ./gradlew test

* In order to get an AllureReport after testrun use ./gradlew test allureReport