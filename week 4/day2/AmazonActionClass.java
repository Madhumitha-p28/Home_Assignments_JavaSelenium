package week4.week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class AmazonActionClass {

	public static void main(String[] args) throws IOException, InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		Actions actions = new Actions(driver);

		// LAUNCH URL
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// SEARCH FOR ONE PLUS 9 PRO
		WebElement eleSearch = driver.findElement(By.id("twotabsearchtextbox"));
		eleSearch.sendKeys("One Plus 9 Pro");

		// PRESS ENTER USING ACTION CLASS
		actions = new Actions(driver);
		actions.keyDown(Keys.ENTER);
		actions.keyUp(Keys.ENTER).perform();
		Thread.sleep(1000);

		// GET THE PRICE TEXT FROM THE FIRST DISPLAYED PRODUCT
		WebElement elePrice = driver.findElement(By.xpath(
				"//a[@class='a-link-normal s-no-hover s-underline-text s-underline-link-text s-link-style a-text-normal']//span/span"));
		String strPrice = elePrice.getDomProperty("innerText");
		System.out.println("Price = " + strPrice);

		// MOUSEHOVER ON STAR ICON
		actions = new Actions(driver);
		WebElement starIcon = driver.findElement(By.xpath("(//i[@data-cy='reviews-ratings-slot'])[1]"));
		actions.moveToElement(starIcon).click().pause(2000).perform();

		// GET TEXT FROM STAR RATINGS
		WebElement eleRate = driver.findElement(By.xpath("//h2[@id='acr-popover-title']/span"));
		System.out.println("Customer Star Ratings Dom= " + eleRate.getDomProperty("innerText"));

		// GET TEXT FROM GLOBAL RATINGS
		WebElement reviewCount = driver
				.findElement(By.xpath("//span[@class='a-size-base a-color-secondary totalRatingCount']"));
		System.out.println("Customer Ratings =" + reviewCount.getText());

		// CLICK ON THE FIRST PRODUCT
		WebElement eleFirstProduct = driver
				.findElement(By.xpath("(//div[contains(@class,'title-instructions-style')]//h2/span)[1]"));
		eleFirstProduct.click();

		// TAKE SCREENSHOT OF THE PRODUCT IMAGE
		WebElement eleImage = driver.findElement(By.xpath("//div[@id='imgTagWrapperId']/img"));
		// CHOOSE FILE TYPE
		File src = eleImage.getScreenshotAs(OutputType.FILE);
		// CREATE FOLDER
		File dest = new File("./ScreenShots/MobileImage.png");
		// MERGE SOURCE AND DESTINATION
		FileUtils.copyFile(src, dest);

		// CLICK ON ADD TO CART
		WebElement eleAddToCart = driver.findElement(By.xpath("(//input[@name='submit.add-to-cart'])[2]"));
		eleAddToCart.click();

		// GET THE TEXT FROM THE CART SUBTOTAL
		WebElement eleCartPrice = driver.findElement(By.xpath("//span[@class='a-price sw-subtotal-amount']/span"));
		String strCartPrice = eleCartPrice.getDomProperty("innerText").replaceAll(".00", "");
		System.out.println("Cart SubTotal = " + strCartPrice);

		// VERIFY THE PRICE IN RESULTS PAGE AND CART PAGE ARE SAME
		if (strPrice.replaceAll("[^a-zA-Z0-9]", "").equalsIgnoreCase(strCartPrice.replaceAll("[^a-zA-Z0-9]", ""))) {

			System.out.println("Price are matched");
		} else {
			System.out.println("Price is mismatched");
		}
		
		// CLOSE THE DRIVER
		driver.close();

	}
}