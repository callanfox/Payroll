/* NEW
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * @author 92016097
 */
public class Person {
    private String name;
    private Date date;
    private Date startDate;
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setStartDate(String startDate) throws ParseException {
        this.startDate = dateFormatter.parse(startDate);
    }
    
    public String getstartDate() {
        return dateFormatter.format(startDate);
    }
    
    public void setDOB(String dob) throws ParseException {
        this.date = dateFormatter.parse(dob);
    }
    
    public String getDOB() {
        return dateFormatter.format(date);
    }
    
    @Override
    public String toString() {
        return name;
    }
}
