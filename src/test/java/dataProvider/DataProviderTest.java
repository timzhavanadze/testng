package dataProvider;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
public class DataProviderTest {

    @Test(dataProvider = "data", dataProviderClass = TestData.class)
    public void test(String fname, String lname, String gender, String number){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").sendKeys(fname);
        $("#lastName").sendKeys(lname);
        $(By.xpath("//label[text()='"+gender+"']")).click();
        $("#userNumber").sendKeys(number);
        Assert.assertEquals(fname,$("#firstName").getValue());
    }
}
