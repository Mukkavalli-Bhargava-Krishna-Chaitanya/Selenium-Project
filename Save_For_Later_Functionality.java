package Amazon_Application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.Scanner;
import java.util.Set;

@Listeners(Amazon_Listeners.class)
public class Save_For_Later_Functionality 
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
    public void Save_For_Later_Functionality_Check() throws InterruptedException 
    {
    	
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter your Query to Search");
        String Query = obj.nextLine();

        Thread.sleep(3000);

        WebElement Search_Input = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        softAssert.assertTrue(Search_Input.isDisplayed(), "Search input field is not displayed");
        Search_Input.sendKeys(Query);

        Thread.sleep(3000);

        WebElement Search_Button = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
        softAssert.assertTrue(Search_Button.isDisplayed(), "Search button is not displayed");
        Search_Button.click();

        Thread.sleep(1000);

        WebElement Product = driver.findElement(By.linkText("Noise Twist Round dial Smart Watch with Bluetooth Calling, 1.38\" TFT Display, up-to 7 Days Battery, 100+ Watch Faces, IP68, Heart Rate Monitor, Sleep Tracking (Jet Black)"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Product);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");

        softAssert.assertTrue(Product.isDisplayed(), "Product not found on the search results page");
        Product.click();

        Switch_To_New_Tab();

        WebDriverWait newTabWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        newTabWait.until(ExpectedConditions.numberOfWindowsToBe(2));

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");

        WebElement Add_to_Cart = driver.findElement(By.id("add-to-cart-button"));
        softAssert.assertTrue(Add_to_Cart.isDisplayed(), "Add to Cart button is not displayed");
        Add_to_Cart.click();

        WebDriverWait Navigate_To_Cart_Button_Wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement Navigate_To_Cart_Button = Navigate_To_Cart_Button_Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id=\"attach-sidesheet-view-cart-button-announce\"]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Navigate_To_Cart_Button);

        Actions actions = new Actions(driver);
        actions.moveToElement(Navigate_To_Cart_Button).click().perform();
        
        Thread.sleep(20000);

        WebDriverWait Save_For_Later_Wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement Save_For_Later = Save_For_Later_Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Save for later']")));

        if (Save_For_Later.isDisplayed()) 
        {
        	
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Save_For_Later);
            Save_For_Later.click();

            Thread.sleep(5000);

            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");

            Thread.sleep(2000);

            System.out.println("Item is added & successfully moved to Save for Later section.");
            
        }
        
        obj.close();
    }

    

    private void Switch_To_New_Tab() 
    {
    	
        Set<String> handles = driver.getWindowHandles();
        
        for (String handle : handles) 
        {
        	
            driver.switchTo().window(handle);
            
        }
        
    }
}
