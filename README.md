# Hudl Login Page Automation Framework

---

## Project Overview
This project aims to test the Login Page feature of the Hudl website (https://www.hudl.com/en_gb/) using a Selenium (WebDriver) / Cucumber, Java based automation test framework.

**Selenium (WebDriver):**
- Is an open-source collection of APIs which is used for testing web applications. 
- The Selenium Webdriver tool is used for automating web application testing to verify that it works as expected or not.
- WebDriver also enables you to use a programming language in creating your test scripts (Java is used in this framework)

**Cucumber:**
- Is an open-source software testing process that deals with an application's behavior.
- It tests applications as a behavior-driven development (BDD) style.
- Cucumber tests are written in a simple, natural language that anyone can understand, even people who are not technical experts.
- Written as BDD test scenarios using Gherkin syntax (Each scenario should include the Given, When, and Then steps).

---

## Tools and Libraries
This project uses 2 main tools, Selenium and Cucumber.
The complete list of tools and dependencies, you can see in the `pom.xml` file.

## Requirements (The following are required on your local machine)
* Java Development Kit (JDK)
* IDE (IntelliJ, Visual Studio etc.)
* Maven
* WebDriver, using ChromeDriver (FirefoxDriver, EdgeDriver and SafariDriver also can be used if necessary)

## Running Tests
1. Clone the 'loginTestFramework' repository
2. Open the project using any Java IDE (IntelliJ was used when creating this)
3. Checkout to the 'master' branch 
4. Run the tests with the script below:
```shell
$ mvn clean install
```
* If you want to run the specific test, use the cucumber tags (Tags can be found from `src/test/resources/features/LoginTests.feature`)
```shell
$ mvn clean install -Dcucumber.filter.tags="@REPLACE_WITH_ANY_TAGS_THAT_YOU_WANT"
```

## Test Results
* Test report automatically generated on `target` folder after finished the test execution
* See test report from `target/cucumber-reports/advanced-reports/cucumber-html-reports/overview-features.html`
* You can also share your Cucumber Report with another person at https://reports.cucumber.io, just go to `src/test/resources/cucumber.properties` then change the value to be `true`
```properties
cucumber.publish.enabled=true
```
* For more information about reports cucumber you can go to https://reports.cucumber.io/docs/cucumber-jvm

---

### References
* https://cucumber.io/docs/installation/java/
* https://www.selenium.dev/documentation/en/
* https://www.toolsqa.com/cucumber-automation-framework/
* https://www.w3schools.com/java/
* https://www.oracle.com/java/technologies/javase/codeconventions-introduction.html
