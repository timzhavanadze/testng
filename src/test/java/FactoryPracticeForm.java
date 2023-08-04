import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FactoryPracticeForm {
    private String firstName;
    private String lastName;
    private String gender;
    private String mobileNumber;

    public FactoryPracticeForm(String firstName, String lastName, String gender, String mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
    }
    @BeforeClass
    public void setUp() {
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
    }

    @Test
    public void factoryFormsTest() {
        open("");
        $("#firstName").sendKeys(firstName);
        $("#lastName").sendKeys(lastName);
        $(By.xpath("//label[@class='custom-control-label' and contains(text(), '" + gender + "')]")).click();
        $("#userNumber").sendKeys(mobileNumber);
    }

    @Factory
    public static Object[] factoryMethod() {
        return new Object[] {
                new FactoryPracticeForm("name", "lastanme", "Male", "5586986977"),
                new FactoryPracticeForm("Taha", "Aguilar", "Female", "5000000007"),
                new FactoryPracticeForm("Neo", "Simpson", "Other", "5001002007")};
    }

}