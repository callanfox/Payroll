/* NEW
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;
/**
 *
 * @author 92016097
 */
public class SalaryInformation {
    private double baseSalary;
    private double currentBonus;
    private final DecimalFormat decimalFormatter = new DecimalFormat("#.##");
    
    public SalaryInformation(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    
    public double getBaseSalary() {
        return baseSalary;
    }
    
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    
    public double getCurrentBonus() {
        return currentBonus; 
    }
    
    public void setCurrentBonus(double bonus) {
        currentBonus = bonus;
    }
    
    public void setCurrentBonus(ISalariedPerson subordinate, double bonus) {
        subordinate.setCurrentBonus(bonus);
    }
    
    // method to calculate number of years in employment; utilised by the calculateIncrease() class
    public long numOfYearsEmployment(Date startDate) throws ParseException{
        // current Date and date started represented in milliseconds
        Date today = new Date();
        long currentDateConverted = today.getTime();
        long frmDateConverted = startDate.getTime();
        
        //calculate difference in years between the two millisecond representations
        long dateStarted = calculateTimeInYears(frmDateConverted); 
        long currentDate = calculateTimeInYears(currentDateConverted);
        long dateDifference = currentDate - dateStarted;
        return dateDifference;
    }
    
    // helper method to numOfYearsEmployment that converts the millisecond difference into a yearly representation
    private long calculateTimeInYears(long date) {
        int seconds = 1000, minutes = 60, hours = 60, days = 24, weeks = 7,
        months = 4, years = 12;
        return date/seconds/minutes/hours/days/weeks/months/years;
    }
    
    
    private double calculateIncrease(double baseSalary, Date dateStarted) throws ParseException {
        int longNumOfYears = (int) numOfYearsEmployment(dateStarted);
        double payIncrease = 0;
        if ((longNumOfYears % 2) == 0) {
            baseSalary += (baseSalary * 0.02);
        }
        return baseSalary;
    }
    
    private double calculateFinalYearlyPay(Date startDate) throws ParseException {
        double payIncrease =  calculateIncrease(baseSalary, startDate);
        if (payIncrease > 0) {
            baseSalary = baseSalary + payIncrease;
        }
        return baseSalary;
    }
    
    public double calculatePayPerTimePeriod(TimePeriods timePeriod, Date startDate) throws ParseException {
         double payPerTimePeriod = 0;
         if (timePeriod == TimePeriods.FORTNIGHTLY) {
             payPerTimePeriod = baseSalary / 26;
         }
         else {
             payPerTimePeriod = baseSalary / 12;
         }
         return payPerTimePeriod;
    }
}
