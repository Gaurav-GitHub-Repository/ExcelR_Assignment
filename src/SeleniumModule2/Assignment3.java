	package SeleniumModule2;

	import java.util.HashMap;
	import java.util.Map;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.io.FileHandler;
	//import FileUtils.Utility;
	import java.io.*;
	
 	public class Assignment3  {

 	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
	    ChromeOptions roptions = new ChromeOptions();
	    roptions.setExperimentalOption("prefs", prefs);
	    
	    WebDriver driver = new ChromeDriver(roptions);
		driver.manage().window().maximize();

		//Step1	
		driver.get("https://jqueryui.com/");
	
		//Step2
		WebElement DraggableLink = driver.findElement(By.xpath("//a[text()='Draggable']"));	
		Thread.sleep(1000);
		DraggableLink.click();
		
		WebElement frame_element = driver.findElement(By.xpath("//*[@class='demo-frame']"));
		driver.switchTo().frame(frame_element);
		
		Actions action = new Actions(driver);
		WebElement from = driver.findElement(By.xpath("//div[@id='draggable']/p"));
		
	    //Step3
		WebElement to = driver.findElement(By.xpath("//body"));
        String target_element = to.getText();
        System.out.println(target_element);
        
        action.dragAndDrop(from, to).build().perform();
        
    	//Step4
        try {
        	Thread.sleep(1000);	
        	TakesScreenshot srceenshot = ((TakesScreenshot)driver);
        	File srcfile = srceenshot.getScreenshotAs(OutputType.FILE);
        	File Destination = new File("C:\\Users\\Gaurav\\Documents\\Srceenshot\\DragandDrop.png");
        	FileHandler.copy(srcfile, Destination);	
            }
        catch(InterruptedException e)
        {
        	throw e;
        }
        driver.quit();
	}

}
