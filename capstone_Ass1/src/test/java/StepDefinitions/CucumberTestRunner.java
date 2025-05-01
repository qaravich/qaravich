package StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", 
                 glue = "StepDefinitions", 
                 plugin = { "pretty","html:target/cucumber-report.html" }
//tags = "@SmokeTest" 
)
public class CucumberTestRunner {

}
//public class CucumberTestRunner extends AbstractTestNGCucumberTests {
//    
////    public void runCucumber() {
////        // This will run the Cucumber tests with TestNG
////    }
//}
