package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Function;

/* Wait class is defined and contains all the wait objects and methods that enable the user to define their wait parameters using this framework */
public class Wait {

    /* The until object is defined allowing the user to define the parameter of the wait using specific measurements of time */
    private static void until(WebDriver webDriver, Long timeOutInSeconds, Function<WebDriver, Boolean> waitCondition) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeOutInSeconds);
        try {
            webDriverWait.until(waitCondition);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /* The untilAjaxCallIsDone object is defined allowing the user to define the parameter of the wait,
    specifically when using Ajax locators, in measurements of time */
    public static void untilAjaxCallIsDone(WebDriver webDriver, Long timeOutInSeconds) {
        until(webDriver, timeOutInSeconds, (function) -> {
            Boolean isJqueryCallDone = (Boolean) ((JavascriptExecutor) webDriver).executeScript("return jQuery.active==0");
            if (!isJqueryCallDone) System.out.println("jQuery call is in progress");
            return isJqueryCallDone;
        });
    }

    /* The untilPageReadyState object is defined allowing the user to define the parameter of the wait,
    specifically for instances when we want the page to be in a ready state, in measurements of time */
    public static void untilPageReadyState(WebDriver webDriver, Long timeOutInSeconds) {
        until(webDriver, timeOutInSeconds, (function) -> {
            String isPageLoaded = String.valueOf(((JavascriptExecutor) webDriver).executeScript("return document.readyState"));
            if (isPageLoaded.equals("complete")) {
                return true;
            } else {
                System.out.println("Document is loading");
                return false;
            }
        });
    }

    /* The untilElementIsVisible object is defined allowing the user to define the parameter of the wait,
    specifically for instances when we want the web element to be in a visible state, in measurements of time */
    public static void untilElementIsVisible(WebDriver webDriver, WebElement webElement, Long timeOutInSeconds) {
        new WebDriverWait(webDriver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(webElement));
    }

    /* The untilElementIsVisible object is defined allowing the user to define the parameter of the wait,
    specifically for instances when we want a list of all the web elements to be in a visible state, in measurements of time */
    public static void untilListElementIsVisible(WebDriver webDriver, List<WebElement> webElements, Long timeOutInSeconds) {
        new WebDriverWait(webDriver, timeOutInSeconds).until(ExpectedConditions.visibilityOfAllElements(webElements));
    }
}
