package data;

import org.testng.annotations.DataProvider;

public class TestDataSource {
    @DataProvider(name = "data")
    public Object[][] getData(){
        return new Object[][] {
                {"ab.born19190@gmail.com","AH90****new"},
                {"ab.born19191@gmail.com", "AH90****new"},
                {"ab.born191912@gmail.com", "AH90****new"}
        };



    }
}
