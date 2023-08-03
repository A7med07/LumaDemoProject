package Pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
   private WebDriver driver;
   protected By home= By.className("logo");
   protected By email=By.cssSelector("input[id=\"email\"]");
    protected By password=By.cssSelector("input[name=\"login[password]\"]");
    protected By panel_header=By.cssSelector(".panel.header");

    protected By signButton=By.cssSelector("button[class=\"action login primary\"]");
    protected By incorrectEmailMsg=By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div/text()");
    protected By welcomeMsg =By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[1]/span");
   protected By createAccount=By.cssSelector("a[href=\"https://magento.softwaretestingboard.com/customer/account/create/\"]");
    protected By forgetPass=By.cssSelector("a[href=\"https://magento.softwaretestingboard.com/customer/account/forgotpassword/\"]");


    public loginPage(WebDriver driver) {
        this.driver=driver;
    }

    public void setEmail(String text) {
        ElementActions.getInstance().clear(email).type(email,text);
    }

    public void setPassword(String text) {
        ElementActions.getInstance().type(password,text);
    }

    public void clickSignButton() {
        WebElement signIn= driver.findElement(signButton);
        signIn.click();
    }
    public String setIncorrectEmailMsg() {
        ElementActions.getInstance().waitToBeReady(incorrectEmailMsg);
       String text =ElementActions.getInstance().getText(incorrectEmailMsg);
        return text;
    }
    public String getWelcomeMsg() {
      //  driver.manage().deleteAllCookies();
        ElementActions.getInstance().hover(panel_header).waitForTextToChange(welcomeMsg,"Default welcome msg! ");
        WebElement passInput= driver.findElement(welcomeMsg);
       String text =passInput.getText();
        return text;
    }

    public forgetPasswordPage clickForgetPass() {
        WebElement resetPass= driver.findElement(forgetPass);
        resetPass.click();
        return new forgetPasswordPage(driver);
    }
    public Registration clickCreateAccount() {
        WebElement register= driver.findElement(createAccount);
        register.click();
        return new Registration(driver);
    }

    public void getHome() {
        ElementActions.getInstance().waitToBeReady(home).click(home);
    }
}
