package Base;
import Pages.HomePage;
import com.google.common.io.Files;
import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class BasePage {
    protected WebDriver driver;
    protected HomePage homePage;




    @BeforeClass
    public void SetUp(){
        driver= DriverFactory.getDriver();
        BrowserActions.getInstance().navigateToURL("https://magento.softwaretestingboard.com/");
         homePage=new HomePage(driver);
    }


    @AfterClass
    public void tearDown(){
        BrowserActions.getInstance().closeCurrentWindow();
    }


    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            TakesScreenshot camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot,
                        new File("C:\\Users\\A7med\\IdeaProjects\\luma\\src\\test\\resources"+
                                result.id()+ "  " +result.getName() + ".png"));
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
