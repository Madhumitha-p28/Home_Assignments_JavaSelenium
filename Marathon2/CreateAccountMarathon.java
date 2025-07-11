package week2.Marathon2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateAccountMarathon extends ProjectSpecificMethodMarathon {

	@BeforeTest
	public void setFilePath() {

		//GET THE FILE PATH AND SHEETNAME
		filePath = "Marathon2";
		sheetName = "CreateLead";
	}

	@Test(dataProvider = "fetchData")
	public void runCreateLead(String straccountName, String strownerShip) throws InterruptedException {

		// CLICK ON NEW ACCOUNT
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@title='New']")));
		Thread.sleep(0500);
		
		// ENTER THE ACCOUNT NAME
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input")).sendKeys(straccountName);
		
		// CLICK ON OWNERSHIP FIELD
		WebElement ownershipDD = driver.findElement(By.xpath("//button[@aria-label='Ownership']"));
		driver.executeScript("arguments[0].click()", ownershipDD);
		Thread.sleep(0500);
		
		// CLICK ON PUBLIC FROM OWNERSHIP FIELD
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='" + strownerShip + "']")).click();
		
		// CLICK ON SAVE BUTTON
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		// VERIFY ERROR MESSAGE
		try {
			String toastMessage = driver
					.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))
					.getText();
			System.out.println(toastMessage);
			Assert.assertTrue(toastMessage.contains(straccountName), "Verify the Account name");
		} catch (Exception e) {
			System.out.println("Data Saved - No Error Message is displayed");
		}

	}

}
