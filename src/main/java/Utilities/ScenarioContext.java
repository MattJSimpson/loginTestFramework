package Utilities;

import Enums.Context;

import java.util.HashMap;
import java.util.Map;

/* SceniorContext class holds the test data information explicitly. Store values in a key-value pair between the steps.
It helps in organizing step definitions better rather than using private variables in step definition classes */
public class ScenarioContext {

    private final Map<String, Object> scenarioContext;

    /* ScenrioContext object creates a HashMap which is a data structure that implements an associative array,
    also called a dictionary. This enables the put and get operations */
    public ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    /* setContext object creates a HashMap and performs the put operation */
    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    /* getContext object creates a HashMap and performs the get operation */
    public Object getContext(Context key) {
        return scenarioContext.get(key.toString());
    }

    /* isContains object checks whether the HashMap contains key value XYZ */
    public Boolean isContains(Context key) {
        return scenarioContext.containsKey(key.toString());
    }
}
