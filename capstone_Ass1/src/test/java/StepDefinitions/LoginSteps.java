package StepDefinitions;

import java.time.Duration;
import java.util.Set;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.baseClass;

public class LoginSteps {

	public static WebDriver driver;
	WebElement ablinkelement;
	WebElement ablink;

	@Given("Launch the Url")
	public void Launch_the_Url() {

		// Implement the code to navigate to the login page
		System.out.println("inside Given");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ravi\\Downloads\\chromedriver-win64\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		System.out.println("Hi");

	}

	@When("Open the URL")
	public void Navigate_to_the_Url() {

		baseClass base = new baseClass(driver);
		// Implement the code to enter valid credentials
		System.out.println("inside When");
		driver.navigate().to("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();

	}

	@Then("verify the title of the Page")
	
	public void verify_the_title_of_the_page() {
		// Implement the code to verify redirection
		System.out.println("inside When");
		String actualtitle = driver.getTitle();
		String expectedtitle = "The Internet";
	
		Assert.assertEquals(expectedtitle, actualtitle);
		System.out.println(" The title of the page is --->" + actualtitle);

	}

	@Given("given the  AB Testing link")
	public void goto_ablink() {

		System.out.println("goto_ablink");
		baseClass base = new baseClass(driver);
		
	

	}

	@When("Click on the Link")
	public void click_on_the_Link() {
		baseClass base = new baseClass(driver);
		base.clickablink();

		System.out.println("click_on_the_Link");
//		

	}

	@Then("verify text on the Page")
	public void verify_text_on_the_Page() {
		// getting no of windows

		Set<String> prodwind = driver.getWindowHandles();
		System.out.println("popwindow is :::::" + prodwind);

		for (String windowHandle : prodwind) {
			if (!windowHandle.equals(prodwind)) {
				driver.switchTo().window(windowHandle);
			}
		}


		boolean TestVariationtext = driver.findElement(By.xpath("//*[text()=\"A/B Test Variation 1\"]")).isDisplayed();
		boolean TestControltext = driver.findElement(By.xpath("//*[text()=\"A/B Test Control\"]")).isDisplayed();

		System.out.println("The TestVariationtext is displayed: " + TestVariationtext);
		Assert.assertEquals(true, TestVariationtext);

		System.out.println("The TestControltext is displayed: " + TestControltext);
		Assert.assertEquals(true, TestControltext);

	}

	@Given("Navigate back to Home page")
	public void navigat_back_to_homepage() {

		// switch back to home page and click on dropdow link
		System.out.println("Navigate back to Home page --->");
		driver.navigate().back();
		String title2 = driver.getTitle();
		System.out.println(" title of the page is ---->" + driver.getTitle());

	}

	@When("click on dropdown link")
	public void click_on_dropdown_link() {

		System.out.println("click_on_dropdown_link --->");

	

		Set<String> prodwind2 = driver.getWindowHandles();
		System.out.println("popwindow is :::::" + prodwind2);
		for (String windowHandle : prodwind2) {
			if (!windowHandle.equals(prodwind2)) {
				driver.switchTo().window(windowHandle);
			}
		}

		baseClass base = new baseClass(driver);
		base.clickdropdownlink();
		System.out.println(" after click on dropdown --->");

	}

	@Then("Select Option1 value form drop down verify that its selected or not")
	public void verify_that_its_selected_or_not() {

		Select objSelect = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
		System.out.println("objSelect");

		// getting the list of options in the dropdown with getOptions()
		List<WebElement> op = objSelect.getOptions();
		int size = op.size();
		for (int i = 0; i < size; i++) {
			String options = op.get(i).getText();
			System.out.println(options);
		}

		objSelect.selectByVisibleText("Option 1");

		boolean opt1 = driver.findElement(By.xpath("//*[text()=\"Option 1\"]")).isSelected();
		System.out.println("The opt1 is selected : " + opt1);
		Assert.assertEquals(true, opt1);

	}

	@Given("Navigate backto HomePage")
	public void Navigate_backto_HomePage() {

		// switch back to home page from dropdow link
		driver.navigate().back();
	}

	@When("Click on Frames")
	public void Click_on_Frames() {

		baseClass base = new baseClass(driver);
		base.clickframes();

	}

	@Then("Verify the hyperlinks are presented on the Frames Page")
	public void verify_te_hyperlinks() {

		Set<String> prodwind3 = driver.getWindowHandles();
		System.out.println("popwindow is :::::" + prodwind3);
		for (String windowHandle : prodwind3) {
			if (!windowHandle.equals(prodwind3)) {
				driver.switchTo().window(windowHandle);
			}
		}

		boolean NestedFrames = driver.findElement(By.xpath("//a[@href=\"/nested_frames\"]")).isDisplayed();
		boolean iFrame = driver.findElement(By.xpath("//a[@href=\"/iframe\"]")).isDisplayed();

		System.out.println("The NestedFrames is displayed : " + NestedFrames);
		System.out.println("The iFrame is displayed : " + iFrame);

		Assert.assertEquals(true, NestedFrames);
		Assert.assertEquals(true, iFrame);

		// Get all the available Links
		List<WebElement> links = driver.findElements(By.tagName("a"));

		// Iterating through all the Links and printing link
		// text
		for (WebElement link : links) {
			System.out.println(link.getText());
		}

	}

}
