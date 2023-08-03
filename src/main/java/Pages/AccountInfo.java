package Pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AccountInfo {

   // protected By notLoggedName= By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[1]/span");
    protected By infoBox= By.cssSelector(".box.box-information");
    protected By changePass= By.cssSelector(".action.change-password");
    protected By edit= By.cssSelector("a[href=\"https://magento.softwaretestingboard.com/customer/account/edit/\"]");
    protected By myOrders= By.cssSelector("a[href=\"https://magento.softwaretestingboard.com/sales/order/history/\"]");
    protected By wishlist= By.cssSelector("a[href=\"https://magento.softwaretestingboard.com/wishlist/\"]");
    protected By orderMsg= By.cssSelector("div[class=\"message info empty\"]");
    protected By firstname= By.cssSelector("input[id=\"firstname\"]");
    protected By lastname= By.cssSelector("input[id=\"lastname\"]");
    protected By currentPass= By.cssSelector("input[id=\"current-password\"]");
    protected By newPass= By.cssSelector("input[id=\"password\"]");
    protected By confirmPass= By.cssSelector("input[id=\"password-confirmation\"]");
    protected By saveBt= By.cssSelector("button[class=\"action save primary\"]");
    protected By accountMenu= By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button");
    protected By myAccount= By.linkText("My Account");
    protected By changePassMsg= By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");
    protected By pass_Strength= By.id("password-strength-meter-container");
    protected By dashFrame= By.cssSelector(".block.block-dashboard-info");
    private WebDriver driver;
    public AccountInfo(WebDriver driver) {
        this.driver=driver;
    }
    public void setCurrentPassPassword(String text) {
        ElementActions.getInstance().scrollToElement(currentPass).type(currentPass,text);

    }

    public By getPass_Strength() {
        ElementActions.getInstance().waitForTextToChange(pass_Strength,"Password Strength: No Password\n").
                getText(pass_Strength);
        return pass_Strength;
    }

    public void setNewPass(String text) {
        ElementActions.getInstance().scrollToElement(newPass).type(newPass,text);
    }
    public void setConfirmPass(String text) {
        ElementActions.getInstance().scrollToElement(confirmPass).type(confirmPass,text);
    }

    public void getEdit() {
        WebElement clickEdit=driver.findElement(edit);
        clickEdit.click();
    }
    public void clickChangePass() {
        (new  ElementActions(driver)).scrollToElement(dashFrame).click(changePass);

    }

    public String getOrderMsg() {
        return driver.findElement(orderMsg).getText();
    }
    public String getMsg() {
        return driver.findElement(myOrders).getText();
    }
    public String getChangesMsg() {

        return ElementActions.getInstance().waitToBeReady(changePassMsg).getText(changePassMsg);
    }
    public void getWishlist() {
        WebElement clickWishlist= driver.findElement(wishlist);
        clickWishlist.click();
    }

   /* public String getLoggedName() {

        String st=driver.findElement(notLoggedName).getText();
        return st;
    }*/

    public String getInfoBox() {
        String info= driver.switchTo().frame((WebElement) infoBox).findElement(By.tagName("p")).getText();

        return info;
    }

    public void setSaveBt() {
        Actions actions=new Actions(driver);
        WebElement clickSave= driver.findElement(saveBt);
        WebElement move= driver.findElement(By.cssSelector("div[class=\"actions-toolbar\"]"));
        actions.moveToElement(move).scrollToElement(clickSave).perform();
        clickSave.click();


    }
    public void openAccountMenu() {
        ElementActions.getInstance().click(accountMenu);

    }
    public void clickAccount() {
        ElementActions.getInstance().waitToBeReady(myAccount).click(myAccount);
    }

    public void setFirstname(String first) {
        WebElement firstnameElement= driver.findElement(firstname);
        firstnameElement.clear();
        firstnameElement.sendKeys(first);
    }
    public void setLastname(String last) {
        WebElement lastnameElement= driver.findElement(lastname);
        lastnameElement.clear();
        lastnameElement.sendKeys(last);
    }
}
