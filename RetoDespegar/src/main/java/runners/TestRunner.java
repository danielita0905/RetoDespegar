package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(features="projectFeature", glue="stepsDefinitions", tags = { "@Test1,~@Test2,~@Test3,~@Test4,~@Test5,~@Test6" } )
@CucumberOptions(features="projectFeature", glue="stepsDefinitions", tags = { "@Test1,@Test3,@Test4,@Test5,@Test6" } )
//CucumberOptions(features="projectFeature", glue="stepsDefinitions", tags = { "@Test1" } )
public class TestRunner {
	
}
