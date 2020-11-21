package Lab06;


/* *********************************************************
 * MCS 172 - Java
 * Lab 03
 * Student Full Name   : Rajkumar B L  
 * Student ID number   : 2047120
 * Domain - Car Rental Management System
 **********************************************************/

import java.util.Scanner;

public class Member extends BinodCarShare
{
	private int cust_id;
	
	public Member()
	{
		
	}

	public Member(String menu)
	{
		super(menu);
	}
	
	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	
	private String verify_user_details()
	{
		 Scanner in=new Scanner(System.in);
		 Character valid ='n';
		 // Getting verification from the user to check
		 //If the above entered details are correct
		 System.out.println("Please verify if the above information is Correct?Y/n:");
		 valid = in.nextLine().charAt(0); 
		 valid = Character.toLowerCase(valid);	 
		 
		 //If the user enters "n" --> meaning the information is incorrect
		 //The do part --> customer entry details is repeated, where the user enters the details again
		 if(valid.equals('n')) {
			 System.out.println("\nPlease re-enter the correct details:-");
			 }
		 else if( !(valid.equals('n')) && !(valid.equals('y')) ){
			 while( !(valid.equals('n')) && !(valid.equals('y')) )
			 {
				 System.out.println("Invalid option. Please choose among the following options.Y/n:");
				 valid=in.nextLine().charAt(0); 
			 }
			 if(valid.equals('n')) 
			 {
				 System.out.println("\nPlease re-enter the correct details:-");
			 }
		 }
		 else{
			 
		 }
		 valid = Character.toLowerCase(valid);
		 return valid.toString();
	}
	
	public void membership_msg(String ocup)
	{

	  if (ocup.equalsIgnoreCase("student"))	
	  {
		  System.out.println("Thank you for choosing "+super.getComp_name()+"!\n"
		  	     +"You made the right choice. We are happy to have you onboard\n"
		             +"To celebrate your choice, we are happy to offer you with one year free membership\n"
		             +"----------------------------------\n"
				     +"|    Your user id --> " + this.getCust_id() + "    |\n"
				     +"----------------------------------\n");
		  get_user_crdntl();
	  }
	  else
	  {
		  System.out.println("Thank you for choosing "+super.getComp_name()+"!\n"
		  	     +"The complete membership portfolio for "+ocup+"'s is yet to be designed"
		   	     +"\nSorry for the inconvinience caused. Stay tuned for further updates.");
	  }
	  
	}
	
	private void member_add(String [] mem_info)
	{
		super.add_Cust_info_list(getCust_id(),mem_info);
	}
	
	//@Override
	protected void enroll() 
	{
		String cust_mem[] = new String[6];
		Scanner in=new Scanner(System.in);
		Character valid ='n';
		System.out.println("Enter the details of the member:-"); 
		do {	 
			 // Getting user details and storing them in an array --> cust_mem
			 System.out.println("Enter your name: ");
			 cust_mem[0]=in.nextLine();
			 System.out.println("Enter your Address: ");
			 cust_mem[1]=in.nextLine();
			 System.out.println("Enter your Occupation: ");
			 cust_mem[2]=in.nextLine();
			 System.out.println("Enter your Driver License: ");
			 cust_mem[3]=in.nextLine();
			 System.out.println("Enter your Contact information: ");
			 cust_mem[4]=in.nextLine();	
			 //Prints the details of current customer 
			 super.account_details(cust_mem);
			 //Call verify_user_details method to handle the verification part 
		     valid = verify_user_details().charAt(0); 
		 }
		 while (!(valid.equals('y')));
		
		
	     cust_mem[5]="CRS"+cust_id_generator();
		 membership_msg(cust_mem[2]);
		 //Calling the member_add function to load all the info to the cust_info database
		 member_add(cust_mem);
	}

	protected int cust_id_generator() 
	{
		//Math.random generates a value between 0 to 1
		//To Generate random int value from 2047100 to 2047300
		//Syntax --> Math.random() * (max - min + 1) + min
		setCust_id(((int)(Math.random() * (2047300 - 2047100 + 1) + 2047100)));
				
				if(!super.getList_cust_ids().contains(getCust_id()))
				{
					super.add_cust_id_list(getCust_id());
				}
				else 
				{
					while(super.getList_cust_ids().contains(getCust_id()))// To repeat the process until a unique id is generated
					{
						setCust_id(((int)(Math.random() * (2047102 - 2047100 + 1) + 2047100)));
						if(!super.getList_cust_ids().contains(getCust_id())){super.add_cust_id_list(getCust_id());break;}//Adds the newly created unique randomised student id to the "IDS" arraylist
					}
				}
		return getCust_id();
	}
	
	//Get and add cust id and pass to the common cust_id_pass list
	private void get_user_crdntl()
	{
		String pass;
		Scanner in=new Scanner(System.in);
		System.out.println("Set password for your account:-"); 
		pass=in.nextLine();
		super.add_cust_id_pass(getCust_id(), pass);
	}
}
