/* NEW
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author 92016097
 */
public class CEO extends Person implements IManager{
    
    private SalaryInformation salaryInformation = new SalaryInformation(110000);
    private TimePeriods timePeriod;
    private ArrayList<ISubordinate> subordinateList = new ArrayList<>();
    private final Double MAXBONUSES = 5000.0;
    private Double bonusAssigned = 0.0;
    private Double bonusRemaining = MAXBONUSES;
    
    public void setSubordinates(ISubordinate[] subordinates) {
        for (ISubordinate employees : subordinates) {
            subordinateList.add(employees);
        }
    }
    
    @Override
    public ArrayList<ISubordinate> getSubordinateList() {
        return subordinateList;
    }
    
    public TimePeriods getTimePeriod() {
        return this.timePeriod;
    }
    
    public void setTimePeriod(TimePeriods timePeriod) {
        this.timePeriod = timePeriod;
    }
    
        //  method which allows manager to assign bonus to one of his subordinates
    public String assignBonus(ISubordinate iSubordinate, Double bonus) {
        String jOptionPaneMessage = "";
        ISalariedPerson iSalariedPerson;
        if (bonus == 0.0) {
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
    public SalaryInformation getSalaryInformation() {
        return salaryInformation;
    }

    public double calculatePay(Date date, double baseSalary) throws Exception {
        TimePeriods timePeriod = getTimePeriod(); 
        return salaryInformation.calculatePayPerTimePeriod(timePeriod, date);
    }
}
