package SeleniumModule1;

 import java.time.Duration;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.Set;
 import java.util.concurrent.TimeUnit;
 import org.openqa.selenium.Alert;
 import org.openqa.selenium.By;
 import org.openqa.selenium.JavascriptExecutor;
 import org.openqa.selenium.Keys;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.openqa.selenium.chrome.ChromeOptions;
 import org.openqa.selenium.edge.EdgeDriver;
 import org.openqa.selenium.firefox.FirefoxDriver;
 //import org.openqa.selenium.opera.OperaDriver;
 import org.openqa.selenium.support.ui.ExpectedConditions;
 import org.openqa.selenium.support.ui.Select;
 import org.openqa.selenium.support.ui.WebDriverWait;

 public class Assignment1 extends Application {

	public WebDriver driver;
	 
	public void amazon() throws InterruptedException
	{
		System.setProperty("webdriver.edge.driver", "C:\\Selenium Temp\\EdgeDriver\\msedgedriver.exe");
	    driver = new EdgeDriver();

		driver.manage().window().maximize();
	    
	    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		driver.get("https://www.amazon.in/");
		
		String AmazonCurrentUrl = "https://www.amazon.in/";
		String AmazonTitle= "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		
		Set<String> windows = driver.getWindowHandles(); 
		System.out.println(windows); 
		
		if(driver.getCurrentUrl().equals(AmazonCurrentUrl) && driver.getTitle().equals(AmazonTitle))
		{
			System.out.println("Amazon Current Url is:" + AmazonCurrentUrl);
			System.out.println("AmazonTitle is:" + AmazonTitle);
		}

	    Select select = new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']"))); //Select Dropdown
	    select.selectByIndex(2);

	    List<WebElement> element = select.getOptions();
	    for(WebElement options: element)
		{
			if(options.getText().equals("Amazon Devices"))
			{
	     	  System.out.println("Amazon Devices");
			}
		}
		//Select Search Option
		WebElement amazon_search = driver.findElement(By.xpath("//input[@aria-label='Search Amazon.in']"));
		Thread.sleep(1000);
		amazon_search.click();
		amazon_search.sendKeys("Fire TV Stick with Alexa Voice Remote");
		Thread.sleep(1000);
		amazon_search.sendKeys(Keys.ENTER);
		
		WebElement Amazon_FireTVStick = driver.findElement(By.xpath("//span[text()='Fire TV Stick with Alexa Voice Remote (includes TV and app controls) | HD streaming device']"));
		Thread.sleep(5000);
		Amazon_FireTVStick.click();
		
//		WebElement Amazon_Cart = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[4]/div[12]/div[1]/div[5]/div/div[1]/div/div/div/form/div[1]/div/div/div/div[3]/div/div[33]/div[1]/span/span/span/input"));
//		Thread.sleep(2000);
//		Amazon_Cart.click();
		
		for(String first_window : windows) 
		{ 
		 Thread.sleep(1000); 	
		 driver.switchTo().window(first_window);
		 if(driver.getTitle().contains("Amazon.in : Fire TV Stick with Alexa Voice Remote")) 
		 {
			 System.out.println("We are on first window");
			 WebElement homepage = driver.findElement(By.xpath("//a[@href='/ref=nav_logo']"));
			 Thread.sleep(1000); 
			 homepage.click();
		 }
		}
		
	     driver.navigate().forward();
		 Thread.sleep(1000);
		 driver.navigate().back();

	   }	
	
	    
        public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
    
	    Assignment1 browser = new Assignment1();
	    browser.amazon();
	    browser.facebook();
	    browser.firefoxverify();
  }
 }