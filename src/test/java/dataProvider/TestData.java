package dataProvider;
import org.testng.annotations.*;

public class TestData {
    @DataProvider(name = "data")
    public Object[][] dpData(){
        return new Object[][] {
                {"Saxeli1", "Gvari1", "Female", "012345689"},
                {"Saxeli2", "Gvari2", "Male", "987654321"},
                {"Saxeli3", "Gvari3", "Other", "4206942069"}
        };
    }
}