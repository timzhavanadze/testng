package Regression;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.*;

public class BeforeAfterMethod {
    public BeforeAfterMethod(){
        Configuration.timeout=20000;
        Configuration.browser = "chrome";
        Configuration.browserSize="1920x1080";
        //  baseUrl="http://the-internet.herokuapp.com";
    }
    @BeforeMethod
    public void openLink() {
        open("https://demo.guru99.com/test/selenium-xpath.html");
    }
    @Test
    public void test1() {
        $(".thick-heading").shouldHave(exactText("Tutorials Library"));
        SelenideElement reset = $(byName("btnReset"));
        reset.click();
    }
    @Test
    public void test2() {
        SelenideElement agile = $(byTitle("Agile Testing"));
        agile.shouldBe(visible);
    }
    @AfterMethod
    public void closeTab() {
        closeWebDriver();
        System.out.println("after method");
    }
}