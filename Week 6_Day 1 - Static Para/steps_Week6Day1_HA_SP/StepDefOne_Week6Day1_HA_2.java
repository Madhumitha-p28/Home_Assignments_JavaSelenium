package steps_Week6Day1_HA_SP;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base_Week6Day1_HA_SP.ProjectSpecificMethod_Week6Day1_HA_2;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefOne_Week6Day1_HA_2 extends ProjectSpecificMethod_Week6Day1_HA_2 {

	//STATIC PARAMETERIZATION 
	
	// ENTER THE USERNAME
	@When("the user enters the Username as {string}")
	public void the_user_enters_the_username_as(String strUserName) {
		driver.findElement(By.id("username")).sendKeys("bhuvanesh.moorthy@testleaf.com");
	}
    // ENTER THE PASSWORD
	@When("the user enters the Password as {string}")
	public void the_user_enters_the_password_as(String strPasword) {
		driver.findElement(By.id("password")).sendKeys(strPasword);
	}

	// CLICK ON LOGIN BUTTON
	@When("the user clicks the login button")
	public void the_user_clicks_the_login_button() throws InterruptedException {
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
	}

	// GET THE PAGE TITLE
	@Then("the user should be navigated to the home page")
	public void the_user_should_be_navigated_to_the_home_page() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	// CLICK ON APP LAUNCHER ICON
	@When("the user clicks the App Launcher Icon")
	public void the_user_clicks_the_app_launcher_icon() throws InterruptedException {
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		Thread.sleep(2000);
	}
	
    // CLICK ON VIEW ALL
	@When("the user clicks on View All")
	public void the_user_clicks_on_view_all() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(2000);
	}

	// CLICK ON ACCOUNTS
	@When("the user clicks on the Accounts")
	public void the_user_clicks_on_the_accounts() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@data-label='Accounts']")));

		Thread.sleep(2000);

	}

}
