package LabTest01;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee_Demo
{
	static 
	{
	    String raj ="\n*************************************";
		   raj+="\n* MCS 171 - Java Lab Test - 01      *";
	           raj+="\n* Name    : Rajkumar B L            *";
	           raj+="\n* Reg.No  : 2047120                 *";
	           raj+="\n*************************************";  
	    System.out.println(raj);
	}
	
	
	public static void main(String[] args) 
	{
			
		int noOfEmp=0;
		Scanner stdInp = new Scanner(System.in);
		System.out.println("Enter the number of employees to add to the Company: ");
		try
		{
		   noOfEmp =  Integer.parseInt(stdInp.nextLine()); 
		}catch(Exception e)
		{
			System.out.println("Invalid entry!");
			System.out.println(e.getMessage());
		}
		ArrayList<EmployeeSalary> empList = new ArrayList<EmployeeSalary>();
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		for(int k=0; k < noOfEmp; k++)
		{
			System.out.println("\n==============================");
			System.out.println("        Employee ---> "+ (k+1)+"       ");
			System.out.println("===============================");
			empList.add(new EmployeeSalary());
			empList.get(k).read();
			
			int currentID = empList.get(k).employeeID; 
			if(!ids.contains(currentID)) 
			 {
				ids.add(currentID);
			 }  
			else
			{
				while(ids.contains(currentID))
				{
					empList.get(k).empIdGenr();
					currentID = empList.get(k).employeeID;
					if(!ids.contains(currentID)){ids.add(currentID);break;}
				}
			}
			System.out.println("||| Employee information has been successfully updated to the list  ||| ");
			System.out.println("\n*****************************");
			System.out.println("       Ended ---> "+ (k+1)+"   ");
			System.out.println("********************************");
		}
		
		
		double crnthighEmpNetSal=0, ctr=0;
		double crntlowEmpNetSal=0;
		ArrayList<Integer> highEmplist = new ArrayList<Integer>();
		ArrayList<Integer> lowEmplist = new ArrayList<Integer>();
		double highEmpNetSal = 0;
		double lowEmpNetSal = 0;
		
		if(empList.size()>0)
		{
			highEmpNetSal=empList.get(0).Net_salary();
			lowEmpNetSal=empList.get(0).Net_salary();
			for(int k=0; k < empList.size(); k++)
			{
				crnthighEmpNetSal = empList.get(k).Net_salary();
				//HighestNetSalary
				if (crnthighEmpNetSal > highEmpNetSal)
				{   
					highEmpNetSal = crnthighEmpNetSal;
					highEmplist.clear();
					highEmplist.add(k);
	            }
				else if (crnthighEmpNetSal == highEmpNetSal)
				{
				   highEmplist.add(k);
				}
				
				//LowestNetSalary
				crntlowEmpNetSal = empList.get(k).Net_salary();
				if (crntlowEmpNetSal < lowEmpNetSal)
				{   
					lowEmpNetSal = crntlowEmpNetSal;
					lowEmplist.clear();
					lowEmplist.add(k);
	            }
				else if (crntlowEmpNetSal == lowEmpNetSal)
				{
					lowEmplist.add(k);
				}
		    }
			
			int cnt=1;
			System.out.println("========================================");
			System.out.println("    Highest Net Salary Employess        ");
			System.out.println("========================================");
			for(int k : highEmplist)
			{
				//System.out.println(cnt+". "+ empList.get(k).name);
				System.out.println("Emplyoyee "+cnt);
				empList.get(k).display();
				System.out.println();
			}
			System.out.println("================***====================");	
			
			cnt=1;
			System.out.println("\n========================================");
			System.out.println("    Lowest Net Salary Employess        ");
			System.out.println("========================================");
			for(int k : lowEmplist)
			{
				//System.out.println(cnt+". "+ empList.get(k).name);
				System.out.println("Emplyoyee "+cnt);
				empList.get(k).display();
				System.out.println();
			}
			System.out.println("================***====================");	
		}
		else
		{
			System.out.println("\n========================================");
			System.out.println("         No Employess in company         ");
			System.out.println("========================================");
		}
	}
}