package week2.Marathon2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditAccountMarathon extends ProjectSpecificMethodMarathon {

	@BeforeTest
	public void setFilePath() {

		// GET THE FILE PATH AND SHEETNAME
		filePath = "Marathon2";
		sheetName = "EditLead";
	}

	@Test(dataProvider = "fetchData")
	public void runEditLead(String straccountName, String strType, String strIndustry, String strBillingAddress,
			String strShippingAddress, String strCustPriority, String strSLA, String strActive, String strUpsell)
			throws InterruptedException {

		// SEARCH THE ACCOUNT NAME IN SEARCH BOX
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']"))
				.sendKeys(straccountName + Keys.ENTER);
		Thread.sleep(1000);

		List<WebElement> noOfRows = driver.findElements(By.xpath("//table/tbody/tr"));
		int rowCount = noOfRows.size();

		for (int i = 1; i <= rowCount; i++) {
			WebElement eleAccName = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/th[1]/span//a//span"));
			String strName = eleAccName.getText();
			if (strName.equalsIgnoreCase(straccountName)) {
				// CLICK ON THE FIRST DISPLAYED NAME
				driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[6]")).click();
				Thread.sleep(1000);
				break;
			}
		}

		
		
		// CLICK ON EDIT
		driver.findElement(By.xpath("//a[@title='Edit']")).click();

		// CLICK ON TYPE FIELD AND SELECT THE TYPE VALUE FROM THE LIST
		WebElement typeDD = driver.findElement(By.xpath("//button[@aria-label='Type']"));
		driver.executeScript("arguments[0].click()", typeDD);
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='" + strType + "']")).click();

		// CLICK ON INDUSTRY FIELD AND SELECT THE TYPE VALUE FROM THE LIST
		WebElement industryDD = driver.findElement(By.xpath("//button[@aria-label='Industry']"));
		driver.executeScript("arguments[0].click()", industryDD);
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='" + strIndustry + "']")).click();

		// ENTER THE BILLING ADDRESS
		WebElement biilingStreet = driver.findElement(By.xpath("//label[text()='Billing Street']/following::textarea"));
		biilingStreet.clear();
		biilingStreet.sendKeys(strBillingAddress);

		// ENTER THE SHIPPING ADDRESS
		WebElement shippingStreet = driver
				.findElement(By.xpath("//label[text()='Shipping Street']/following::textarea"));
		shippingStreet.clear();
		shippingStreet.sendKeys(strShippingAddress);

		// CLICK ON CUSTOMER PRIORITY FIELD AND SELECT THE TYPE VALUE FROM THE LIST
		WebElement priorityDD = driver.findElement(By.xpath("//button[@aria-label='Customer Priority']"));
		driver.executeScript("arguments[0].click()", priorityDD);
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='" + strCustPriority + "']")).click();

		// CLICK ON SLA FIELD AND SELECT THE TYPE VALUE FROM THE LIST
		driver.findElement(By.xpath("//button[@aria-label='SLA']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='" + strSLA + "']")).click();

		// CLICK ON ACTIVE FIELD AND SELECT THE TYPE VALUE FROM THE LIST
		WebElement activeDD = driver.findElement(By.xpath("//button[@aria-label='Active']"));
		driver.executeScript("arguments[0].click()", activeDD);
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='" + strActive + "']")).click();

		// GENERATE A RANDOM NUMBER FOR PHONE NUMBER
		int randomNum1 = (int) (Math.random() * 999999);
		int randomNum2 = (int) (Math.random() * 999999);
		String phno = "" + randomNum1 + randomNum2;
		phno = phno.substring(0, 10);
		System.out.println(phno);

		// ENTER THE PHONE NUMBER
		WebElement phnoField = driver.findElement(By.xpath("//input[@name='Phone']"));
		phnoField.clear();
		phnoField.sendKeys(phno);

		// CLICK ON UPSELL OPPURTUNITY FIELD AND SELECT THE TYPE VALUE FROM THE LIST
		WebElement upsellOpportunityDD = driver.findElement(By.xpath("//button[@aria-label='Upsell Opportunity']"));
		driver.executeScript("arguments[0].click()", upsellOpportunityDD);
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='" + strUpsell + "']")).click();

		// CLICK ON SAVE
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String phnoStr = driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText();
		System.out.println(phnoStr);

		// VERIFY PHONE NUMBER
		Assert.assertTrue(phnoStr.contains(phno), "verify the mobileNumber");

	}

}
