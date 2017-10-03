/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.util.Date;
/**
 *
 * @author 92016097
 */
public class ContractInformation {
    private final Double hourlyRate;
    private final int FULL_TIME_HOURS = 40;
    
    public ContractInformation(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    
    public double calculatePay(Date startDateOfPayPeriod, Double hoursOfWork) { //  this methods needs more work !!! 
        return hoursOfWork * hourlyRate;
    }
    
    public double getHourlyRate() {
        return hourlyRate;
    }
}
