package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import models.ApplicationModel;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;


public class Step1 {

    public Step1() {

    }
    private final Logger logger = LoggerFactory.getLogger(Step1.class);

    private final SelenideElement accountType = $(byName("account_type"));
    private final SelenideElement accountTypePrivate = $(byId("account_type-P"));
    private final SelenideElement accountTypeBusiness = $(byId("account_type-C"));
    private final SelenideElement leaseType = $(byName("lease_type"));
    private final SelenideElement leaseTypeHP = $(byId("lease_type-HP"));
    private final SelenideElement leaseTypeFL = $(byId("lease_type-FL"));
    private final SelenideElement priceField = $(byId("origin-price"));
    private final SelenideElement vatIncluded = $(byId("vat_included"));
    private final SelenideElement initialPercentage = $(byId("initial_percentage"));
    private final SelenideElement initialAmount = $(byId("initial"));
    private final SelenideElement durationYears = $(byName("duration_years"));
    private final SelenideElement durationMonths = $(byName("duration_months"));
    private final SelenideElement reminderPercentage = $(byName("reminder_percentage"));
    private final SelenideElement reminderValue = $(byId("reminder"));

    private final SelenideElement paymentDay = $(byName("payment_day"));


    private final SelenideElement vehicleCondition = $(byName("vehicle_condition"));

    public static String radioButton(String name, String value) {
         return String.format("input[name=\"%s\"][value=\"%s\"]", name, value);
     }

     public static SelenideElement submitButton() {
        return $(By.cssSelector("button[value='Edasi']"));
     }
    @Step("Submitting application step1")
    public void submitStep1(ApplicationModel applicationModel){
         priceField.waitUntil(Condition.exist, 3000).sendKeys(applicationModel.price);
         logger.info(applicationModel.price);
         initialAmount.scrollTo().sendKeys(applicationModel.initialAmount);
         sleep(2000);
         durationYears.selectOptionByValue(applicationModel.durationYears);
        sleep(2000);
         reminderValue.sendKeys(applicationModel.reminderValue);
        sleep(2000);
         paymentDay.selectOptionByValue(applicationModel.paymentDay);
         // Here should be waitUntil(condition.enabled, some timeout value), but fro some reason not working, needs more time to investigate
         sleep(1000);
         submitButton().click();
         vehicleCondition.waitUntil(Condition.appear,3000);
        sleep(3000);
    }

}
