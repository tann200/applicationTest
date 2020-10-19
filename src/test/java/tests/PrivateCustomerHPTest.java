package tests;

import enums.LeaseType;
import models.ApplicationModel;
import org.testng.ITestContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testData.TestData;

import static com.codeborne.selenide.Selenide.*;


public class PrivateCustomerHPTest extends TestBase{



    private final Logger logger = LoggerFactory.getLogger(PrivateCustomerHPTest.class);


    private final ApplicationModel applicationModel = TestData.privateApplicant();




    @BeforeTest
    public void beforeTest(ITestContext context) {
        logger.info("Things to do before the test");
    }




    @Test(testName = "Test for private applicant FL")
    public void privateApplicantFL(ITestContext context) {
        open(webUrl);
        switchTo().frame(0);
        stepOnePage.submitStep1(this.applicationModel);

    }

    @Test(testName = "Test for private applicant FL")
    public void privateApplicantFlVatNotIncluded(ITestContext context) {
        this.applicationModel.vatIncluded =false;

        open(webUrl);
        switchTo().frame(0);
        stepOnePage.submitStep1(this.applicationModel);

    }

    @Test(testName = "Test for private applicant HP")
    public void privateApplicantHp(ITestContext context) {
        this.applicationModel.leaseType = LeaseType.HP;
        open(webUrl);
        switchTo().frame(0);
        stepOnePage.submitStep1(this.applicationModel);
    }

    @Test(testName = "Test for private applicant HP")
    public void privateApplicantHpVatNotIncluded(ITestContext context) {
        this.applicationModel.leaseType = LeaseType.HP;
        this.applicationModel.vatIncluded =false;

        open(webUrl);
        switchTo().frame(0);
        stepOnePage.submitStep1(this.applicationModel);
    }

}

