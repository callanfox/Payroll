/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import oca.project.managers.Manager;
import oca.project.subordinates.SalariedSubordinate;
import oca.project.subordinates.ContractSubordinate;
import java.text.DecimalFormat;
/**
 *
 * @author 92016097
 */
public class PayrollReportItem {
    private Person person;
    private Double salary;
    private Date startOfPayPeriod;
    private TimePeriods payPeriod;
    private String payTimePeriod;
    private DecimalFormat numberFormatter = new DecimalFormat("###,###.##");
    
    public PayrollReportItem(Person person, Double salary, Date startOfPayPeriod, TimePeriods payPeriod) {
        this.person = person;
        this.salary = salary;
        this.startOfPayPeriod = startOfPayPeriod;
        this.payPeriod = payPeriod;
    }
    
    public TimePeriods getTimePeriod() {
        return payPeriod;
    }
    
    public Date getStartOfPayPeriod() {
        return startOfPayPeriod;
    }
    
    public String getName() {
        return person.getName();
    }
    
    @Override
    public String toString() {
        String msg = "";
        if(person instanceof IManager ) {
            Manager manager = (Manager) person;
            try {
                msg += person.getName() + " was paid $" + numberFormatter.format(manager.calculatePay(startOfPayPeriod, salary)) + " on the "  + startOfPayPeriod + ". Pay Period: " + payPeriod;
            } catch (ParseException ex) {
                Logger.getLogger(PayrollReportItem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (person instanceof SalariedSubordinate) {
            SalariedSubordinate salariedSubordinate = (SalariedSubordinate) person;
            try {
                msg += person.getName() + " was paid $" + numberFormatter.format(salariedSubordinate.calculatePay(startOfPayPeriod, salary)) + " on the "  + startOfPayPeriod + ". Pay Period: " + payPeriod;
            } catch (ParseException ex) {
                Logger.getLogger(PayrollReportItem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(person instanceof ContractSubordinate) {
            ContractSubordinate contractSubordinate = (ContractSubordinate) person;
            msg += person.getName() + " was paid $" + salary + " on the "  + startOfPayPeriod + ". Pay Period: " + payPeriod;
            
        }
        return msg;
    }
}
