import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Test2 {
    public Test2(){
        Configuration.timeout=10000;
        Configuration.browser = "chrome";
        Configuration.browserSize="1920x1080";
    }
    @BeforeMethod
    public void openLink() {
        open("https://demo.guru99.com/test/selenium-xpath.html");
    }
    @Test
    public void className() {
        open("https://demo.guru99.com/test/selenium-xpath.html");
        $(".thick-heading").shouldHave(exactText("Tutorials Library"));
    }
    @Test
    public void className1() {
        open("https://demo.guru99.com/test/selenium-xpath.html");
        $(by("title", "SQL")).shouldBe(visible);
    }
}