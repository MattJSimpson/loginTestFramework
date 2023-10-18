package Managers;

import PageObjects.HomePage;
import PageObjects.HudlPage;
import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;

/* PageObjectManager globally accessible class is created in order to mange all the page's object in this framework in one instance class.
This also makes sure that the same object should not be created again and again.
But to use a single object for all the step definition files. */
public class PageObjectManager {

    /* Instantiating all objects required when defining the PageObjectManager class */
    private final WebDriver webDriver;
    private HudlPage hudlPage;
    private LoginPage loginPage;

    private HomePage homePage;

    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public HudlPage getHudlPage() {
        if (hudlPage == null) {
            hudlPage = new HudlPage(webDriver);
        }
        return hudlPage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(webDriver);
        }
        return loginPage;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(webDriver);
        }
        return homePage;
    }
}
