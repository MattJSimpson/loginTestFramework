package StepDefinitions;

import Managers.AllDriverManager;
import PageObjects.LoginPage;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/* LoginSteps class created to define all the step definition objects required for testing the Login Page of the login feature */
public class LoginSteps {

    /* Instantiating all objects required when defining the LoginSteps class */
    TestContext testContext;
    LoginPage loginPage;

    /* Commented out code relevant to the commented out Privacy Policy and Site Terms feature.
    I couldn't get the webdriver to handle testing new tab functionality to work hence commenting out */
//    WebDriver webDriver;
//    AllDriverManager allDriverManager = new AllDriverManager();

    /* Object instantiates and defines the test context for the LoginPage class */
    public LoginSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Given("Login page is displayed")
    public void loginPageIsDisplayed() {
        Assert.assertTrue(loginPage.emailLoginPageIsDisplayed());

        String actualLoginHeaderTitle = loginPage.getLoginHeaderTitle();
        Assert.assertEquals("Log In", actualLoginHeaderTitle);
    }

    @And("Click login continue button")
    public void clickLoginContinueButton() throws InterruptedException {
        loginPage.clickSignInButton();
        Thread.sleep(3000);
    }

    @When("^The user enters \"([^\"]*)\" as their email")
    public void enterEmail(String email) {
        loginPage.enterEmailAddress(email);
    }

    @And("^The user enters \"([^\"]*)\" as their password")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Then("The user is unsuccessful in logging in and the first error message is displayed")
    public void theUserIsUnsuccessfulInLoggingInAndTheFirstErrorMessageIsDisplayed() {
        loginPage.errorLoginMessageIsDisplayed();

        String actualErrorLoginMessage1 = loginPage.getLoginErrorMessage();
        Assert.assertEquals(actualErrorLoginMessage1, "We don't recognize that email and/or password");
    }

    @Then("The user is unsuccessful in logging in and the second error message is displayed")
    public void theUserIsUnsuccessfulInLoggingInAndTheSecondErrorMessageIsDisplayed() {
        loginPage.errorLoginMessageIsDisplayed();

        String actualErrorLoginMessage = loginPage.getLoginErrorMessage();
        Assert.assertEquals(actualErrorLoginMessage, "Please fill in all of the required fields");
    }

    @When("The user clicks the Facebook login link")
    public void theUserClicksTheFacebookLoginLink() {
        loginPage.clickFacebookButton();
    }

    @When("The user clicks the Google login link")
    public void theUserClicksTheGoogleLoginLink() {
        loginPage.clickGoogleButton();
    }

    @When("The user clicks the Apple login link")
    public void theUserClicksTheAppleLoginLink() {
        loginPage.clickAppleButton();
    }

    @Then("The Facebook login link opens")
    public void theFacebookLoginLinkOpens() {
        loginPage.facebookLoginIsDisplayed();
    }

    @Then("The Google login link opens")
    public void theGoogleLoginLinkOpens() {
        loginPage.googleLoginIsDisplayed();
    }

    @Then("The Apple login link opens")
    public void theAppleLoginLinkOpens() {
        loginPage.appleLoginIsDisplayed();
    }

    @When("The user clicks the forgot password link")
    public void theUserClicksTheForgotPasswordLink() {
        loginPage.forgotPasswordButton();
    }

    @Then("The forgot password link opens")
    public void theForgotPasswordLinkOpens() {
        loginPage.forgotPasswordDisplayed();
    }

    @When("The user clicks the create account link at the top of the screen")
    public void theUserClicksTheCreateAccountLinkAtTheTopOfTheScreen() {
        loginPage.upperCreateAccountButton();
    }

    @When("The user clicks the create account link at the bottom of the screen")
    public void theUserClicksTheCreateAccountLinkAtTheBottomOfTheScreen() {
        loginPage.lowerCreateAccountButton();
    }

    @Then("The create account link opens")
    public void theCreateAccountLinkOpens() {
        loginPage.createAccountIsDisplayed();
    }

    /* Commented out code relevant to the commented out Privacy Policy and Site Terms feature.
    I couldn't get the webdriver to handle testing new tab functionality to work hence commenting out */

    //    @When("The user clicks the site terms link")
//    public void theUserClicksTheSiteTermsLink() {
//        loginPage.siteTermsButton();
//    }
//
//    @When("The user clicks the privacy policy link")
//    public void theUserClicksThePrivacyPolicyLink() {
//        loginPage.privacyPolicyButton();
//    }

//    @When("The user switches to the new tab")
//    public void userSwitchesToFirstTab() {
//        allDriverManager.switchToNewTab();
//    }
//
//    @Then("The privacy policy link opens")
//    public void thePrivacyPolicyLinkOpens() {
//        loginPage.privacyPolicyIsDisplayed();
//    }

/* Couldn't get the webdriver to handle testing new tab functionality to work hence commenting out */

//  @Then("The site terms link opens")
//    public void theSiteTermsLinkOpens() throws InterruptedException {
////        loginPage.siteTermsIsDisplayed();
////        allDriverManager.getDriver();
////        String currentUrl = webDriver.getCurrentUrl();
////        Assert.assertEquals(currentUrl, "https://www.hudl.com/terms");
//        allDriverManager.switchToNewTab();
////        Thread.sleep(3000);
////        loginPage.acceptCookiesTermsPage();
////        loginPage.clickSignInButton();
//        loginPage.siteTermsHeaderisDispayed();
////
////        String actualSiteTermsHeader = loginPage.getSiteTermsHeader();
////        Assert.assertEquals(actualSiteTermsHeader, "Hudl Site Terms");

}
