package tests;

import models.ApplicationModel;
import org.testng.ITestContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import testData.TestData;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;


public class TestClass1 extends TestBase{



    private final Logger logger = LoggerFactory.getLogger(TestClass1.class);


    private final ApplicationModel applicationModel = TestData.privateApplicant();




    @BeforeTest
    public void beforeTest(ITestContext context) {
        logger.info("Things to do before the test");
    }




    @Test
    public void Test1(ITestContext context) {
        open(webUrl);
        switchTo().frame(0);
        step1.submitStep1(this.applicationModel);

    }

    @Test(dependsOnMethods = "Test1")
    public void Test2(ITestContext context) {
        logger.info("This is Test2");
    }

}

