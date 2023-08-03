package Pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;


    private By logIn=By.cssSelector("a[href=\"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/\"]");
    private By signUp= By.linkText("Create an Account");
    //private By links= By.xpath("//li[@class=\"authorization-link\"]");
    protected By panel_header=By.cssSelector(".panel.header");
    public HomePage(WebDriver driver) {
        this.driver=driver;
    }
    public loginPage sign_in(){
        driver.findElement(logIn).click();
        return new loginPage(driver);
    }
    public Registration clickRegister(){
        (new ElementActions(driver)).hover(panel_header).click(signUp);
        return new Registration(driver);
    }
    public forgetPasswordPage forget(){

        return new forgetPasswordPage(driver);
    }
    public ProductPage adToCart(){

        return new ProductPage(driver);
    }
    public AccountInfo checkAccountInfo(){

        return new AccountInfo(driver);
    }
    public Search searching(){

        return new Search(driver);
    }
}
