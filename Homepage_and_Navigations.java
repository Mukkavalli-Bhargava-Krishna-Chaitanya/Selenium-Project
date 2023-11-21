package Amazon_Application;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

@Listeners(Amazon_Listeners.class)
public class Homepage_and_Navigations 
{

    WebDriver driver;
    SoftAssert softAssert;


    @BeforeMethod
    public void setup() 
    {
    	
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhargava Krishna\\Desktop\\Testing Softwares\\LATEST VERSION\\SELENIUM AND DRIVERS\\Chrome Driver - Version 2\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
        
    }

    @AfterMethod
    public void tearDown() 
    {
    	
        if (driver != null) 
        {
        	
            driver.quit();
            
        }
        
        softAssert.assertAll();
        
    }
    
    @Test(priority = 1)
    public void Homepage_and_Navigation_on_Homepage() 
    {
        
    	WebElement mobiles = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[5]"));
        softAssert.assertTrue(mobiles.isDisplayed(), "Mobiles link is not displayed");
        mobiles.click();
        Screenshots("Mobiles Link is Clicked");

        WebElement smartphonesBasicMobiles = driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[1]/ul/li[6]/span/a/span"));
        softAssert.assertTrue(smartphonesBasicMobiles.isDisplayed(), "Smartphones & Basic Mobiles sublink is not displayed");
        smartphonesBasicMobiles.click();
        Screenshots("Smart phones & Basic Mobiles Link is Clicked");
        
        System.out.println("Homepage is loading and internal navigations are working fine");
        
        
    }
    
    private void Screenshots(String File_Name) 
    {
        File Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        try 
        {
            SimpleDateFormat Date_Format = new SimpleDateFormat("ddMMyyyy_HHmmss");
            String Timestamp = Date_Format.format(new Date());
            Files.copy(Screenshot.toPath(), new File("C:\\Users\\Bhargava Krishna\\Desktop\\Selenium Projects\\Amazon Application\\Amazon Test Cases - Screenshots\\Homepage_and_Navigations\\" + File_Name + "_" + Timestamp + ".png").toPath());
            
        } 
        catch (IOException e) 
        {
            
        }
    }

    
}
