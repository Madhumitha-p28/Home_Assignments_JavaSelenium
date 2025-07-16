package runner_Week6Day1_HA_DP;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features_Week6Day1_HA_DP/features_Week6Day1_HA_1.feature"},
glue = {"steps_Week6Day1_HA_DP","hooks_Week6Day1_HA_DP"}, 
dryRun = false,publish=true,monochrome=true)
public class TC_001_Week6_Day1_HA_1 extends AbstractTestNGCucumberTests {

}
