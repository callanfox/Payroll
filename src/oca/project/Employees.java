/* NEW
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.text.ParseException;
import oca.project.managers.HROfficer;
import oca.project.managers.AdministrationManager;
import oca.project.managers.ProjectManager;
import oca.project.managers.BranchManager;
import oca.project.managers.SalesManager;
import oca.project.managers.SeniorProgramDeveloper;
import oca.project.subordinates.FinancialAdministrator;
import oca.project.subordinates.ProgramDeveloper;
import oca.project.subordinates.SystemAdministrator;
import oca.project.subordinates.SystemAnalyst;
import oca.project.subordinates.Receptionist;
import oca.project.subordinates.SalesConsultant;
import oca.project.subordinates.Tester;
/**
 *
 * @author 92016097
 */
public class Employees {
    private CEO ceo;
    private HROfficer hrOfficer;
    private AdministrationManager adminManager;  
    private BranchManager branchManager_A;
    private BranchManager branchManager_B;
    private BranchManager branchManager_C;
    private ProjectManager projectManager_A;
    private ProjectManager projectManager_B;
    private ProjectManager projectManager_C;
    private SalesManager salesManager;
    private SeniorProgramDeveloper seniorProgramDeveloper_A;
    private SeniorProgramDeveloper seniorProgramDeveloper_B;
    private FinancialAdministrator financialAdministrator;
    private ProgramDeveloper programDeveloper_A;
    private ProgramDeveloper programDeveloper_B;
    private ProgramDeveloper programDeveloper_C;
    private SystemAdministrator systemAdministrator_A;
    private SystemAdministrator systemAdministrator_B;
    private SystemAdministrator systemAdministrator_C;
    private SystemAnalyst systemAnalyst_A;
    private SystemAnalyst systemAnalyst_B;
    private SystemAnalyst systemAnalyst_C;
    private Receptionist receptionist;
    private SalesConsultant salesConsultant;
    private Tester tester_A;
    private Tester tester_B;
    private Tester tester_C;
    private Tester tester_D;
    
    public void createEmployees() throws ParseException {
        createReceptionist();
        createTester();
        createProgramDevelopers();
        createSeniorProgramDevelopers();        
        createSystemAnalysts();
        createSystemAdministrators();
        createProjectManagers();
        createSalesConsultant();
        createBranchManagers();
        createSalesManager();
        createHROfficer();
        createFinancialAdministrator();
        createAdministrationManager();
        createCEO();
    }
    
    public void createCEO() throws ParseException {
        ceo = new CEO();
        ceo.setName("James Mint");
        ceo.setDOB("13/04/1981");
        ceo.setStartDate("10/01/2010");
        ceo.setTimePeriod(TimePeriods.MONTHLY);
        ISubordinate[] subordinates = {adminManager, financialAdministrator, hrOfficer, salesManager};
        ceo.setSubordinates(subordinates);
    }
    
    public void createHROfficer() throws ParseException {
        hrOfficer = new HROfficer(ceo);
        hrOfficer.setName("Julia Smith");
        hrOfficer.setDOB("17/02/1973"); 
        hrOfficer.setStartDate("13/06/2010");
        hrOfficer.setTimePeriod(TimePeriods.MONTHLY);
        ISubordinate[] subordinates = {receptionist};
        hrOfficer.setSubordinates(subordinates);
    }
    
    public void createAdministrationManager() throws ParseException {
        adminManager = new AdministrationManager(ceo);
        adminManager.setName("Bill Johns");
        adminManager.setDOB("13/04/1981");
        adminManager.setStartDate("10/05/2012");
        adminManager.setTimePeriod(TimePeriods.MONTHLY);
        ISubordinate[] subordinate = {branchManager_A, branchManager_B, branchManager_C};
        adminManager.setSubordinates(subordinate);
    }
    
    public void createBranchManagers() throws ParseException {
        branchManager_A = new BranchManager(adminManager);
        branchManager_A.setName("Kate Hudson");
        branchManager_A.setDOB("13/07/1981");
        branchManager_A.setStartDate("11/03/2013");
        branchManager_A.setTimePeriod(TimePeriods.MONTHLY);
        ISubordinate[] subordinate_A = {projectManager_B, systemAdministrator_B};
        branchManager_A.setSubordinates(subordinate_A);
        branchManager_B = new BranchManager(adminManager);
        branchManager_B.setName("Scarlet Green");
        branchManager_B.setDOB("20/03/1980");
        branchManager_B.setStartDate("10/05/2013");
        branchManager_B.setTimePeriod(TimePeriods.MONTHLY);
        ISubordinate[] subordinate_B = {projectManager_C, systemAdministrator_C};
        branchManager_B.setSubordinates(subordinate_B);
        branchManager_C = new BranchManager(adminManager);
        branchManager_C.setName("Amanda Green");
        branchManager_C.setDOB("5/04/1979");
        branchManager_C.setStartDate("14/10/2014");
        branchManager_C.setTimePeriod(TimePeriods.MONTHLY);
        ISubordinate[] subordinate_C = {projectManager_A, systemAdministrator_A};
        branchManager_C.setSubordinates(subordinate_C);
    }
    
