package hooks_Week6Day1_HA_SP;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import base_Week6Day1_HA_SP.ProjectSpecificMethod_Week6Day1_HA_2;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks_Week6Day1_HA_2 extends ProjectSpecificMethod_Week6Day1_HA_2 {
	
	// BROWSER CONFIGURATIONS
	@Before
	public void preconditions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		// INITIALIZING DRIVER VARIABLE
		driver  = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");

	}
	
	
	// CLOSE THE BROWSER
	@After
	public void postConditions() {
		driver.close();
	}

}
