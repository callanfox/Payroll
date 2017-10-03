package oca.project;

import java.util.Date;

/**
 *
 * Interface to be implemented by all people working at the company 
 */
public interface IPaidPerson {
    
    
    //this method should be used by all paid people
    //to calculate the pay earned over a period of time
     public double calculatePay(Date startDateOfPayPeriod, double numberOfHours) throws Exception ;
}
