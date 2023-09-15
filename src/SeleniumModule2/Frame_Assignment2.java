package SeleniumModule2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame_Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://www.guru99.com/handling-iframes-selenium.html");

		WebElement URL_Link = driver.findElement(By.xpath("//a[@href='https://demo.guru99.com/test/guru99home/']"));
		
       if(driver.getTitle().equals("How to Handle iFrames in Selenium Webdriver: switchTo()"))
       {
    	   Thread.sleep(1000);
    	   URL_Link.click();
       } 
		
	
	}

}
