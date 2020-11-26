package LabTest02;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank_Demo 
{
	
	private static double crnt_max;
	
	static 
	{
	    String raj ="\n*************************************";
		   raj+="\n* MCS 171 - Java Lab Test - 02      *";
	           raj+="\n* Name    : Rajkumar B L            *";
	           raj+="\n* Reg.No  : 2047120                 *";
	           raj+="\n*************************************";  
	    System.out.println(raj);
	}
	
	private static void endnote()
	{
		System.out.println("\nThank you for choosing us for your banking needs.");
		System.out.println("Have a great day ahead.");
	}
	public static void main(String args[])
	{
		  int noOfPrsn=0; Scanner stdInp = new Scanner(System.in);
		  System.out.println("Enter the number of Person's to create bank account: ");
		  try {
		  noOfPrsn = Integer.parseInt(stdInp.nextLine());
		  }catch(Exception e)
			{
				System.out.println(e.getMessage());
				System.out.println("Invalid entry! Expected Integer value is not entered :(");
			}
		  
		  int prsn_index_max_bal = 0; double final_max_bal = 0; double crnt__max;
		  ArrayList<Integer> highbalprsnlist = new ArrayList<Integer>();
		  
		  String name; String email; char acnt_typ; char trns;
		  Person[] prsn = new Person[noOfPrsn]; 
		  for(int x=0; x< prsn.length;x++) 
		  {
			  System.out.println("\n------------------------"); 
			  System.out.println("|    Person ----> " + (x+1)+"    |"); 
			  System.out.println("------------------------");

			  System.out.println("Enter your Name: "); 
			  String unchnm = stdInp.nextLine();
			  name=Character.toUpperCase(unchnm.charAt(0))+(unchnm.substring(1,unchnm.length()).toLowerCase());
					  
			  System.out.println("Enter your email: "); 
			  email = stdInp.nextLine();
			  
			  System.out.println("Choose from the below option for the type of account to be created (c/s):-"
			  ); System.out.println("Current Account ----> 'c'");
			  System.out.println("Savings Account ----> 's'"); 
			  acnt_typ = stdInp.nextLine().charAt(0);
			  
			  prsn[x] = new Person(name,email,acnt_typ);
			  
			  boolean valid_trn = false;
			  while(!valid_trn)
			  {
				  System.out.println("Would you like to perform any transactions? y/n");
				  trns = stdInp.nextLine().charAt(0);
				  
				  if(trns == 'y' || trns == 'Y' )
				  {
					  prsn[x].transactions();
					  valid_trn = true;
				  }
				  else if(trns == 'n' || trns == 'N' )
				  {
					  valid_trn = true;
				  }
				  else
				  {
					  System.out.println("Invalid choice. Try again! y/n");
					  valid_trn = false;
				  }
				  
			  }
			  
		  
		  }
		  if(noOfPrsn>=1)
			 {
				 prsn_index_max_bal=0;
				 final_max_bal=prsn[0].getBalance();
				 highbalprsnlist.add(0);
				 if(noOfPrsn>1)
				 {
					 for(int y=1;y<noOfPrsn;y++)
					 {
						  if(final_max_bal==prsn[y].getBalance())
						  {
							  highbalprsnlist.add(y);
						  }
						  else
						  {
							  crnt_max=Math.max(final_max_bal,prsn[y].getBalance());
						  }
						  if (crnt_max == prsn[y].getBalance()) 
						  {
							  prsn_index_max_bal=y;
							  final_max_bal=prsn[y].getBalance(); 
							  highbalprsnlist.clear();
							  highbalprsnlist.add(y);
						  }
					 }
				  }
			 }
			 
			    
			 if(highbalprsnlist.size()>=1) 
			 {
				 System.out.println(highbalprsnlist);
				 System.out.println("========================================");
				 System.out.println("     Highest Balance Custome(r/rs)      ");
			   	 System.out.println("========================================");
				 for(int x1=0;x1<highbalprsnlist.size();x1++)
				 {
					 System.out.println("Printing the Account deatails:");
					 System.out.println("Customer : "+(x1+1));
					 prsn[x1].accountDetails();
					 System.out.println("========================================");
				 }
				 System.out.println("========================================");    
			 }

		
		endnote();
	     
	}
}