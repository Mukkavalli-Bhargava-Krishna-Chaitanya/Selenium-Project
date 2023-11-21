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
public class Login_Functionality 
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
    public void Login_Functionality_Check() throws InterruptedException 
    {
    	
    	WebElement signIn = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
        softAssert.assertTrue(signIn.isDisplayed(), "Sign In link is not displayed");
        signIn.click();

        Thread.sleep(2000);

        WebElement email = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
        softAssert.assertTrue(email.isDisplayed(), "Email field is not displayed");
        email.sendKeys("");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        softAssert.assertTrue(continueButton.isDisplayed(), "Continue button is not displayed");
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
        
        //WebElement OTP = driver.findElement(By.xpath("//*[@id=\"auth-mfa-otpcode\"]"));
        
        //Thread.sleep(45000);
        
        //WebElement signinAfterOTP = driver.findElement(By.xpath("//*[@id=\"auth-signin-button\"]"));
        //signinAfterOTP.click();
        
        //Thread.sleep(20000);
        
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"auth-signin-button\"]")));
        
        WebElement Signin_Header = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Signin_Header).perform();
        
        WebElement Signout = driver.findElement(By.xpath("//*[@id=\"nav-item-signout\"]/span"));
        Signout.click();
        
        Thread.sleep(10000);
        
        WebElement Move_To_Home = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div[1]/div/a/i[1]"));
        Move_To_Home.click();
        
        Thread.sleep(5000);
        
        System.out.println("Login Functionality is Working Fine.");
        

    }

   
 }
