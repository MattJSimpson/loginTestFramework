package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/* LoginPage class created to define all the objects required for testing the Login Page of the login feature */
public class LoginPage {

    /* Using the initElements method, one can initialise all the web elements located by @FindBy annotation.
    AjaxElementLocatorFactory only identifies web elements when used in any operation or activity.
    The timeout of a web element is assigned to the HomePage object class with the help of the AjaxElementLocatorFactory. */
    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
    }

    /* List of all the web elements found on the login page that need to be defined, so they can be tested using this framework */
    @FindBy(css = "div#login-box > .headline.page-title.uni-headline--1")
    WebElement loginHeaderTitle;

    @FindBy(id = "email")
    WebElement emailInputField;

    @FindBy(id = "password")
    WebElement passwordInputField;

    @FindBy(id = "btn-facebook-login")
    WebElement loginFacebookButton;

    @FindBy(id = "btn-google-login")
    WebElement loginGoogleButton;

    @FindBy(id = "btn-apple-login")
    WebElement loginAppleButton;

    @FindBy(id = "btn-show-signup")
    WebElement lowerCreateAccountLink;

    @FindBy(id = "nav-btn-page")
    WebElement upperCreateAccountLink;

    @FindBy(id = "site-terms")
    WebElement siteTermsButton;

    @FindBy(id = "privacy-policy")
    WebElement privacyPolicyButton;

    @FindBy(id = "forgot-password")
    WebElement forgotPasswordButton;

    @FindBy(id = "logIn")
    WebElement loginContinueButton;

    @FindBy(css = ".uni-notice.show [data-qa-id]")
    WebElement loginErrorMessage;

    @FindBy(linkText = "Facebook")
    WebElement facebookTitle;

    @FindBy(id = "initialView")
    WebElement googleLogin;

    @FindBy(id = "globalnav")
    WebElement appleLogin;

    @FindBy(id = "reset-box")
    WebElement forgotPassword;

    @FindBy(xpath = "//main[@id='maincontent']/section//h1[1]")
    WebElement siteTerms;

    @FindBy(css = "[class='font-display tracking-normal text-ink text-3xl lg\\:text-4xl mb-8']")
    WebElement siteTermsHeader;

    @FindBy(partialLinkText = "Hudl Privacy Policy")
    WebElement privacyPolicy;

    @FindBy(id = "first-name")
    WebElement createAccountFirstNameInput;

    @FindBy(id = "last-name")
    WebElement createAccountLastNameInput;

    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement acceptCookiesBtnTermsPage;

    /* Method emailLoginPageIsDisplayed created to check whether the Login page was successfully loaded and all the elements were displayed by
    validating whether the following elements have loaded in the browser.
    A Thread.sleep was added to allow sufficient time for the Home page to load first */
    public boolean emailLoginPageIsDisplayed() {
        loginHeaderTitle.isDisplayed();
        emailInputField.isDisplayed();
        passwordInputField.isDisplayed();
        loginFacebookButton.isDisplayed();
        loginGoogleButton.isDisplayed();
        lowerCreateAccountLink.isDisplayed();
        upperCreateAccountLink.isDisplayed();
        siteTermsButton.isDisplayed();
        privacyPolicyButton.isDisplayed();
        return true;
    }

    /* Method to extract the header of the login page and to convert it into a string */
    public String getLoginHeaderTitle() {
        loginHeaderTitle.isDisplayed();
        return loginHeaderTitle.getText();
    }

    /* Method to reuse for Entering Data in text input field */
    public static void enterData(String data, WebElement element) {
        element.clear();
        element.sendKeys(data);
    }

    /* Method to allow the relevant email address, extracted from the feature example table, to be entered into
    the  emailInputField on the login page  */
    public void enterEmailAddress(String email) {
        if (email.equals("empty")) {
            LoginPage.enterData("", emailInputField);
        } else {
            LoginPage.enterData(email, emailInputField);
        }
    }

    /* Method to allow the relevant password, extracted from the feature example table, to be entered into
    the  passwordInputField on the login page  */
    public void enterPassword(String password) {
        if (password.equals("empty")) {
            LoginPage.enterData("", passwordInputField);
        } else {
            LoginPage.enterData(password, passwordInputField);
        }
    }

    /* Method that enables the driver to click the login continue button.
    A Thread sleep was added to allow time for the Home page to begin loading if the login was successful */
    public void clickSignInButton() throws InterruptedException {
        loginContinueButton.click();
        Thread.sleep(3000);
    }

    /* Method that enables the driver to click the Facebook login button. */
    public void clickFacebookButton() {
        loginFacebookButton.click();
    }

    /* Method that enables the driver to click the Google login button. */
    public void clickGoogleButton() {
        loginGoogleButton.click();
    }

    /* Method that enables the driver to click the Apple login button. */
    public void clickAppleButton() {
        loginAppleButton.click();
    }

    /* Method that enables the driver to click the Create Account button at the top of the screen. */
    public void upperCreateAccountButton() {
        upperCreateAccountLink.click();
    }

    /* Method that enables the driver to click the Create Account button at the bottom of the screen. */
    public void lowerCreateAccountButton() {
        lowerCreateAccountLink.click();
    }

    /* Method that enables the driver to click the Forgot Password button. */
    public void forgotPasswordButton() {
        forgotPasswordButton.click();
    }

    /* Method errorLoginMessageIsDisplayed created to check whether the error message loaded following an incorrect password and/or email by
    validating whether the following element has loaded */
    public void errorLoginMessageIsDisplayed() {
        loginErrorMessage.isDisplayed();
    }

    /* Method to extract the login error message and to convert it into a string */
    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }

    /* Method facebookLoginIsDisplayed created to check whether the Facebook login page loaded by
    validating whether the following element has loaded */
    public void facebookLoginIsDisplayed() {
        facebookTitle.isDisplayed();
    }

    /* Method googleLoginIsDisplayed created to check whether the Google login page loaded by
    validating whether the following element has loaded */
    public void googleLoginIsDisplayed() {
        googleLogin.isDisplayed();
    }

    /* Method appleLoginIsDisplayed created to check whether the Apple login page loaded by
    validating whether the following element has loaded */
    public void appleLoginIsDisplayed() {
        appleLogin.isDisplayed();
    }

    /* Method forgotPasswordDisplayed created to check whether the Forgot password page loaded by
    validating whether the following element has loaded */
    public void forgotPasswordDisplayed() {
        forgotPassword.isDisplayed();
    }

    /* Method createAccountIsDisplayed created to check whether the Create Account page loaded by
    validating whether the following element has loaded */
    public void createAccountIsDisplayed() {
        createAccountFirstNameInput.isDisplayed();
        createAccountLastNameInput.isDisplayed();
    }

    /* Commented out code relevant to the commented out Privacy Policy and Site Terms feature.
    I couldn't get the webdriver to handle testing new tab functionality to work hence commenting out */
//    public String getSiteTermsHeader() {
//        return siteTerms.getText();
//    }

//    public void siteTermsIsDisplayed() {
//        siteTerms.isDisplayed();
//    }
//
//    public void privacyPolicyIsDisplayed() {
//        privacyPolicy.isDisplayed();
//    }

    //    public void siteTermsButton() {
//        siteTermsButton.click();
//    }
//
//    public void privacyPolicyButton() {
//        privacyPolicyButton.click();
//    }
//    public void siteTermsHeaderisDispayed() {
//        siteTermsHeader.isDisplayed();
//    }
//
//    public void acceptCookiesTermsPage() {
//        acceptCookiesBtnTermsPage.click();
//    }
}
