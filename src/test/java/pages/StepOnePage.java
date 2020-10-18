package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import enums.AccountType;
import io.qameta.allure.Step;
import models.ApplicationModel;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;


public class StepOnePage {

    public StepOnePage() {

    }
    private final Logger logger = LoggerFactory.getLogger(StepOnePage.class);

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

     public void  applicantType(ApplicationModel application) {
        logger.info("Applicant type is : " + application.accountType.toString());
        if (application.accountType.toString() == "C") {
            accountTypeBusiness.click();
        } else {
            accountTypePrivate.click();
        }
     }

     public void chooseLeaseType(ApplicationModel application) {
         logger.info("Application type is : " + application.accountType.toString());

         if (application.leaseType.toString() == "HP") {
             leaseTypeHP.click();
         } else {
             leaseTypeFL.click();
         }
     }

     public static SelenideElement submitButton() {
        /* by text is a flaky option, should be changed to some selector that takes elements from
        buttons on the page and has some unique way to identify it.
         */
        return $(By.cssSelector("button[value='Edasi']"));
     }

     public void vatIncludedOption(ApplicationModel application) {
         logger.info("Vat included option: " + application.vatIncluded.toString());
         if (application.vatIncluded) {
             vatIncluded.click();
         }
     }

    @Step("Submitting application step1")
    public void submitStep1(ApplicationModel application){
        accountType.waitUntil(Condition.exist, 3000);
        applicantType(application);
        chooseLeaseType(application);
        priceField.sendKeys(application.price);
        logger.info(application.price);
        initialAmount.scrollTo().sendKeys(application.initialAmount);
        vatIncludedOption(application);
        durationYears.selectOptionByValue(application.durationYears);
        reminderValue.sendKeys(application.reminderValue);
        paymentDay.selectOptionByValue(application.paymentDay);
        //submitButton().waitUntil(Condition.enabled, 3000).click();
        //vehicleCondition.waitUntil(Condition.appear,3000);
        sleep(3000);
    }

}
