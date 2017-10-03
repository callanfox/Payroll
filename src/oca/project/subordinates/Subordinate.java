/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project.subordinates;

import oca.project.ISubordinate;
import oca.project.Person;
import oca.project.IManager;

/**
 *
 * @author 92016097
 */
public abstract class Subordinate extends Person implements ISubordinate{
    protected IManager manager;
    private Boolean salariedPerson;
    
    public Subordinate(IManager manager) {
        this.manager = manager;
    }
}
