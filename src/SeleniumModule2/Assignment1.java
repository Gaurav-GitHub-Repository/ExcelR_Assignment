    package SeleniumModule2;

    import java.util.List;
    import java.util.concurrent.TimeUnit;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    
    public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();

	driver.manage().window().maximize();
	
	//Step1 Launch URL
	driver.get("https://demo.guru99.com/test/web-table-element.php");
	
	//Step2&3 Retrieve the all company names
    int flag=0;
	
	WebElement table = driver.findElement(By.xpath("//table[contains(@class,'dataTable')]/tbody"));
	  
	String actualtitle = "Web Table Elements";
	if(driver.getTitle().contains("Web Tab"))
    {
		flag++;
    	System.out.println(table.getText());
    }
     if(flag==0) 
    {
    	System.out.println("Company names are not found");
	}
	
    //Step4 
    driver.navigate().to("https://demo.guru99.com/test/login.html");
    
    String ActualTitle = "Login Page";
    if(driver.getTitle().equals("Log"))
    {
    	System.out.println("Page Title is verfied");
    }
    
    WebElement Email = driver.findElement(By.id("email"));
    WebElement Password = driver.findElement(By.id("passwd"));
    WebElement SignInButton = driver.findElement(By.id("SubmitLogin"));
   
    //Step5 Enter Email
    Thread.sleep(1000);
	Email.sendKeys("gaurav.pathangej@gmail.com");
	
	//Step6 Enter Password
	Thread.sleep(1000);
	Password.sendKeys("Gaurav");
	
	//Step7 Click on Button
	Thread.sleep(1000);
	SignInButton.click();  
	
	WebElement RetrieveText = driver.findElement(By.xpath("//div[@align='center']/div/div/h3"));
	System.out.println(RetrieveText.getText());
	
	driver.quit();

	}
    }

	
