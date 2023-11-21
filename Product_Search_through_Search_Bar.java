package Amazon_Application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.Scanner;
import java.util.Set;


@Listeners(Amazon_Listeners.class)
public class Product_Search_through_Search_Bar 
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
    public void Product_Search_Via_Search_Bar() throws InterruptedException {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter your Query to Search");
        String Query = obj.nextLine();

        Thread.sleep(3000);

        WebElement Search_Input = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        Search_Input.sendKeys(Query);

        Thread.sleep(3000);

        WebElement Search_Button = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
        Search_Button.click();

        WebElement Product = driver.findElement(By.linkText("ASUS [SmartChoice] Vivobook 15, Intel Celeron N4020, 15.6\" (39.62 cms) HD, Thin and Light Laptop (8GB/512GB SSD/Integrated Graphics/Windows 11/Office 2021/Fingerprint/Silver/1.8 kg), X515MA-BR024WS"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Product);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(Product));

        Assert.assertTrue(Product.isDisplayed(), "Product not found on the search results page");
        Product.click();

        Switch_To_New_Tab();

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");

        WebElement Add_to_Cart = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));

        Assert.assertTrue(Add_to_Cart.isDisplayed(), "Add to Cart button not found on the product page");
        Add_to_Cart.click();

        Thread.sleep(10000);
        
        System.out.println("Product Search through Search Bar is successful and Item added to Cart");
        
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