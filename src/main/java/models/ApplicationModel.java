package models;

import enums.AccountType;
import enums.LeaseType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationModel {

    public ApplicationModel() {

    }


    public AccountType accountType ;
    public LeaseType leaseType ;
    public String price;
    public Boolean vatIncluded;
    public String initialPercentage;
    public String initialAmount;
    public String durationYears;
    public String durationMonths;
    public String reminderPercentage;
    public String reminderValue;
    public String paymentDay;
}
