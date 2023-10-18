package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/* HomePage class created to define all the objects required for testing the Huddl landing Page of the login feature */
public class HudlPage {

    /* Method emailLoginPageIsDisplayed created to check whether the Login page was successfully loaded and all the elements were displayed by
    validating whether the following elements have loaded in the browser.
    A Thread.sleep was added to allow sufficient time for the Home page to load first */
    public HudlPage(WebDriver webDriver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 10), this);
    }

    /* List of all the web elements found on the Hudl landing page that need to be defined, so they can be tested using this framework */
    @FindBy(css = "a[title='Home'] > svg")
    private WebElement headerLogoButton;

    @FindBy(css = "[data-qa-id='login-select']")
    private WebElement loginDropdownButton;

    @FindBy(css = "[data-qa-id='login-hudl'] .subnavitem__label")
    private WebElement hudlLoginButton;

    /* Method defaultHomePageIsDisplayed created to check whether the HomePage header was successfully loaded by
    validating whether the following element had loaded in the browser */
    public boolean defaultHomePageIsDisplayed() {
        headerLogoButton.isDisplayed();
        return true;
    }

    /* Method clickLoginDropdownButton created to check whether the HomePage dropdown was successfully loaded by
    validating whether the following element has loaded in the browser and then clicking the element to load the HomePage dropdown menu */
    public void clickLoginDropdownButton() {
        loginDropdownButton.isDisplayed();
        loginDropdownButton.click();
    }

    /* Method clickHudlLoginButton created to check whether the login button was successfully loaded by
    validating whether the following element has loaded in the browser and then clicking the element to load the login page */
    public void clickHudlLoginButton() {
        hudlLoginButton.isDisplayed();
        hudlLoginButton.click();
    }
}
