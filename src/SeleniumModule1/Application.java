package SeleniumModule1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Application {

	
	    public void facebook() throws InterruptedException
	    {
	
        System.setProperty("webdriver.edge.driver", "C:\\Selenium Temp\\EdgeDriver\\msedgedriver.exe");
	    WebDriver driver = new EdgeDriver();
	   
	    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	    
	    driver.manage().window().maximize();
	    
	    driver.get("https://www.facebook.com/");
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	    String FacebookCurrentUrl = "https://www.facebook.com/";
	    String FacebookTitle = "Facebook – log in or sign up";
	    
	    if(driver.getCurrentUrl().equals(FacebookCurrentUrl) && driver.getTitle().equals(FacebookTitle))
		{
			System.out.println("Facebook Current Url is: " + FacebookCurrentUrl);
			System.out.println("Amazon Title is: " + FacebookTitle);
		}
	    
        WebElement EmailAddress = driver.findElement(By.xpath("//*[@id='email']"));
        WebElement Password = driver.findElement(By.xpath("//*[@id='pass']"));       
        WebElement LogIn = driver.findElement(By.xpath("//*[@name='login']")); 
        
        Thread.sleep(1000);
        EmailAddress.sendKeys("gaurav.pathangej@gmail.com");     

        Thread.sleep(1000);
        Password.sendKeys("Gaurav");
        
        Thread.sleep(1000);
        LogIn.click();
        
        String windowtitle = driver.getTitle();
        if(windowtitle.equals("Log in to Facebook"))
        {
        	driver.navigate().back();
        	Thread.sleep(1000);
        	driver.navigate().forward();
        }
        
	    }
        public void firefoxverify()
    	{
    		System.setProperty("webdriver.gecko.driver", "C:\\Selenium Temp\\FirefoxDriver\\geckodriver.exe");
    	    WebDriver driver = new FirefoxDriver();
    	    driver.manage().window().maximize();
    	    
    	    driver.get("https://www.amazon.in/");
    		
    		String AmazonCurrentUrl = "https://www.amazon.in/";
    		String AmazonTitle= "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
    		
    		if(driver.getCurrentUrl().equals(AmazonCurrentUrl) && driver.getTitle().equals(AmazonTitle))
    		{
    			System.out.println("Amazon Current Url is:" + AmazonCurrentUrl);
    			System.out.println("AmazonTitle is:" + AmazonTitle);
    		}
    	    
    		
    		driver.navigate().to("https://www.facebook.com/");
    	
    	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		
    	    String FacebookCurrentUrl = "https://www.facebook.com/";
    		String FacebookTitle = "Facebook – log in or sign up";
    		    
    		if(driver.getCurrentUrl().equals(FacebookCurrentUrl) && driver.getTitle().equals(FacebookTitle))
    			{
    				System.out.println("Facebook Current Url is: " + FacebookCurrentUrl);
    				System.out.println("Amazon Title is: " + FacebookTitle);
    			}
        
       }
}
