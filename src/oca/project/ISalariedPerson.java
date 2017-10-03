package oca.project;

/**
 *
 * Interface to be implemented by all people working at the company
 * who are getting salaries 
 */
public interface ISalariedPerson extends IPaidPerson {
    
    //getter and setter methods for pay period   
    TimePeriods getTimePeriod();
    
    void setTimePeriod(TimePeriods timePeriod);
    
    //getter and setter methods for Bonuses that might be assigned 
    //to subordinate by manager
    double getCurrentBonus();
    
    void setCurrentBonus(double currentBonus);
}
