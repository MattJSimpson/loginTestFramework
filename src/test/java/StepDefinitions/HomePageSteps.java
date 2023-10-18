package StepDefinitions;

import PageObjects.HomePage;
import Utilities.TestContext;
import io.cucumber.java.en.Then;

/* HomePageSteps class created to define all the step definition objects required for testing the Home Page of the login feature */
public class HomePageSteps {

    /* Instantiating all objects required when defining the HomePageSteps class */
    TestContext testContext;
    HomePage homePage;

    /* Object instantiates and defines the test context for the HomePage class */
    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Then("The user is successfully logged in")
    public void successfulLogIn() throws InterruptedException {
        homePage.checkProfileLogin();
    }

}
