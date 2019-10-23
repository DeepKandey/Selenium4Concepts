package seleniumPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GetRectMethodConcept {

	public static void main(String[] args) {
		// Setting driver executable system property
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/deepa/Downloads/Browser Drivers/Chrome Drivers/chromedriver.exe");
		// To suppress the Chrome logs on console before launch
		System.setProperty("webdriver.chrome.silentOutput", "true");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		WebElement emailTxt = driver.findElement(By.id("identifierId"));

		// Getting Height and Width using Dimension Class in Selenium 3
		Dimension emailTxtDim = emailTxt.getSize();
		System.out.println("Height of Email Text Button using Dimension: " + emailTxtDim.getHeight());
		System.out.println("Width of Email Text Button using Dimension: " + emailTxtDim.getWidth());

		// Getting X-Y coordinates using Point Class in Selenium 3
		Point emailTxtPoint = emailTxt.getLocation();
		System.out.println("Position of the Email Text Button from top side is: " + emailTxtPoint.getY());
		System.out.println("Position of the Email Text Button from left side is: " + emailTxtPoint.getX());
		// Using above coordinates, will move to element and enter input
		Actions action = new Actions(driver);
		action.moveToElement(emailTxt, emailTxtPoint.getX(), emailTxtPoint.getY()).sendKeys("Hey I reached here")
				.build().perform();

		// Getting Height and Width using Rectangle Class in Selenium 4
		Rectangle emailTxtRect = emailTxt.getRect();
		System.out.println("Height of Email Text Button using Rectangle: " + emailTxtRect.getHeight());
		System.out.println("Width of Email Text Button uisng Rectangle: " + emailTxtRect.getWidth());
		// X- Y coordinates
		System.out.println("Position of the Email Text Button from top side is: " + emailTxtRect.getY());
		System.out.println("Position of the Email Text Button from left side is: " + emailTxtRect.getX());
		action.moveToElement(emailTxt, emailTxtRect.getX(), emailTxtRect.getY()).sendKeys("Hey I reached here").build()
				.perform();

        driver.quit();
	}
}
