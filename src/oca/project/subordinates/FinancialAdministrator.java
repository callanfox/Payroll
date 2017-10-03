/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project.subordinates;


import oca.project.IManager;


/**
 *
 * @author 92016097
 */
public class FinancialAdministrator extends SalariedSubordinate {
    public FinancialAdministrator(IManager manager) {
        super(75000.00, manager);
    }
}
