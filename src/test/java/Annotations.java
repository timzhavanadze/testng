import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class Annotations {
    public Annotations(){
        Configuration.timeout=5000;
        Configuration.browser = "chrome";
        Configuration.browserSize="1920x1080";
        baseUrl="http://the-internet.herokuapp.com";
        reportsFolder = "src/main/resources/Reports";
        downloadsFolder="src/main/resources/images";
    }
    @Test(successPercentage = 90)
    public void checkConditions() {
        open("/inputs");
        SelenideElement input =  $(".example input");
        input.setValue("3");
        input.shouldBe(empty);
    }
    @Test(enabled = false)
    public void handleDropDowns(){
        open("/dropdown");
        $("#dropdown").selectOption("Option 1");
        $("#dropdown").getSelectedOption().shouldHave(matchText("ption 1"),value("1"));
    }
    @Test(dependsOnMethods = "checkConditions", alwaysRun = true)
    public void fileDownload() throws FileNotFoundException {
        open("/download");
        $(byText("name.png")).download();
    }
    @Test(invocationCount = 3, threadPoolSize = 3)
    public void basicCommandsAndTimeout() {
        open("/dynamic_controls");
        SelenideElement enableButton= $(By.cssSelector("#input-example button"));
        enableButton.click();
    }
    @Test(timeOut = 30000, description = "open link and validate that element is not visible")
    public void basicCommandsAndTimeout1() {
        open("/dynamic_controls");
        SelenideElement enableButton= $(By.cssSelector("#xfgchgvfjk"));
        enableButton.shouldNotBe(visible);
    }
}