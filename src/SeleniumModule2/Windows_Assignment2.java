package SeleniumModule2;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows_Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://demo.guru99.com/popup.php");
	
	WebElement linktext = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
	linktext.click();	
	
	System.out.println(driver.getTitle());
	Set<String> windows = driver.getWindowHandles(); 
	System.out.println(windows); 
	 
	for(String window : windows) 
	{ 
	  if(driver.getTitle().equals("Guru99 Bank Home Page"))
	  {
	   driver.switchTo().window(window);
	  }
	}
	
	WebElement EmailID = driver.findElement(By.name("emailid"));
	Thread.sleep(1000);
	EmailID.sendKeys("gaurav.pathangej@gmail.com");
	
	WebElement SubmitButton = driver.findElement(By.name("btnLogin"));
	Thread.sleep(1000);
	SubmitButton.click();
	
	
	driver.quit();
}
}