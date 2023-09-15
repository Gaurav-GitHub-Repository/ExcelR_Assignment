package SeleniumModule2;

	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;	
	import org.openqa.selenium.WebDriver;
 	import org.openqa.selenium.WebElement;
 	import org.openqa.selenium.chrome.ChromeDriver;

 	public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
	

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step1
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		
		WebElement CustomerID = driver.findElement(By.name("cusid"));
		WebElement SubmitButton = driver.findElement(By.name("submit"));
		
		//Step2
		Thread.sleep(1000);
		CustomerID.sendKeys("53920");
		//Step3
		Thread.sleep(1000);
		SubmitButton.click();
		
		//Step4
		//Switching to alert
		Alert alert = driver.switchTo().alert();
		
		//capturing the alert message
	    String alertmessage = driver.switchTo().alert().getText();
	    if(alertmessage.equals("Do you really want to delete this Customer?"))
	    {
	        System.out.println(alertmessage);
	        Thread.sleep(1000);
	        alert.accept(); 
	    }
		
	    //Step5
	    String AlertMessage = "Customer Successfully Delete!"; 
	    if(AlertMessage.equals("Customer Successfully Delete!"))
	    {
	    	System.out.println(AlertMessage);
	    	Thread.sleep(1000);
	        alert.accept(); 
	    }
	    driver.quit();
		}
	
	}


