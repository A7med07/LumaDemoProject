package Pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductPage {
    private final WebDriver driver;
    protected By Circe_Hooded_Ice_Fleece=By.
            xpath("//img[@src=\"https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/7c4c1ed835fbbf2269f24539582c6d44/w/h/wh12-gray_main_1.jpg\"]");
    protected By Circe_Hooded_Ice_Fleece_Img=By.
            xpath("//img[@src=\"https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/d34482110da20c5e24f97c38fb219fb3/w/h/wh12-green_main_1.jpg\"]");
    protected By xs=By.id("option-label-size-143-item-166");
    protected By addToCart=By.
            xpath("//button[@id=\"product-addtocart-button\"]");
    protected By Green=By.
            xpath("//div[@option-label=\"Green\"]");
    protected By showCart=By.
            xpath("//a[@class=\"action showcart\"]");
    protected By proceedToCheckout=By.
            xpath("//button[@id=\"top-cart-btn-checkout\"]");
    protected By nextBt=By.
            xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button");
    protected By placeOrder=By.
            xpath("//button[@class=\"action primary checkout\"]");
    protected By successfulMsg=By.
            xpath("//div[@data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]");
    protected By successfulPlace_OrderMsg=By.
            xpath("//span[@class=\"base\"]");
    protected By buttonContainer=By.id("shipping-method-buttons-container");
    protected By header=By.className("page-title");

    public ProductPage(WebDriver driver) {
        this.driver=driver;
    }

    public void getCirce_Hooded_Ice_Fleece(){
        (new ElementActions(driver)).click(Circe_Hooded_Ice_Fleece);
    }

    public By getGreen() {
        (new ElementActions(driver)).click(Green);
        return Green;
    }

    public By getAddToCart() {
        (new ElementActions(driver)).scrollToElement(addToCart).click(addToCart);
        return addToCart;
    }

    public By getXs() {
        (new ElementActions(driver)).click(xs);
        return xs;
    }

    public By getCirce_Hooded_Ice_Fleece_Img() {
        (new ElementActions(driver)).waitToBeReady(Circe_Hooded_Ice_Fleece_Img)
                .captureScreenshot(Circe_Hooded_Ice_Fleece_Img);
        return Circe_Hooded_Ice_Fleece_Img;
    }

    public By getSuccessfulMsg() {
        (new ElementActions(driver)).getText(successfulMsg);

        return successfulMsg;
    }

    public By getShowCart() {
        ElementActions.getInstance().click(showCart);
        return showCart;
    }

    public By getNextBt() {
        ElementActions.getInstance().scrollToElement(buttonContainer).
                waitToBeReady(nextBt).clickUsingJavascript(nextBt);
        return nextBt;
    }

    public By getProceedToCheckout() {
        ElementActions.getInstance().click(proceedToCheckout);
        return proceedToCheckout;
    }

    public By getPlaceOrder() {
        ElementActions.getInstance().clickUsingJavascript(placeOrder);
        return placeOrder;
    }

    public By getSuccessfulPlace_OrderMsg() {
        (new ElementActions(driver)).waitToBeReady(successfulPlace_OrderMsg).getText(successfulMsg);
        return successfulPlace_OrderMsg;
    }

    public String getUrl() {
        String currentURL=ElementActions.getInstance().browser().capturePageSnapshot().getCurrentURL();
        return currentURL;
    }
}
