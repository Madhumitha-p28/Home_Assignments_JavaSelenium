package week4.week4.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CompanyName extends ProjectSpecificMethodSalesforce {

	@Test
	public void CreateCompanyName() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// ENTER COMPANY NAME
		WebElement eleCompanyName = driver.findElement(By.xpath("//input[@name='CompanyName']"));
		eleCompanyName.sendKeys("TestLeaf");

		// ENTER DESCRIPTION
		WebElement eleDescription = driver.findElement(By.xpath("//textarea[@class = 'slds-textarea']"));
		eleDescription.sendKeys("Salesforces");

		// CLICK ON STATUS TO LIST DROPDOWN
		WebElement eleStatusClick = driver
				.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds')]"));
		eleStatusClick.click();
		Thread.sleep(1000);

		// SELECT STATUS
		WebElement eleActiveClick = driver.findElement(By.xpath("//span[text()='Active']"));
		js.executeScript("arguments[0].click();", eleActiveClick);

		// CLICK ON SAVE
		WebElement eleSaveClick = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		eleSaveClick.click();

		// CLICK ON CLOSE
		WebElement eleClose = driver.findElement(By.xpath("//button[@title='Close error dialog']"));
		eleClose.click();

		// GET THE ALERT MESSAGE
		WebElement eleAlertMessage = driver.findElement(By.xpath("//span[text()='Legal Entity Name']/parent::div"));
		System.out.println(eleAlertMessage.getText());
		String strMessage = eleAlertMessage.getText();

		// VERIFY THE ALERT MESSAGE
		if (strMessage.contains("Complete this field.")) {

			System.out.println("Field Missing message verified");
		} else {
			System.out.println("Not verified");
		}

	}

}
