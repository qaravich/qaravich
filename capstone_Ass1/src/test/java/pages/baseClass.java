package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseClass {

	WebDriver driver;
	WebElement ablinkelement;
	WebElement ablink;

	By link_ab = By.xpath("//a[@href=\"/abtest\"]");
	By link_dropdown = By.xpath("//a[@href=\"/dropdown\"]");
	By link_frames = By.xpath("//a[@href=\"/frames\"]");
	By ablinkelement1 = By.xpath("//a[@href=\"/abtest\"]");
	

	// constructor
	public baseClass(WebDriver driver) {
		this.driver = driver;
	}

	public void clickablink() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			// Wait until the demo button is clickable
			ablink = wait.until(ExpectedConditions.elementToBeClickable(ablinkelement1));
			System.out.println("hello------->");

			driver.findElement(link_ab).click();
		} catch (Exception e) {
			// Handle the case where the button is not clickable
			System.out.println("The 'ablinkelement' is not clickable or an error occurred.");
		}
		;

	}

	public void clickdropdownlink() {

		driver.findElement(link_dropdown).click();
	}

	public void clickframes() {

		driver.findElement(link_frames).click();
	}
}
