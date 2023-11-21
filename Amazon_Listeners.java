package Amazon_Application;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Amazon_Listeners implements ITestListener 
{

    WebDriver driver;

    @Override
    public void onTestFailure(ITestResult result) 
    {
    	
        System.out.println("Test Failed: " + result.getName());
        
    }

    @Override
    public void onTestSuccess(ITestResult result) 
    {
    	
        System.out.println("Test Passed: " + result.getName());
        
    }

    

    @Override
    public void onFinish(ITestContext context) 
    {
    	
        if (driver != null) 
        {
        	
            driver.quit();
            
        }
    }
}