    public void createProjectManagers() throws ParseException {
        projectManager_A = new ProjectManager(branchManager_C);
        projectManager_A.setName("Victoria Bell");
        projectManager_A.setDOB("11/01/1978");
        projectManager_A.setStartDate("30/04/2013");
        projectManager_A.setTimePeriod(TimePeriods.FORTNIGHTLY);
        ISubordinate[] subordinate_A = {seniorProgramDeveloper_A, systemAnalyst_A, tester_A};
        projectManager_A.setSubordinates(subordinate_A);
        projectManager_B = new ProjectManager(branchManager_A);
        projectManager_B.setName("Charlotte Hond");
        projectManager_B.setDOB("1/07/1988");
        projectManager_B.setStartDate("28/02/2012");
        projectManager_B.setTimePeriod(TimePeriods.FORTNIGHTLY);
        ISubordinate[] subordinates_B = {seniorProgramDeveloper_B, systemAnalyst_B, tester_B, tester_C};
        projectManager_B.setSubordinates(subordinates_B);
        projectManager_C = new ProjectManager(branchManager_B);
        projectManager_C.setName("Christine Bennet");
        projectManager_C.setDOB("16/06/1982");
        projectManager_C.setStartDate("11/06/2011");
        projectManager_C.setTimePeriod(TimePeriods.FORTNIGHTLY);
        ISubordinate[] subordinates_C = {programDeveloper_C, systemAnalyst_C, tester_D};
        projectManager_C.setSubordinates(subordinates_C);
    }
    
    public void createSalesManager() throws ParseException {
        salesManager = new SalesManager(ceo);
        salesManager.setName("Michael Brown");
        salesManager.setDOB("25/12/1985");
        salesManager.setStartDate("21/07/2012");
        salesManager.setTimePeriod(TimePeriods.FORTNIGHTLY);
        ISubordinate[] subordinates = {salesConsultant};
        salesManager.setSubordinates(subordinates);
    }
    
    public void createSeniorProgramDevelopers() throws ParseException {
        seniorProgramDeveloper_A = new SeniorProgramDeveloper(projectManager_A);
        seniorProgramDeveloper_A.setName("John Norton");
        seniorProgramDeveloper_A.setDOB("17/07/1980");
        seniorProgramDeveloper_A.setStartDate("10/09/2010");
        seniorProgramDeveloper_A.setTimePeriod(TimePeriods.MONTHLY);
        ISubordinate[] subordinates_A = {programDeveloper_A};
        seniorProgramDeveloper_A.setSubordinates(subordinates_A);
        seniorProgramDeveloper_B = new SeniorProgramDeveloper(projectManager_B);
        seniorProgramDeveloper_B.setName("Ashley Simpson");
        seniorProgramDeveloper_B.setDOB("12/05/1984");
        seniorProgramDeveloper_B.setStartDate("15/06/2010");
        seniorProgramDeveloper_B.setTimePeriod(TimePeriods.MONTHLY);
        ISubordinate[] subordinates_B = {programDeveloper_B};
        seniorProgramDeveloper_B.setSubordinates(subordinates_B);
    }
    
    public void createFinancialAdministrator() throws ParseException {
        financialAdministrator = new FinancialAdministrator(ceo);
        financialAdministrator.setName("Eric White");
        financialAdministrator.setDOB("21/05/1984");
        financialAdministrator.setStartDate("10/04/2011");
        financialAdministrator.setTimePeriod(TimePeriods.FORTNIGHTLY);
    }
    
    public void createProgramDevelopers() throws ParseException {
        programDeveloper_A = new ProgramDeveloper(seniorProgramDeveloper_A);
        programDeveloper_A.setName("Alex Dillon");
        programDeveloper_A.setDOB("10/03/1989");
        programDeveloper_A.setStartDate("14/09/2014");
        programDeveloper_A.setTimePeriod(TimePeriods.FORTNIGHTLY);
        programDeveloper_B = new ProgramDeveloper(seniorProgramDeveloper_B);
        programDeveloper_B.setName("Andrew Sampson");
        programDeveloper_B.setDOB("9/04/1984");
        programDeveloper_B.setStartDate("4/07/2010");
        programDeveloper_B.setTimePeriod(TimePeriods.FORTNIGHTLY);
        programDeveloper_C = new ProgramDeveloper(projectManager_C);
        programDeveloper_C.setName("David Galloway");
        programDeveloper_C.setDOB("6/12/1981");
        programDeveloper_C.setStartDate("5/11/2013");
        programDeveloper_C.setTimePeriod(TimePeriods.MONTHLY);
    }
    
