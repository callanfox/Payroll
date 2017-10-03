    /* NEW
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project.managers;

import java.text.ParseException;
import oca.project.IManager;
import oca.project.ISalariedPerson;
import oca.project.ISubordinate;
import oca.project.SalaryInformation;
import oca.project.Person;
import java.util.ArrayList;
import java.util.Date;
import oca.project.TimePeriods;

/**
 *
 * @author 92016097
 */

public abstract class Manager extends Person implements IManager, ISalariedPerson, ISubordinate{
    
    private final Double MAXBONUSES = 5000.0;
    private Double bonusAssigned = 0.0;
    private Double bonusRemaining = MAXBONUSES;
    private Double baseSalary;
    private IManager manager;
    private ArrayList<ISubordinate> subordinateList;
    private SalaryInformation salaryInformation;
    private TimePeriods timePeriod;
   
    public Manager(Double baseSalary, IManager manager, ArrayList subordinateList) {
        this.baseSalary = baseSalary;
        this.manager = manager;
        this.subordinateList = subordinateList;
        this.salaryInformation = new SalaryInformation(baseSalary);
    }
    
    public Manager(Double baseSalary, IManager manager) {
        this.baseSalary = baseSalary;
        this.manager = manager;
        this.subordinateList = new ArrayList<>();
        this.salaryInformation = new SalaryInformation(baseSalary);
    }
    
        
    //  method which allows manager to assign bonus to one of his subordinates
    public String assignBonus(ISubordinate iSubordinate, Double bonus) {
        String jOptionPaneMessage = "";
        ISalariedPerson iSalariedPerson; 
        // checks to see if subordinate is a contractor. If so, then a bonus cannot be allocated.
        if((iSubordinate instanceof ISalariedPerson) == false) {
            jOptionPaneMessage = "You cannot allocate a bonus to a contractor.";
            
        }
        else if (bonus == 0.0) {
            jOptionPaneMessage = "Please enter a valid amount.";
        }
        //  check that a bonus has not already been allocated to the subordinate
        else if( (iSalariedPerson = (ISalariedPerson) iSubordinate).getCurrentBonus() > 0) {
            jOptionPaneMessage = iSalariedPerson + " already has a bonus assigned.";
        }
        else if (bonus > MAXBONUSES) {
            jOptionPaneMessage = "You cannot allocate a bonus in excess of $5000.";
        }
        else if (bonusRemaining <= 0) {
            jOptionPaneMessage = "You have already allocated the full amount of your bonus budget ($5000).";
        }
        //  checks if manager has not exceeded their $5000 budget
        else if ((bonusAssigned + bonus) > MAXBONUSES) {
            jOptionPaneMessage = "Manager " + this.getName() + " cannot allocate anymore than $" + bonusRemaining + ".";
        }
        /*  assigns bonus to subordinate provided all checks have passed, as long 
          as a previous bonus has not already been assigned  */
        else if (iSubordinate instanceof ISalariedPerson && bonusRemaining > 0) {
            if (iSalariedPerson.getCurrentBonus() == 0) {
                iSalariedPerson.setCurrentBonus(bonus);
                bonusAssigned += bonus;
                bonusRemaining -= bonus;
                jOptionPaneMessage = "The bonus of $" + bonus + " has been assigned to " + iSalariedPerson + ".";
                iSalariedPerson.setCurrentBonus(bonus);
            }
        }
        return jOptionPaneMessage;
    }
    
    public double getCurrentBonus() {
        return salaryInformation.getCurrentBonus();
    }
    
    public ArrayList<ISubordinate> getSubordinates() {
        return subordinateList;
    }
     
    public void setSubordinates(ISubordinate[] subordinates) {
        for (ISubordinate employees : subordinates) {
            subordinateList.add(employees);
        }
    }
    
    public TimePeriods getTimePeriod() {
        return timePeriod;
    }
    
    public void setTimePeriod(TimePeriods timePeriod) {
        this.timePeriod = timePeriod;
    }
    
    public IManager getManager() {
        return manager;
    }
    
    public double calculatePay(Date date, double baseSalary) throws ParseException {
       TimePeriods timePeriod = getTimePeriod(); 
       return salaryInformation.calculatePayPerTimePeriod(timePeriod, date);
    }
    
    public void setBonus(double bonus) {
        salaryInformation.setCurrentBonus(bonus);
    }
    
    public Double getBaseSalary() {
        return salaryInformation.getBaseSalary();
    }
}
   
