  package SeleniumModule1;

  import java.util.List;
  import org.openqa.selenium.By;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.WebElement;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.support.ui.Select;
             
  public class Assignment2 {

  public static void main(String[] args)
            
  {
    System.setProperty("webdriver.chrome.driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
                
    //Step1 Launch URL
    driver.get("https://demo.guru99.com/test/radio.html");
 
    //Step2 Click on radiobutton
    WebElement radiobutton = driver.findElement(By.id("vfb-7-1"));
    radiobutton.click();
                        
    //Step3 Click on checkbox
    WebElement Checkbox2 = driver.findElement(By.id("vfb-6-1")); 
    Checkbox2.click();
          
    WebElement Checkbox3 = driver.findElement(By.id("vfb-6-2"));
    Checkbox3.click();
          
    String expectedtitle = "Radio Button & Check Box Demo";
                
    if(driver.getTitle().equals(expectedtitle))
       {
        System.out.println("RadioButton is Selected:"+" "+radiobutton.isSelected());   
        System.out.println("Checkbox2 is Selected:"+" "+Checkbox2.isSelected());
        System.out.println("Checkbox3 is Selected:"+" "+Checkbox3.isSelected());
    	}
                
   //Step4 Navigate to URL
    driver.navigate().to("https://demo.guru99.com/test/newtours/register.php");
                
   //Step5 Select Country
    WebElement Country = driver.findElement(By.name("country"));
                
   //Step6
    Select dropdown = new Select(Country);
    dropdown.selectByVisibleText("KUWAIT");
    
    List<WebElement> element = dropdown.getOptions();
    for(WebElement options: element)
	{
		if(options.getText().equals("KUWAIT"))
		{
     	  System.out.println("KUWAIT");
		}
	}
           
    String expectedtitle1 = "Register: Mercury Tours";
    if(driver.getTitle().equals(expectedtitle1))
    {
       System.out.println("Country is Displayed:"+" "+Country.isDisplayed());
       List<WebElement> elements = driver.findElements(By.name("country"));
       System.out.println("Number of Elements are:"+" "+elements.size());
    }  

    }
 }
             
            