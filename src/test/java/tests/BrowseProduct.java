package tests;

import Base.BasePage;
import com.shaft.validation.Validations;
import data.TestDataSource;
import org.testng.annotations.Test;

public class BrowseProduct extends BasePage {
    String mail="ab.born1994@gmail.com";
    String pass="AH90****new";

    @Test(priority = 1)
    public void checkSuccessfulLogin(){
        var loginPage=homePage.sign_in();
        loginPage.setEmail(mail);
        loginPage.setPassword(pass);
        loginPage.clickSignButton();
        loginPage.getHome();
    }
    @Test(priority = 2)
    public void checkSearchingForShirt(){
        String text="shirt";
        String option="name";
        var search=homePage.searching();
        search.setSearchField(text);
        Validations.assertThat().element(driver,search.getSearchResult()).text().isNotNull();
        Validations.assertThat().element(driver,search.getSearchResult()).text().contains(text);
        search.selectFromSorter_options(option);
        search.getResult();
        Validations.verifyThat().browser().url().contains("name&q=shirt");

    }

    @Test(dependsOnMethods = "checkSearchingForShirt",
    description = "given add Circe_Hooded_Ice_Fleece to shopping cart when valid user logged in then assert it")
    public void checkAddingProductToCart(){
        var product=homePage.adToCart();
        product.getCirce_Hooded_Ice_Fleece();
        product.getXs();
        product.getGreen();
        Validations.assertThat().element(product.getCirce_Hooded_Ice_Fleece_Img()).
                matchesReferenceImage().
                withCustomReportMessage("Assert that Green Product image is Displayed properly").
                perform();
        product.getAddToCart();
        product.getSuccessfulMsg();
        Validations.verifyThat().element(product.getSuccessfulMsg()).text().isTrue();
        product.getShowCart();
        product.getProceedToCheckout();
        product.getNextBt();
        product.getPlaceOrder();
        Validations.assertThat().element(product.getSuccessfulPlace_OrderMsg()).text().equals("Thank you for your purchase!");
        Validations.verifyThat().browser().url().equals(product.getUrl());
    }

}
