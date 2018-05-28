package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Metodo para la ejecución del feature
 * @author RZABALA
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "projectFeature", glue = "stepsDefinitions", tags = { "@Test1" })
// @CucumberOptions(features = "projectFeature", glue = "stepsDefinitions"})
public class TestRunner {

}
