package PageObjects;

import Managers.AllDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/* HomePage class created to define all the objects required for testing the Home Page of the login feature */
public class HomePage {

    /* Method emailLoginPageIsDisplayed created to check whether the Login page was successfully loaded and all the elements were displayed by
    validating whether the following elements have loaded in the browser.
    A Thread.sleep was added to allow sufficient time for the Home page to load first */
    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 10), this);
    }

    /* List of all the web elements found on the Home Page that need to be defined, so they can be tested using this framework */
    @FindBy(xpath = "//div[@id='ssr-webnav']/div/div[1]/nav[1]//div[@class='hui-globalusermenu']")
    WebElement profileDropdown;

    @FindBy(css = ".hui-globaluseritem__display-name > span")
    WebElement profileUsername;

    @FindBy(css = ".hui-globaluseritem__email")
    WebElement usernameEmail;

    @FindBy(css = ".hui-globaladditionalitems.hui-globaladditionalitems--not-phone > .hui-globalusermenu__item > span")
    WebElement logOutButton;

    /* Method checkProfileLogin created to check whether the HomePage was successfully logged into by
    validating whether the following elements have loaded in the browser. A Thread.sleep was added to allow sufficient time for the Home page to load first */
    public void checkProfileLogin() throws InterruptedException {
        Thread.sleep(3000);
        profileDropdown.click();
        profileDropdown.isDisplayed();
        profileUsername.isDisplayed();
        usernameEmail.isDisplayed();
        logOutButton.isDisplayed();
    }
}