    public void createSystemAdministrators() throws ParseException {
        systemAdministrator_A = new SystemAdministrator(branchManager_C);
        systemAdministrator_A.setName("Andrew Black");
        systemAdministrator_A.setDOB("15/04/1976");
        systemAdministrator_A.setStartDate("4/05/2012");
        systemAdministrator_A.setTimePeriod(TimePeriods.MONTHLY);
        systemAdministrator_B = new SystemAdministrator(branchManager_A);
        systemAdministrator_B.setName("Joanne Dowman");
        systemAdministrator_B.setDOB("13/12/1980");
        systemAdministrator_B.setStartDate("7/07/2014");
        systemAdministrator_B.setTimePeriod(TimePeriods.FORTNIGHTLY);
        systemAdministrator_C = new SystemAdministrator(branchManager_B);
        systemAdministrator_C.setName("Michael Perry");
        systemAdministrator_C.setDOB("12/11/1977");
        systemAdministrator_C.setStartDate("1/03/2014");
        systemAdministrator_C.setTimePeriod(TimePeriods.FORTNIGHTLY);
    }
    
    public void createSystemAnalysts() throws ParseException {
        systemAnalyst_A = new SystemAnalyst(projectManager_A);
        systemAnalyst_A.setName("Andrew Blank");
        systemAnalyst_A.setDOB("15/09/1981");
        systemAnalyst_A.setStartDate("19/08/2014");
        systemAnalyst_A.setTimePeriod(TimePeriods.MONTHLY);
        systemAnalyst_B = new SystemAnalyst(projectManager_B);
        systemAnalyst_B.setName("Carol White");
        systemAnalyst_B.setDOB("20/10/1975");
        systemAnalyst_B.setStartDate("10/01/2014");
        systemAnalyst_B.setTimePeriod(TimePeriods.MONTHLY);
        systemAnalyst_C = new SystemAnalyst(projectManager_C);
        systemAnalyst_C.setName("Brad Turner");
        systemAnalyst_C.setDOB("22/11/1988");
        systemAnalyst_C.setStartDate("26/05/2014");
        systemAnalyst_C.setTimePeriod(TimePeriods.MONTHLY);
    }
    
    public void createReceptionist() throws ParseException {
        receptionist = new Receptionist(hrOfficer);
        receptionist.setName("Peter Gordon");
        receptionist.setDOB("30/09/1983");
        receptionist.setStartDate("10/05/2010");
        receptionist.setTimePeriod(TimePeriods.FORTNIGHTLY);
    }
    
    public void createSalesConsultant() throws ParseException {
        salesConsultant = new SalesConsultant(salesManager);
        salesConsultant.setName("Helen Chan");
        salesConsultant.setDOB("11/01/1991");
        salesConsultant.setStartDate("20/05/2011");
    }
    
    public void createTester() throws ParseException {
        tester_A = new Tester(projectManager_A);
        tester_A.setName("James Carol");
        tester_A.setDOB("24/03/1978");
        tester_A.setStartDate("6/09/2013");
        tester_B = new Tester(projectManager_B);
        tester_B.setName("Elena Tang");
        tester_B.setDOB("11/02/1969");
        tester_B.setStartDate("7/08/2013");
        tester_C = new Tester(projectManager_B);
        tester_C.setName("Tessa Green");
        tester_C.setDOB("31/10/1985");
        tester_C.setStartDate("8/07/2013");
        tester_D = new Tester(projectManager_C);
        tester_D.setName("David Chand");
        tester_D.setDOB("11/04/1973");
        tester_D.setStartDate("9/06/2014");
    }
    
    public CEO getCEO() {
        return ceo;
    }
    
    public IManager[] getManagers() {
        IManager[] managers = {ceo, hrOfficer, adminManager, branchManager_A, 
            branchManager_B, branchManager_C, projectManager_A, projectManager_B,
            projectManager_C, salesManager, seniorProgramDeveloper_A, seniorProgramDeveloper_B};
        
        return managers;
    }
    
    public ISalariedPerson[] getSalariedEmployees() {
        ISalariedPerson[] salariedEmployees = {hrOfficer, adminManager, branchManager_A, 
            branchManager_B, branchManager_C, projectManager_A, projectManager_B, 
            projectManager_C, salesManager, seniorProgramDeveloper_A, seniorProgramDeveloper_B, 
            financialAdministrator, programDeveloper_A, programDeveloper_B, programDeveloper_C, 
            systemAdministrator_A, systemAdministrator_B, systemAdministrator_C, systemAnalyst_A, 
            systemAnalyst_B, systemAnalyst_C, receptionist};
        return salariedEmployees;
    }
    
     public IPaidPerson[] getContractedEmployees() {
        IPaidPerson[] contractedEmployees = {salesConsultant, tester_A, tester_B, 
            tester_C, tester_D};
        return contractedEmployees;
    }
    
        public IPaidPerson[] getAllEmployees() {
        IPaidPerson[] allEmployees = {ceo, hrOfficer, adminManager, branchManager_A, 
            branchManager_B, branchManager_C, projectManager_A, projectManager_B, 
            projectManager_C, salesManager, seniorProgramDeveloper_A, seniorProgramDeveloper_B, 
            financialAdministrator, programDeveloper_A, programDeveloper_B, programDeveloper_C, 
            systemAdministrator_A, systemAdministrator_B, systemAdministrator_C, systemAnalyst_A, 
            systemAnalyst_B, systemAnalyst_C, receptionist, salesConsultant, tester_A, tester_B, 
            tester_C, tester_D};
        return allEmployees;
    }
}
