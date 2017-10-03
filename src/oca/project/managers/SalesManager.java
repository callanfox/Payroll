/* NEW
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project.managers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import oca.project.IManager;
import oca.project.ISubordinate;
import oca.project.TimePeriods;

/**
 *
 * @author 92016097
 */
public class SalesManager extends Manager {
    public SalesManager(IManager manager) {
        super(75000.00, manager);
    }

    @Override
    public ArrayList<ISubordinate> getSubordinateList() {
        return getSubordinates();
    }


    //getter and setter methods for pay period   
    @Override
    public TimePeriods getTimePeriod() {
        return super.getTimePeriod();
    }

    @Override
    public void setTimePeriod(TimePeriods timePeriod) {
        super.setTimePeriod(timePeriod);
    }

    //getter and setter methods for Bonuses that might be assigned 
    //to subordinate by manager
    @Override
    public double getCurrentBonus() {
        return super.getCurrentBonus();
    }

    @Override 
    public void setCurrentBonus(double currentBonus) {
        this.setBonus(currentBonus); 
    }

    @Override
    public IManager getManager() {
        return super.getManager();
    }
}
