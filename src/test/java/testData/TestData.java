package testData;

import enums.AccountType;
import enums.LeaseType;
import models.ApplicationModel;

public class TestData {


    
    public TestData() {
    }
        
        public static ApplicationModel privateApplicant(){
            ApplicationModel applicationModel = new ApplicationModel();
            applicationModel.accountType = AccountType.P;
            applicationModel.leaseType = LeaseType.FL;
            applicationModel.price = "7500";
            applicationModel.vatIncluded = true;
            applicationModel.initialAmount = "3000";
            applicationModel.initialPercentage = "10";
            applicationModel.durationYears = "6";
            applicationModel.reminderPercentage = "10";
            applicationModel.reminderValue = "750";
            applicationModel.paymentDay = "15";
            return applicationModel;

        }

    public static ApplicationModel businessApplicant(){
        ApplicationModel applicationModel = new ApplicationModel();
        applicationModel.accountType = AccountType.C;
        applicationModel.leaseType = LeaseType.FL;
        applicationModel.price = "7500";
        applicationModel.vatIncluded = false;
        applicationModel.initialAmount = "3000";
        applicationModel.initialPercentage = "10";
        applicationModel.durationMonths = "6";
        applicationModel.reminderPercentage = "10";
        applicationModel.reminderValue = "750";
        applicationModel.paymentDay = "15";
        return applicationModel;

    }

}
