package runner_Week6Day1_HA_SP;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features_Week6Day1_HA_SP/features_Week6Day1_HA_2.feature"},
glue = {"steps_Week6Day1_HA_SP","hooks_Week6Day1_HA_SP"}, 
dryRun = false,publish=true,monochrome=true)
public class TC_001_Week6_Day1_HA_2 extends AbstractTestNGCucumberTests {

}
