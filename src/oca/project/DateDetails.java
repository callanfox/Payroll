/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Callan
 */
public class DateDetails {
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    private final GregorianCalendar fortnightlyCal = new GregorianCalendar();
    private final GregorianCalendar monthlyCal = new GregorianCalendar();

    public void setFortnightlyCal(Date fortnightlyCal) {
        this.fortnightlyCal.setTime(fortnightlyCal);
    }
    
    public void addFortnightlyCal() {
        this.fortnightlyCal.add(Calendar.DATE, 14);
    }

    public void setMonthlyCal(Date monthlyCal) {
        this.monthlyCal.setTime(monthlyCal);
    }
    
        
    public void addMonthlyCal(int numOfDaysToIncrement) {
        this.monthlyCal.add(Calendar.DATE, numOfDaysToIncrement);
    }
    
   
    public GregorianCalendar getFortnightlyCal() {
        return fortnightlyCal;
    }
       
    public GregorianCalendar getMonthlyCal() {
        return monthlyCal;
    }
}
