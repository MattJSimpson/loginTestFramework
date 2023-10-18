package Utilities;

import Managers.AllDriverManager;
import Managers.PageObjectManager;

/* TestContext class created to encapsulate the context in which a test is executed, agnostic of the actual testing framework in use */
public class TestContext {

    /* Instantiating all objects required when defining the TestContext class */
    private final AllDriverManager driverManager;
    private final PageObjectManager pageObjectManager;
    public ScenarioContext scenarioContext;

    /* Defining the TestContext object */
    public TestContext() {
        driverManager = new AllDriverManager();
        pageObjectManager = new PageObjectManager(driverManager.getDriver());
        scenarioContext = new ScenarioContext();
    }

    /* Defining the AllDriverManager getDriverManager object */
    public AllDriverManager getDriverManager() {
        return driverManager;
    }

    /* Defining the PageObjectManager getPageObjectManager object */
    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    /* Defining the ScenarioContext getScenarioContext object */
    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
