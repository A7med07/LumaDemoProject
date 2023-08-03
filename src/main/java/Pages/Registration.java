package Pages;


import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration {
    private WebDriver driver;
    protected By firstname=By.xpath("//input[@id=\"firstname\"]");

    protected By lastname=By.xpath("//input[@id=\"lastname\"]");
    protected By email=By.xpath("//input[@id=\"email_address\"]");
    protected By password=By.id("password");
    protected By conPassword=By.id("password-confirmation");
    protected By submit=By.linkText("Create an Account");
    protected By wellcome=By.xpath("//span[@class=\"logged-in\"]");
    protected By strong_pass=By.className("password-strength-meter");
    protected By field=By.cssSelector("fieldset.create.info");


    public Registration(WebDriver driver) {
        this.driver=driver;
    }
    public void setEmail(String text) {
        (new ElementActions(driver)).hover(field).type(email,text);
    }
    public void setFirstname(String text) {
        (new ElementActions(driver)).hover(field).type(firstname,text);
    }
    public void setLastname(String text) {
        (new ElementActions(driver)).hover(field).type(lastname,text);
    }
    public void setPassword(String text) {
        (new ElementActions(driver)).hover(field).type(password,text);
    }
    public void setConPassword(String text) {
        (new ElementActions(driver)).hover(field).type(conPassword,text);
    }

    public void clickSubmit() {
        (new ElementActions(driver)).scrollToElement(submit).click(submit);
    }

    public By getSuccessMsg() {

        ElementActions.getInstance().getText(wellcome);
        return wellcome;
    }

    public By getStrong_pass() {
        ElementActions.getInstance().waitToBeReady(strong_pass).getText(strong_pass);
        return strong_pass;
    }
}
