import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Test1 {
    public Test1(){
        Configuration.timeout=10000;
        Configuration.browser = "chrome";
        Configuration.browserSize="1920x1080";
    }
    @BeforeMethod
    public void openLink() {
        open("https://www.lambdatest.com/selenium-playground/checkbox-demo");
    }
    @Test
    public void selectors() {
        $("#isAgeSelected").click();
        $(byText("Success - Check box is checked")).should(appear);
    }
    @Test
    public void selectors1() {
        $(byText("Success - Check box is checked")).shouldNotBe(visible);
    }
}
