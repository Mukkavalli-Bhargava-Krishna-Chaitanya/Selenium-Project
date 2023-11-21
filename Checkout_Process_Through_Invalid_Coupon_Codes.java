package Amazon_Application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


@Listeners(Amazon_Listeners.class)
public class Checkout_Process_Through_Invalid_Coupon_Codes 
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
    public void tearDown(ITestResult result)
    {
        
        if (result.getStatus() == ITestResult.FAILURE) 
        {
        	
            Screenshots(result.getName() + "_FAILURE", true);
            
        }
        
        else 
        {
        	
            Screenshots(result.getName() + "_SUCCESS", true);
            
        }

        if (driver != null) 
        {
        	
            driver.quit();
            
        }
        
        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void Checkout_Negative_Scenario_Validation() throws InterruptedException 
    {
    	
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter your Query to Search");
        String Query = obj.nextLine();

        Thread.sleep(3000);

        WebElement Search_Input = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        softAssert.assertTrue(Search_Input.isDisplayed(), "Search input field is not displayed");
        Search_Input.sendKeys(Query);
        Thread.sleep(1000);     
        Screenshots("search_query_entered", false);

        Thread.sleep(3000);

        WebElement Search_Button = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
        softAssert.assertTrue(Search_Button.isDisplayed(), "Search button is not displayed");
        Search_Button.click();
        Thread.sleep(1000);
        Screenshots("search_button_clicked", false);

        Thread.sleep(1000);

        WebElement Product = driver.findElement(By.linkText("Mens Shuttle Walking Shoe"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Product);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");

        softAssert.assertTrue(Product.isDisplayed(), "Product not found on the search results page");
        Product.click();
        Screenshots("product_clicked", false);

        Switch_To_New_Tab();

        WebDriverWait newTabWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        newTabWait.until(ExpectedConditions.numberOfWindowsToBe(2));

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");

        WebElement Buy_Now = driver.findElement(By.id("buy-now-button"));
        softAssert.assertTrue(Buy_Now.isDisplayed(), "Buy now button is not displayed");
        Buy_Now.click();
        Screenshots("buy_now_button_clicked", false);
        
        Thread.sleep(1000);
        
        WebElement email = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
        softAssert.assertTrue(email.isDisplayed(), "Email field is not displayed");
        email.sendKeys("");
        Screenshots("email_entered", false);
        
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        softAssert.assertTrue(continueButton.isDisplayed(), "Continue button is not displayed");
        continueButton.click();
        Screenshots("continue_button_clicked", false);

        Thread.sleep(3000);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
        password.sendKeys("");
        Screenshots("password_entered", false);
        
        Thread.sleep(1000);
        
        WebElement keepMeSignedIn = driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[2]/div/form/div/div[2]/div/div/label/div/label/input"));
        
        if (keepMeSignedIn.isSelected()) 
        {
            
            keepMeSignedIn.click();
            Screenshots("keep_me_signed_in_clicked", false);
            
        }
        
        Thread.sleep(1000);
        
        WebElement signinAfterPassword = driver.findElement(By.id("signInSubmit"));
        signinAfterPassword.click();
        Screenshots("signin_after_password_clicked", false);
        
        //Thread.sleep(2000);
        
        //WebElement OTP = driver.findElement(By.xpath("//*[@id=\"auth-mfa-otpcode\"]"));
        
        //if (OTP.isDisplayed()) 
        //{
        	
        	//Thread.sleep(40000);
            //Screenshots("otp_entered", false);
            
            //WebElement signinAfterOTP = driver.findElement(By.xpath("//*[@id=\"auth-signin-button\"]"));
            //signinAfterOTP.click();
            //Screenshots("signin_after_otp_clicked", false);
            
            //Thread.sleep(20000);
            
        //}
        
        
        //WebElement Use_this_Address = driver.findElement(By.id("shipToThisAddressButton"));
        //Use_this_Address.click();
        //Screenshots("use_this_address_clicked", false);
        
        Thread.sleep(45000);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement Enter_Code = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name=\"ppw-claimCode\"]")));
        Enter_Code.sendKeys("AMAZON");
        Screenshots("use_this_address_clicked", false);
        
        Thread.sleep(3000);
        
        WebElement Apply = driver.findElement(By.xpath("//input[@value=\"Apply\"]"));
        Apply.click();
        Screenshots("apply_button_clicked", false);
        
        Thread.sleep(2000);
        
        WebElement Error_Message = driver.findElement(By.xpath("//*[@id=\"pmts-claim-code-error-messages\"]/div[2]/div/div/div/p"));
        softAssert.assertTrue(Error_Message.isDisplayed(), "Error message is not displayed");
        softAssert.assertTrue(Error_Message.getText().contains("The promotional code you entered is not valid."),"Invalid error message text");

        Screenshots("error_message_displayed", false);

        System.out.println("Checkout Process is validated with invalid code and working as expected");
        
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
    
    private void Screenshots(String File_Name, boolean forceCapture) 
    {
        
        int randomNumber = new Random().nextInt(10);

        if (forceCapture || randomNumber < 5) 
        {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            try 
            {
                SimpleDateFormat Date_Format = new SimpleDateFormat("ddMMyyyy_HHmmss");
                String Timestamp = Date_Format.format(new Date());
                FileUtils.copyFile(screenshot, new File("C:\\Users\\Bhargava Krishna\\Desktop\\Selenium Projects\\Amazon Application\\Amazon Test Cases - Screenshots\\Checkout_Process_Through_Invalid_Coupon_Codes\\" + File_Name + "_" + Timestamp + ".png"));

            } 
            catch (IOException e) 
            {
                
            }

            System.out.println("Screenshot captured: " + File_Name);
        }
    }
}
