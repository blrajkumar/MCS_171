package LabTest01;

import java.util.Scanner;

public class EmployeeSalary extends Employee
{

   double Basic;
   double DA;
   double HRA;
   double PF;
   double IT;
	   
   public void read()
   {
	  super.read();
	    	
	  Scanner empInp = new Scanner(System.in);
	  System.out.println("Enter your Basic: ");
	  this.Basic = Double.parseDouble(empInp.nextLine());
	   	 
	  System.out.println("Enter your DA: ");
	  this.DA = Double.parseDouble(empInp.nextLine());
	  
	  System.out.println("Enter your HRA: ");
	  this.HRA = Double.parseDouble(empInp.nextLine());
	  
	  System.out.println("Enter your PF: ");
	  this.PF = Double.parseDouble(empInp.nextLine());
	  
	  System.out.println("Enter your IT: ");
	  this.IT = Double.parseDouble(empInp.nextLine());
   }
   
   public double Net_salary()
   {
      double grossSalary = 0.0;
      double deduction = 0.0;
      double netSalary = 0.0;
      grossSalary = Basic+DA+HRA;
      deduction = grossSalary-PF-IT;
      netSalary= grossSalary - deduction;
     
      return netSalary;
   }
	   
}
		