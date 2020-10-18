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




    @Test(testName = "Test for business Application with lease type FL")
    public void businessApplicantTestFL(ITestContext context) {
        open(webUrl);
        switchTo().frame(0);
        stepOnePage.submitStep1(this.applicationModel);
    }

    @Test(testName = "Test for business Application with lease type HP")
    public void businessApplicantTestHP(ITestContext context) {
        this.applicationModel.leaseType = LeaseType.HP;
        open(webUrl);
        switchTo().frame(0);
        stepOnePage.submitStep1(this.applicationModel);

    }

}

