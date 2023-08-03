package tests;

import Base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidData extends BasePage {
    @Test
    public void checkInvalidLoginData(){

        var loginpage=homePage.sign_in();
        loginpage.setEmail("invaliduser@test.com");
        loginpage.setPassword("123456");
        loginpage.clickSignButton();
        Assert.assertEquals(loginpage.setIncorrectEmailMsg(),"The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.",
                "failed to assert massage");
    }
}
