import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class ParametersTest {
    public ParametersTest(){
        Configuration.timeout=5000;
        Configuration.browser = "chrome";
        Configuration.browserSize="1920x1080";
    }
    @Test
    @Parameters({"firstName", "lastName", "gender", "number"})
    public void testWithParameters(String firstName, String lastName, String gender, String number){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").sendKeys(firstName);
        $("#lastName").sendKeys(lastName);
        $(byText(gender)).click();
        $("#userNumber").sendKeys(number);
        assertEquals(firstName, $("#firstName").getValue());
    }
}