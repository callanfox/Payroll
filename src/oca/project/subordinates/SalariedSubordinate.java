/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project.subordinates;
import java.text.ParseException;
import java.util.Date;
import oca.project.ISalariedPerson;
import oca.project.SalaryInformation;
import oca.project.TimePeriods;
import oca.project.IManager;
/**
 *
 * @author 92016097
 */
public class SalariedSubordinate extends Subordinate implements ISalariedPerson {
    private final SalaryInformation salaryInformation;
    private TimePeriods timePeriod;
    
    public SalariedSubordinate(Double baseSalary, IManager manager) {
        super(manager);
        salaryInformation = new SalaryInformation(baseSalary);
    }
    
    @Override
    public double calculatePay(Date date, double baseSalary) throws ParseException { 
       TimePeriods timePeriod = getTimePeriod(); 
       return salaryInformation.calculatePayPerTimePeriod(timePeriod, date);
    }
    
    @Override
    public void setCurrentBonus(double bonus) { //?????
        salaryInformation.setCurrentBonus(bonus);
    }
    
    @Override
    public double getCurrentBonus() { //?????
        return salaryInformation.getCurrentBonus();
    }
    
    @Override
    public void setTimePeriod(TimePeriods timePeriod) { //?????
        this.timePeriod = timePeriod;
    }
    
    @Override
    public TimePeriods getTimePeriod() { //?????
        return this.timePeriod;
    }
    
    @Override
    public IManager getManager() { //?????
        return this.manager; 
    }
    
    public Double getBaseSalary() {
        return salaryInformation.getBaseSalary();
    }
}
