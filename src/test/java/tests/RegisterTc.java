package tests;

import Base.BasePage;
import com.shaft.validation.Validations;
import data.ReadSheet;
import data.TestDataSource;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTc extends BasePage {
    @Description("given register new users when data is valid  then assert it")

    @Test(priority = 1,dataProvider = "Test_Data",dataProviderClass = ReadSheet.class ,
    description = "check successfully register ")
    public void testSuccessfulRegister(String FirstName,String LastName,String Email,String Password,String ConfirmPassword){
        var register=homePage.clickRegister();

        register.setFirstname(FirstName);
        register.setLastname(LastName);
        register.setEmail("hh"+Email);
        register.setPassword(Password);
        register.setConPassword(ConfirmPassword);
        Validations.verifyThat().element(driver,register.getStrong_pass()).text().isTrue();
        register.clickSubmit();
        Validations.verifyThat().browser().url().contains("customer/account/");

    }


}
