package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forgetPasswordPage {
    private WebDriver driver;
    protected By note= By.cssSelector("div[class=\"field note\"]");
    protected By email= By.cssSelector("input[type=\"email\"]");
    protected By captchaField= By.cssSelector("input[id=\"captcha_user_forgotpassword\"]");
    protected By resetBt= By.cssSelector("button[class=\"action submit primary\"]");
    public forgetPasswordPage(WebDriver driver) {
        this.driver=driver;
    }
    public void   setEmail(String text) {
        WebElement emailInput= driver.findElement(email);
        emailInput.sendKeys(text);
    }

    public String getNote() {
        WebElement noteMsg= driver.findElement(note);
        String text =noteMsg.getText();
        return text;
    }

    public void setCaptcha(String text) {
        WebElement captchaInput= driver.findElement(captchaField);
        captchaInput.sendKeys(text);
    }

    public WebElement getResetBt() {
        WebElement click= driver.findElement(resetBt);
        click.click();
        return click;
    }
}
