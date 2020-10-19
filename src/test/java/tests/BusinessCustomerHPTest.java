package tests;

import enums.LeaseType;
import models.ApplicationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testData.TestData;

import static com.codeborne.selenide.Selenide.*;


public class BusinessCustomerHPTest extends TestBase{

    private final Logger logger = LoggerFactory.getLogger(BusinessCustomerHPTest.class);


    private final ApplicationModel applicationModel = TestData.businessApplicant();




    @BeforeTest
    public void beforeTest(ITestContext context) {
        logger.info("Things to do before the test");
    }


    @Test(testName = "Business applicaiton FL, vat included")
    public void businessApplicantTestFlVatIncluded(ITestContext context) {
        this.applicationModel.vatIncluded=true;
        open(webUrl);
        switchTo().frame(0);
        stepOnePage.submitStep1(this.applicationModel);
    }

    @Test(testName = "Business applicaiton FL, vat not included")
    public void businessApplicantTestFl(ITestContext context) {
        this.applicationModel.durationYears = "2";
        open(webUrl);
        switchTo().frame(0);
        stepOnePage.submitStep1(this.applicationModel);
    }

    @Test(testName = "Test for business Application with lease type HP")
    public void businessApplicantTestHp(ITestContext context) {
        this.applicationModel.leaseType = LeaseType.HP;
        this.applicationModel.durationYears = "6";
        this.applicationModel.durationMonths =null;
        open(webUrl);
        switchTo().frame(0);
        stepOnePage.submitStep1(this.applicationModel);

    }

    @Test(testName = "Test for business Application with lease type HP")
    public void businessApplicantTestHpVatIncluded(ITestContext context) {
        this.applicationModel.vatIncluded=true;
        this.applicationModel.leaseType = LeaseType.HP;
        this.applicationModel.durationYears = "3";
        open(webUrl);
        switchTo().frame(0);
        stepOnePage.submitStep1(this.applicationModel);

    }

}

