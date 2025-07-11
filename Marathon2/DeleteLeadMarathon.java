package week2.Marathon2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteLeadMarathon extends ProjectSpecificMethodMarathon {

	@BeforeTest
	public void setFilePath() {

		// GET THE FILE PATH AND SHEETNAME
		filePath = "Marathon2";
		sheetName = "DeleteLead";
	}

	@Test(dataProvider = "fetchData")
	public void runDeleteLead(String strAccountName) throws InterruptedException {

		// SEARCH THE ACCOUNT NAME IN SEARCH BOX
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']"))
				.sendKeys(strAccountName + Keys.ENTER);
		Thread.sleep(2000);

		// CHECK FOR THE NUMBER OF ITEMS IN THE LIST
		String noOfItems = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
		String[] s = noOfItems.split(" ");
		int countBeforeDelete = Integer.parseInt(s[0]);

		List<WebElement> noOfRows = driver.findElements(By.xpath("//table/tbody/tr"));
		int rowCount = noOfRows.size();

		for (int i = 1; i <= rowCount; i++) {
			WebElement eleAccName = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/th[1]/span//a//span"));
			String strName = eleAccName.getText();
			if (strName.equalsIgnoreCase(strAccountName)) {
				// CLICK ON THE FIRST DISPLAYED NAME
				driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[6]")).click();
				break;
			}
		}

		// CLICK ON DELETE
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		// CONFIRM DELETE RECORD
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		Thread.sleep(2000);

		// CHECK FOR NUMBER OF ITEMS AFTER DELETION
		noOfItems = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
		s = noOfItems.split(" ");
		int countAfterDelete = Integer.parseInt(s[0]);

		// VERIFY DELETION OF RECORD
		Assert.assertTrue(countBeforeDelete == (countAfterDelete + 1), "Verify the account has deleted");

	}

}
