import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SelenideTests2 {
    public SelenideTests2(){
        Configuration.timeout=10000;
        Configuration.browser = "chrome";
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
        Configuration.browserSize="1920x1080";
        baseUrl="http://the-internet.herokuapp.com";
        reportsFolder = "src/main/resources/Reports";
        downloadsFolder="src/main/resources/images";
    }
    @Test(groups = {"testGroup"})
    public void elementsCollection() {
        open("/add_remove_elements/");
        for (int i = 0; i <4 ; i++) {
            $(byText("Add Element")).click();
        }
        ElementsCollection deleteButtons = $$(By.cssSelector("#elements button"));
    }
    @Test(groups = {"testGroup"})
    public void checkConditions() {
        open("/inputs");
        $(".example input").setValue("3");
        $(".example input").shouldBe(not(empty));
        sleep(3000);
    }
    @Test
    public void handleDropDowns(){
        open("/dropdown");
        $("#dropdown").selectOption("Option 1");
        $("#dropdown").getSelectedOption().shouldHave(matchText("ption 1"),value("1"));
    }
}
