package api.runner;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
// Menunjuk ke folder resources secara umum
@SelectClasspathResource("/")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "api.steps")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "not @web")
public class ApiTestRunner {
}