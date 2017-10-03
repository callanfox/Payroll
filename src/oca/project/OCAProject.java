package oca.project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Main class that creates all employees and specifies their managers
 */
public class OCAProject {
    
    private static Employees arrayOfEmployees;
    private static DateDetails currentDates;
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    private static Date initialDate;
    
    public static Employees getEmployees() {
        return arrayOfEmployees;
    }
    
    public static DateDetails getCurrentDates() {
        return currentDates;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
       arrayOfEmployees = new Employees();
       arrayOfEmployees.createEmployees();
       currentDates = new DateDetails();
       initialDate = dateFormatter.parse("01/01/2015");
       currentDates.setFortnightlyCal(initialDate);
       currentDates.setMonthlyCal(initialDate);
       mainForm form = new mainForm();
       form.setVisible(true);
    }
    
}
