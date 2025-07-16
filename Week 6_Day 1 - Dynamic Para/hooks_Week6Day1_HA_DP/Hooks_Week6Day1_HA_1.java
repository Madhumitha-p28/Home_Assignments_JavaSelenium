package hooks_Week6Day1_HA_DP;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import base_Week6Day1_HA_DP.ProjectSpecificMethod_Week6Day1_HA_1;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks_Week6Day1_HA_1 extends ProjectSpecificMethod_Week6Day1_HA_1 {
	
	// BROWSER CONFIGURATIONS
	@Before
	public void preconditions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		// INTIALIZING DRIVER VARIABLE
		driver  = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}
	
	
	// CLOSE THE DRIVER
	@After
	public void postConditions() {
		driver.close();
	}

}
