package StepDefinitions;

import PageObjects.HudlPage;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;

/* HudlSteps class created to define all the step definition objects required for testing the Hudl landing Page of the login feature */
public class HudlSteps {

    /* Instantiating all objects required when defining the HudlSteps class */
    HudlPage hudlPage;
    TestContext testContext;

    /* Object instantiates and defines the test context for the HudlPage class */
    public HudlSteps(TestContext context) {
        testContext = context;
        hudlPage = testContext.getPageObjectManager().getHudlPage();
    }

    @Given("The user navigates to the hudl home page")
    public void iNavigateToTheHudlHomePage() {
        Assert.assertTrue(hudlPage.defaultHomePageIsDisplayed());
    }

    @And("The user navigates to the log in page")
    public void iNavigateToTheLogInPage() {
        Assert.assertTrue(hudlPage.defaultHomePageIsDisplayed());
        hudlPage.clickLoginDropdownButton();
        hudlPage.clickHudlLoginButton();
    }
}
