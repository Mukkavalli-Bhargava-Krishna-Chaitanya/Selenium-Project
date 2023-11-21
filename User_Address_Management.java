package Amazon_Application;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


@Listeners(Amazon_Listeners.class)
public class User_Address_Management 
{

    WebDriver driver;
    WebDriverWait wait;
    SoftAssert softAssert;

    @BeforeTest
    public void setup() 
    {
    	
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhargava Krishna\\Desktop\\Testing Softwares\\LATEST VERSION\\SELENIUM AND DRIVERS\\Chrome Driver - Version 2\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        softAssert = new SoftAssert();
        
    }
    
    @AfterTest
    public void tearDown() 
    {
    	
        if (driver != null) 
        {
        	
            driver.quit();
            
        }
        
        softAssert.assertAll();
    }    

   
    @Test
    public void User_Address_Details_Management() throws InterruptedException 
    {
    	
    	WebElement signIn = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
        softAssert.assertTrue(signIn.isDisplayed(), "Sign In link is not displayed");
        signIn.click();
        
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
        email.sendKeys("");
        
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        continueButton.click();

        Thread.sleep(3000);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
        password.sendKeys("");
        
        Thread.sleep(1000);
        
        WebElement keepMeSignedIn = driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[2]/div/form/div/div[2]/div/div/label/div/label/input"));
        
        if (keepMeSignedIn.isSelected()) 
        {
            
            keepMeSignedIn.click();
            
        }
        
        Thread.sleep(1000);
        
        WebElement signinAfterPassword = driver.findElement(By.id("signInSubmit"));
        signinAfterPassword.click();
        
        Thread.sleep(60000);
        
        //WebElement Send_OTP = driver.findElement(By.xpath("//*[@id=\"auth-send-code\"]"));
        //Send_OTP.click();
        
        //Thread.sleep(2000);
        
        //WebElement OTP = driver.findElement(By.xpath("//*[@id=\"auth-mfa-otpcode\"]"));
        
        //Thread.sleep(45000);
        
        //WebElement signinAfterOTP = driver.findElement(By.xpath("//*[@id=\"auth-signin-button\"]"));
        //signinAfterOTP.click();
        
        //Thread.sleep(20000);
        
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"auth-signin-button\"]")));
        
        WebElement Signin_Header = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Signin_Header).perform();
        
        WebElement Your_Account = driver.findElement(By.xpath("//*[@id=\"nav-al-your-account\"]/a[1]/span"));
        Your_Account.click();
        
        Thread.sleep(10000);
        
        WebElement Your_Address = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span"));
        Your_Address.click();
        
        Thread.sleep(2000);
        
        WebElement Edit_Address = driver.findElement(By.xpath("//*[@id=\"ya-myab-address-edit-btn-1\"]"));
        Edit_Address.click();
        
        Thread.sleep(10000);
        
        WebElement Area = driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressLine2\"]"));
        Area.clear();
        
        Thread.sleep(3000);
        Area.sendKeys("HYDERABAD");
        
        WebElement Save_Changes = driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input"));
        Save_Changes.click();
        
        
        Thread.sleep(5000);
        
        WebElement Return_To_Homepage = driver.findElement(By.xpath("//*[@id=\"nav-logo-sprites\"]"));
        Return_To_Homepage.click();
        
        Thread.sleep(5000);
        
        System.out.println("User Address Management is Working Fine.");

    }
   
 }