/* NEW
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project.subordinates;

import java.util.Date;
import oca.project.ContractInformation;
import oca.project.TimePeriods;
import oca.project.IManager;

/**
 *
 * @author 92016097
 */
public class ContractSubordinate extends Subordinate{
    private final ContractInformation contractInformation;
    private final TimePeriods timeperiod = TimePeriods.MONTHLY;
    
    public ContractSubordinate(Double hourlyRate, IManager manager) {
        super(manager);
        contractInformation = new ContractInformation(hourlyRate);
    }
    
    @Override
    public IManager getManager() {
        return this.manager;
    } 
    
    public double getHourlyRate() {
        return contractInformation.getHourlyRate();
    }
    
    @Override
    public double calculatePay(Date startDateOfPayPeriod, double numberOfHours) { //  this methods needs more work !!! 
        return contractInformation.calculatePay(startDateOfPayPeriod, numberOfHours); //remember overtime
    }
    
    public TimePeriods getTimePeriods() {
        return timeperiod;
    }
    
}
