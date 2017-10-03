/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oca.project;

/**
 *
 * @author 92016097
 */
public class LeapYearCheck {
    
    private final int year;
    
    public LeapYearCheck(int year) {
        this.year = year;
    }
    
    public boolean isLeapYear() {
        if(year % 4 == 0) {
            if(!(year % 100 == 0)) {
                return true;
            }
            else if(year % 400 == 0) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
