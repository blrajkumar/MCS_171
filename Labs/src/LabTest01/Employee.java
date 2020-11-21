package LabTest01;
import java.util.Scanner;

public class Employee extends Person {
	
    int employeeID;
    String companyName;
    String department;
    String designation;
    
    public Employee() {
    	super();
    }
    
     public void empIdGenr()
    {
    	this.employeeID = (int)(Math.random() * (2047300 - 2047100 + 1) + 2047100);
    }
    
    public void read()
    {
    	super.read();
    	empIdGenr();
    	
    	Scanner empInp = new Scanner(System.in);
    	System.out.println("Enter your Company Name: ");
	   	this.companyName = empInp.nextLine();
	   	 
	   	System.out.println("Enter your department: ");
	   	this.department = empInp.nextLine();
	 
	   	System.out.println("Enter your designation: ");
	   	this.designation = empInp.nextLine();
    }
    
     public void display()
     {
        super.show();	 
   	    System.out.println("Employee ID : " + this.employeeID
   	    				+ "\nCompany Name : " + this.companyName
   	    				+ "\nDepartment : " + this.department
   	    				+ "\nDesignation : " + this.designation);

     }

}