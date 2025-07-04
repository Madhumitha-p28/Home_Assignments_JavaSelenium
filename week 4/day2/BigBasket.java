package week4.week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class BigBasket {

	public static void main(String[] args) throws InterruptedException, IOException {

		// LAUNCH BROWSER
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		Actions actions = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// LAUNCH URL
		driver.get("https://www.bigbasket.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// CLICK ON SHOP BY CATEGORY
		WebElement eleCategory = driver.findElement(By.xpath("(//span[text()='Shop by']/ancestor::button)[2]"));
		eleCategory.click();
		Thread.sleep(2000);

		// TRAVERSE TO FOODGRAINS OIL AND MASALA
		List<WebElement> eleMainCategory = driver
				.findElements(By.xpath("(//div[contains(@class,'CategoryMenu___StyledMenuItems')])[2]//li"));

		for (int i = 1; i < eleMainCategory.size(); i++) {

			WebElement eleItem = driver.findElement(
					By.xpath("(//div[contains(@class,'CategoryMenu___StyledMenuItems')])[2]//li[" + i + "]/a"));
			String strItem = eleItem.getText();

			switch (strItem) {
			case "Foodgrains, Oil & Masala":
				actions.moveToElement(eleItem).pause(1500).perform();
				break;

			default:
				continue;
			}

			// TRAVERSE TO RICE AND RICE PRODUCT
			List<WebElement> eleSubCategory = driver
					.findElements(By.xpath("(//div[contains(@class,'CategoryMenu___StyledMenuItems')]//ul)[5]/li"));

			for (int j = 1; j < eleSubCategory.size(); j++) {

				WebElement eleSubItem = driver.findElement(
						By.xpath("(//div[contains(@class,'CategoryMenu___StyledMenuItems')]//ul)[5]/li[" + j + "]/a"));
				String strSubItem = eleSubItem.getDomProperty("innerText");

				switch (strSubItem) {
				case "Rice & Rice Products":
					actions.moveToElement(eleItem).moveToElement(eleSubItem).pause(1500).perform();
					break;

				default:
					continue;
				}

				// TRAVERSE TO BOILED AND STEAM RICE
				List<WebElement> eleLastCategory = driver
						.findElements(By.xpath("(//div[contains(@class,'CategoryMenu___StyledMenuItems')]//ul)[6]/li"));

				for (int k = 1; k < eleLastCategory.size(); k++) {

					WebElement eleLastItem = driver.findElement(By.xpath(
							"(//div[contains(@class,'CategoryMenu___StyledMenuItems')]//ul)[6]/li[" + k + "]/a"));

					String strLastItem = eleLastItem.getDomProperty("innerText");

					switch (strLastItem) {

					case "Boiled & Steam Rice":
						actions.moveToElement(eleSubItem).moveToElement(eleLastItem).pause(1000).click().perform();

						break;

					default:
						continue;
					}
					break;

				}

				break;
			}
			break;
		}
		// Thread.sleep(2000);

		// CHOOSE THE BRAND FROM CHECKBOX
		WebElement eleBrand = driver.findElement(By.xpath("//input[@id ='i-bbRoyal']"));
		actions.click(eleBrand);
		Thread.sleep(2000);

		// FROM FILTER RESULTS CHOOSE TAMIL PONNI BOILED RICE
		List<WebElement> eleRiceNames = driver.findElements(By.xpath("//section[@class='z-10 ']/ul/li"));
		for (int i = 1; i < eleRiceNames.size(); i++) {

			String strRiceName = driver.findElement(By.xpath("//section[@class='z-10 ']/ul/li[" + i + "]//h3//h3"))
					.getText();

			if (strRiceName.equals("Tamil Ponni Boiled Rice")) {
				// CLICK ON TAMIL PONNI BOILED RICE
				WebElement eleRiceClick = driver
						.findElement(By.xpath("//section[@class='z-10 ']/ul/li[" + i + "]//h3//h3"));
				eleRiceClick.click();
				Thread.sleep(1000);

				// GET ALL THE WINDOWS ADDRESS
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> windows = new ArrayList<String>(windowHandles);

				// SWITCH TO THE WINDOW
				driver.switchTo().window(windows.get(1));

				// SELCT 5KG
				List<WebElement> eleKilos = driver.findElements(By.xpath("//div[@class='w-full']/div"));
				for (int j = 1; j < eleKilos.size(); j++) {

					WebElement eleKilo = driver
							.findElement(By.xpath("//div[@class='w-full']/div[" + j + "]/following::span"));
					if (eleKilo.getText().equals("5 kg")) {
						js.executeScript("arguments[0].click();", eleKilo);
						break;
					}
				}
				
				//GET THE PRICE
				WebElement elePrice = driver.findElement(By.xpath("//td[contains(@class,'Description')]"));
                System.out.println(elePrice.getText());
				// Thread.sleep(3000);

				// CLICK ON ADD TO BASKET
				WebElement eleAddtoBasket = driver.findElement(By.xpath("(//button[text()='Add to basket'])[1]"));
				js.executeScript("arguments[0].click();", eleAddtoBasket);

				// GET THE TEXT FROM THE MESSAGE DISPLAYED ONCE ADD TO BASKET IS CLICKED
				WebElement eleMessage = driver.findElement(By.xpath(
						"//div[contains(@class,'Toast___Styled')]//p[text()='An item has been added to your basket successfully']"));			
				if(eleMessage.getText().equals("An item has been added to your basket successfully"))
				{
					System.out.println("Success Message  "+eleMessage.getText() + " is verified");
				}
				else
				{
					System.out.println("Message not Verfied");
				}
				
				
				

				// TAKE SCREENSHOT OF THE IMAGE
				WebElement eleImage = driver.findElement(By.xpath("//div[@class='h-full w-full']//img"));
				// CHOOSE FILE TYPE
				File src = eleImage.getScreenshotAs(OutputType.FILE);
				// CREATE FOLDER
				File dest = new File("./ScreenShots/BigBasket.png");
				// MERGE SOURCE AND DESTINATION
				FileUtils.copyFile(src, dest);

				// CLOSE THE CURRENT WINDOW
				 driver.close();
				// CLOSE THE MAIN WINDOW
				 driver.quit();

				break;

			}

		}

	}

}
