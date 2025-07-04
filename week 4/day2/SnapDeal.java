package week4.week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class SnapDeal {

	public static void main(String[] args) throws IOException, InterruptedException {

		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		Actions action = new Actions(driver);

		// LOAD THE URL
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// MOUSEHOVER ON MEN'S FASHIO AND THEN TO SPORTS SHOES AND CLICK ON SPORTS SHOES
		WebElement eleMensFashion = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		WebElement eleSportsShoes = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		action.moveToElement(eleMensFashion).moveToElement(eleSportsShoes).click().perform();

		// GET THE SPORTS SHOES COUNT
		WebElement eleSportsShoeCount = driver.findElement(By.xpath("(//div[@class='child-cat-count '])[1]"));
		System.out.println("Sports Shoe Count " + eleSportsShoeCount.getText());

		// CLICK ON TRAINING SHOES
		WebElement eleTrainingShoes = driver.findElement(By.xpath("//div[text()='Training Shoes']"));
		eleTrainingShoes.click();
		
		// CLICK ON SORT 
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();

		// TRAVERSE THROUGH THE LIST TO SELECT PRICE LOW TO HIGH
		List<WebElement> eleSortOrder = driver.findElements(By.xpath("//div[@class='sorting-sec animBounce']//ul/li"));
		List<Integer> isListSorted = new ArrayList<Integer>();
		String str = "Price Low To High";
		for (int i = 1; i < eleSortOrder.size(); i++) {
			WebElement eleSort = driver
					.findElement(By.xpath("//div[@class='sorting-sec animBounce']//ul/li[" + i + "]"));

			String s = eleSort.getText();

			// CLICK ON THE PRICE LOW TO HIG
			if (s.replaceAll("[^a-zA-Z0-9]", "").equals(str.replaceAll("[^a-zA-Z0-9]", ""))) {
				eleSort.click();
				Thread.sleep(1000);
				break;

			}
		}

		// VERIFY THE RESULTS ARE SORTED
		List<WebElement> elePriceSort = driver
				.findElements(By.xpath("(//section[@class='js-section clearfix dp-widget dp-fired'])[1]/div"));

		for (int j = 1; j <= elePriceSort.size(); j++) {
			WebElement elePrice = driver
					.findElement(By.xpath("(//section[@class='js-section clearfix dp-widget dp-fired'])[1]/div[" + j
							+ "]//span[@class='lfloat product-price']"));
			String strPrice = elePrice.getText();
			strPrice = strPrice.replaceAll("[^\\d]", "");
			isListSorted.add(Integer.parseInt(strPrice));
		}
		
		System.out.println(isListSorted);
		int count = 0;
		for (int j = 0; j < isListSorted.size()-1; j++) {
			if (isListSorted.get(j) < isListSorted.get(j + 1)) {
				count++;
			}
		}
		
		if(count>0)
		{
			System.out.println("Prices are sorted");
		}

		// ENTER THE FROM PRICE
		WebElement eleFromPrice = driver.findElement(By.name("fromVal"));
		eleFromPrice.clear();
		eleFromPrice.sendKeys("500");

		// ENTER THE TO PRICE
		WebElement eleToPrice = driver.findElement(By.name("toVal"));
		eleToPrice.clear();		
		eleToPrice.sendKeys("700");
		
		// CLICK ON GO
		WebElement eleGo = driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow')]"));
		eleGo.click();
		Thread.sleep(1000);
		
		// CHOOSE THE COLOR FROM THE CHECKBOX
		WebElement eleColor = driver.findElement(By.xpath("//span[contains(@class,'filter-color-tile')]"));
		eleColor.click();

		// VERIFY THE FILTERS
		boolean selected = driver.findElement(By.xpath("//span[contains(@class,'filter-color-tile')]/parent::label/parent::div/input")).isSelected();
		String strSelectedSort = driver.findElement(By.xpath("//div[@class='sort-selected']")).getText();
		
		if (selected == true && strSelectedSort.equals("Price Low To High")) {
			System.out.println("The applied filters are verified");
		}

		// MOUSEHOVER ON THE FIRST DISPLAYED RESULTS
		WebElement eleFirstResult = driver.findElement(By.xpath("//img[@class ='product-image wooble']"));
		action.moveToElement(eleFirstResult).pause(2000).perform();

		// CLICK ON QUICK VIEW
		WebElement eleQuickView = driver.findElement(By.xpath("//div[contains(text(),'Quick View')]"));
		eleQuickView.click();
		Thread.sleep(1000);
		
		// GET THE PRODUCT PRICE
		WebElement eleProductPrice = driver
				.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span"));
		System.out.println("Product Price = Rs." + eleProductPrice.getText());

		// GET THE PRODUCT PERCENTAGE
		WebElement eleProductPerc = driver
				.findElement(By.xpath("//div[contains(@class,'product-price pdp')]/span/following-sibling::span"));
		System.out.println("Product Percentage = " + eleProductPerc.getText());

		// TAKE SCREENSHOT
		WebElement eleScreenShot = driver.findElement(By.xpath("//ul[@id='bx-slider-qv-image-panel']/li/img"));

		File src = eleScreenShot.getScreenshotAs(OutputType.FILE);
		// CREATE FOLDER
		File dest = new File("./ScreenShots/SnapDeal.png");
		// MERGE SOURCE AND DESTINATION
		FileUtils.copyFile(src, dest);

		// CLOSE THE CURRENT WINDOW
		driver.close();

	}

}
