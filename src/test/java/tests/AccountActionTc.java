package tests;

import Base.BasePage;
import com.shaft.validation.Validations;
import data.TestDataSource;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountActionTc extends BasePage {



    @Description("check log in successfully when data is valid  then assert it")

    @Test(dataProvider ="TestDataSource" ,dataProviderClass = TestDataSource.class)
    public void successfulLoginTest(String mail,String pass)
    {
    var loginPage=homePage.sign_in();
    loginPage.setEmail(mail);
    loginPage.setPassword(pass);
    loginPage.clickSignButton();

        System.out.println(loginPage.getWelcomeMsg());
     Assert.assertNotNull(loginPage.getWelcomeMsg());
}
@Description("check Changing Password Of Registered Account then assert it")
    @Test
            (dependsOnMethods = "successfulLoginTest",
                    description = "check Changing Password Of Registered Account then assert it",
                    dataProvider ="TestDataSource" ,dataProviderClass = TestDataSource.class
                   )
    public void checkChangePassOfRegisteredAccountInfo(String mail,String pass){
        var account=homePage.checkAccountInfo();
        account.openAccountMenu();
        account.clickAccount();
        account.clickChangePass();
        account.setCurrentPassPassword(pass);
        account.setNewPass(pass);
        account.getPass_Strength();
        Validations.assertThat().element(account.getPass_Strength()).text().isTrue();
        account.setConfirmPass(pass);
        account.setSaveBt();
        Validations.assertThat().browser().url().doesNotContain("customer/account/");
      //  System.out.println(account.getChangesMsg());


    }
}
