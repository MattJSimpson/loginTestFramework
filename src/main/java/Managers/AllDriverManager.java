package Managers;

import Enums.DriverType;
import Enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import java.util.ArrayList;

import java.util.concurrent.TimeUnit;

/* AllDriverManager created to manage all the webdDiver functions, attributes and objects in this framework and
actually starts and stops the automation framework from running */
public class AllDriverManager {

    /* Instantiating all objects required when defining the AllDriverManager class */
    private WebDriver webDriver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;

    public AllDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
    }

    /* Method createLocalDriver created explaining steps required using webdriver to create a local connection for automated testing */
    private WebDriver createLocalDriver() {
        switch (driverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments ("--window-size=1644,868");
                webDriver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                webDriver = new FirefoxDriver(firefoxOptions);
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;
            case SAFARI:
                webDriver = new SafariDriver();
                break;
        }
        long time = FileReaderManager.getInstance().getConfigFileReader().getTime();

        webDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(time, TimeUnit.SECONDS);
        return webDriver;
    }

    /* Method createRemoteDriver created explaining steps required using webdriver to create a remote connection for automated testing */
    private WebDriver createRemoteDriver() {
        throw new RuntimeException("Remote web driver is not yet implemented");
    }

    /* Method createDriver created explaining and allowing user to determine whether you want to create a local or remote connection for automated testing */
    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL:
                webDriver = createLocalDriver();
                break;
            case REMOTE:
                webDriver = createRemoteDriver();
                break;
        }
        return webDriver;
    }

    /* Method getDriver determines if the driver is already created or needs to be created */
    public WebDriver getDriver() {
        if (webDriver == null) webDriver = createDriver();
        return webDriver;
    }

    /* Method closeDriver quits and closes the driver */
    public void closeDriver() {
        webDriver.close();
        webDriver.quit();
    }

    /* Commented out code relevant to the commented out Privacy Policy and Site Terms feature.
    I couldn't get the webdriver to handle testing new tab functionality to work hence commenting out */
////    public WebDriver switchToNewTab() {
//    public void switchToNewTab () {
//        WebDriver wd = getCurrentWebDriver();
////        getDriver();
//        //get window handlers as list
//        ArrayList<String> browserTabs = new ArrayList<String>(wd.getWindowHandles());
////switch to new tab
//        wd.switchTo().window(browserTabs.get(1));
////check is it correct page opened or not (e.g. check page's title)
////        webDriver.close();
////        webDriver.switchTo().window(browserTabs.get(0));
//    }
}
