package week2.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountSelect {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		Select sel;

		driver.get("http://leaftaps.com/opentaps/.");
		driver.manage().window().maximize();

		// ENTER USERNAME AND PASSWORD AND CLICK LOGIN
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		// CLICK ON CRM/SFA LINK AND CLICK ON ACCOUNTS TAB
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Accounts")).click();

		// CLICK ON CREATE ACCOUNT MENU
		driver.findElement(By.linkText("Create Account")).click();

		// PASS THE VALUES
		driver.findElement(By.id("accountName")).sendKeys("User23");
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		
		
		WebElement ddIndustry = driver.findElement(By.name("industryEnumId"));
		sel = new Select(ddIndustry);
		sel.selectByIndex(3);

		WebElement ddOwnership = driver.findElement(By.name("ownershipEnumId"));
		sel = new Select(ddOwnership);
		sel.selectByVisibleText("S-Corporation");

		WebElement ddSource = driver.findElement(By.id("dataSourceId"));
		sel = new Select(ddSource);
		sel.selectByValue("LEAD_EMPLOYEE");

		WebElement ddEcommerce = driver.findElement(By.id("marketingCampaignId"));
		sel = new Select(ddEcommerce);
		sel.selectByIndex(6);

		WebElement ddState = driver.findElement(By.id("generalStateProvinceGeoId"));
		sel = new Select(ddState);
		sel.selectByValue("TX");
		
		// CLICK ON CREATE ACCOUNT BUTTON
				driver.findElement(By.className("smallSubmit")).click();
				
				
				// GET THE TEXT FROM THE GRID
				String accname = driver.findElement(By.xpath("//span[contains(text(),'User23')]")).getText();
				
				
				String[] split = accname.split(" ");
				
				if(split[0].trim().equals("User23"))
				{
					System.out.println("Account is verified");
				}
				else
				{
					System.out.println("Title is not matching the requirement");
				}
				driver.close();

	}

}
