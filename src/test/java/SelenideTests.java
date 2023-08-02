import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTests {
    public SelenideTests(){
        Configuration.timeout=10000;
        Configuration.browser = "chrome";
        Configuration.browserSize="1920x1080";
        baseUrl="http://the-internet.herokuapp.com";
        reportsFolder = "src/main/resources/Reports";
        downloadsFolder="src/main/resources/images";
    }

    @Test(groups = {"testGroup"})
    public void screenshot() {
        open(baseUrl);
        $(byId("content")).shouldBe(visible).click();
        //  sleep(4000);
    }

    @Test(groups = {"testGroup"})
    public void selniumVsSelenide() {
        //selenide
        open("https://www.lambdatest.com/selenium-playground/checkbox-demo");
        $("#isAgeSelected").click();
        SelenideElement successText = $("#txtAge");
        successText.should(appear);
        successText.shouldHave(exactText("Checked"));
        successText.shouldHave(text("ked"));
        //sleep(4000);
    }
    @Test
    public void selectors() {
        open("https://www.lambdatest.com/selenium-playground/checkbox-demo");
        $("#isAgeSelected").click();
        $(byText("Checked")).shouldBe(appear);
        $(withText("cked")).should(appear);
        sleep(4000);
    }
    @Test(retryAnalyzer = RetryUsage.class)
    public void className() {
        open("https://demo.guru99.com/test/selenium-xpath.html");
        $(".thick-heading").shouldHave(exactText("Tutorials Library"));
        $(by("title", "SQL")).shouldBe(visible);
        SelenideElement agile = $(byTitle("Agile Testing"));
        agile.shouldNotBe(visible);
    }
}
