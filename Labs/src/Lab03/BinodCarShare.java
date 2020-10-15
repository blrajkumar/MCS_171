package Lab03;

/* *********************************************************
 * MCS 172 - Java
 * Lab 03
 * Student Full Name   : Rajkumar B L  
 * Student ID number   : 2047120
 * Domain - Car Rental Management System
 **********************************************************/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class BinodCarShare implements CarRentalSystem 
{
	private static StringBuffer comp_first_name;
	private static StringBuffer comp_name;
	private static StringBuffer comp_addr;
	private static StringBuffer comp_phone;
	private static ArrayList<ArrayList<String> > car_list =  new ArrayList<ArrayList<String>>();
	private static Map<Integer,String[]> cust_info = new HashMap<Integer,String[]>();
	private static ArrayList<Integer> list_cust_ids = new ArrayList<Integer>();
    
	public BinodCarShare()
	{
		menu();
	}
	
	public BinodCarShare(String menu_opt) 
	{
		menu(menu_opt);
	}

	static 
	{
		comp_first_name = new StringBuffer("BINOD");
		comp_name  = new StringBuffer();
		comp_name.append(comp_first_name + comp_sur_name);
	    comp_addr  = new StringBuffer("52 - Haynes Avenue, North York, Tiruppur, Tamilnadu, India - 641663");
		comp_phone = new StringBuffer("0421 - 2047120");
		
		//Create a list of string using .aslist and type cast to ArrayList and finally add each ArrayList to bigger ArrayList
		car_list.add(new ArrayList<String>(Arrays.asList("Chev-Beat","Auto","Hatchback","2000","  Not-Available")));
		car_list.add(new ArrayList<String>(Arrays.asList("Nissan-Macro","Manual","Hatchback","1500"," Available")));	
		car_list.add(new ArrayList<String>(Arrays.asList("kia-Forte","Auto","Sedan","3000","  Not-Available")));
		car_list.add(new ArrayList<String>(Arrays.asList("Toyoto-Corolla","Auto","Sedan","2500"," Available")));
		car_list.add(new ArrayList<String>(Arrays.asList("Nissan-Rogue","Auto","SUV","4000","   Available")));
		
	    System.out.println("**********************************");
	    System.out.println("*    ______                      *");
	    System.out.println("*   /|_||_\\`.__                  *");
	    System.out.println("*  (   _    _ _\\  " + getComp_name() + " *");
	    System.out.println("*  =`-(_)--(_)-'                 *");
	    System.out.println("*                                *");
	    System.out.println("**********************************");  
	    welcome.welcome_note();
	}
	
	static class welcome
	{
		private static void welcome_note()
		{
			 System.out.println("\nWelcome to "+getComp_name()+" homepage");
		}
	}
	
	//****************************************************************
	//****************    Getters and Setters  ***********************
	
	public static String getComp_name() {
		return comp_name.toString();
	}

	protected static void setComp_name(String comp_name) {
		BinodCarShare.comp_first_name.replace(0, BinodCarShare.comp_first_name.length(), comp_name.toUpperCase());
		BinodCarShare.comp_name.setLength(0);
		BinodCarShare.comp_addr.ensureCapacity(comp_name.length());
		BinodCarShare.comp_name.append(BinodCarShare.comp_first_name.toString()+comp_sur_name);
	}

	public static String getComp_addr() {
		return comp_addr.toString();
	}

	protected static void setComp_addr(String comp_addr) {
		BinodCarShare.comp_addr.replace(0, BinodCarShare.comp_addr.length(), comp_addr);
	}

	public static String getComp_phone() {
		return comp_phone.toString();
	}

	protected static void setComp_phone(String comp_phone) {
		//BinodCarShare.comp_phone.ensureCapacity(comp_phone.length());
		BinodCarShare.comp_phone.replace(0, BinodCarShare.comp_phone.length(), comp_phone);
	}
	
	//Returns the entire car_list
	public static ArrayList<ArrayList<String>> getCar_list() {
		return car_list;
	}
 
	//Adds new car to the car_list
	protected static void add_Car_list(ArrayList<String> car_list) {
		BinodCarShare.car_list.add(car_list);
	}
	
	//Return customer information of the given cust_id
	protected static  String[] getCust_info(int cust_id) {
		return cust_info.get(cust_id);
	}
    
	//Add new customer to cust_info
	protected static void add_Cust_info_list(int cust_id,String [] mem_info) {
		BinodCarShare.cust_info.put(cust_id,mem_info);
	}
	
	protected static ArrayList<Integer> getList_cust_ids() {
		return list_cust_ids;
	}

	protected static void add_cust_id_list(int cust_id) {
		BinodCarShare.list_cust_ids.add(cust_id);
	}
	
	//************* Getters and Setters -- > End  ********************
	//****************************************************************
	
	
	//****************************************************************
    //******************  Interface Methods  *************************
	@Override
	public void menu() 
	{
		char choice;
		Scanner in=new Scanner(System.in);
		
		boolean valid_input = false;
		do
		{
			System.out.println("----------------------------------");
			System.out.println("              Menu                ");
			System.out.println("----------------------------------");
			System.out.println("r/R || Register for membership");
			System.out.println("l/L || Login to your account");
			System.out.println("c/C || Car availability list");
			System.out.println("q/Q || Exit from the Webpage");
			System.out.println("----------------------------------");
			System.out.println("Choose from the above menu options:");
			choice = in.nextLine().charAt(0);
			choice = Character.toLowerCase(choice);
		
			switch(choice)
			{
			  case 'r':
				  register();
				  System.out.println("\nWelcome to "+getComp_name()+" homepage");
				  valid_input = false;
				  break;
			  case 'l':
				  login();
				  System.out.println("\nWelcome to "+getComp_name()+" homepage");
				  valid_input = false;
				  break;
			  case 'c':
				  car_availability_details();
				  System.out.println("\nWelcome to "+getComp_name()+" homepage");
				  valid_input = false;
				  break;
			  case 'q':
				  quit();
				  valid_input = true;
				  break;
			  default:
				  System.out.println("\nInvalid Option! Try again");
				  valid_input = false;
			}
		}while(!valid_input);		
	}


	@Override
	public void register() 
	{
		System.out.println("\n**********************************");
		System.out.println("*           Register             *");
	    System.out.println("**********************************");
		if(membership_intial_note()) {enroll();}
	}
	
	@Override
	public void login() 
	{
		System.out.println("\n**********************************");
		System.out.println("*             Login              *");
	    System.out.println("**********************************");
		System.out.println("This site is under construction :)");
	}
	
	@Override
	public void quit() 
	{
		 end_note();
	}

	@Override
	public void car_availability_details() 
	{
		System.out.println("\n**********************************");
		System.out.println("*        Car Availability        *");
	    System.out.println("**********************************");
		for(int x=0; x<getCar_list().size();x++)
		{
			System.out.print((x+1) + ". " + getCar_list().get(x).get(0)); // Car - Company (Model)
			System.out.print("("+getCar_list().get(x).get(1)+", "); // Car - Gear (Auto/Manual)
			//System.out.print(getCar_list().get(x).get(2)+", "); // Car - Size (Hatchback/Sedan/Full)
			//System.out.print(getCar_list().get(x).get(3)+", "); // Car - Rent (Price)
			System.out.print(getCar_list().get(x).get(4)+")" +"\n"); // Car - Availability
		}
		System.out.println("**********************************");
	}
	  
	@Override
	public void account_details(int cust_id) 
	{
		account_details(getCust_info(cust_id));
	}
	
	@Override
	public void rent_car() {
		// Yet to be designed

	}

	@Override
	public void account_bal_payee() {
		// Yet to be designed

	}

	//****************************************************************
    //*************** Interface Methods --> End **********************
	
	
	//****************************************************************
    //**************** Abstract Methods --> End **********************

	protected abstract void enroll();
	protected abstract int cust_id_generator();
	
	//****************************************************************
    //**************** Abstract Methods --> End **********************
	
	//****************************************************************
    //********************* Class Methods ****************************
	
	private void menu(String menu_opt) 
	{
		switch(menu_opt.toLowerCase())
		{
		  case "register":
			  register();
			  break;
		  case "login":
			  login();
			  break;
		  case "availability":
			  car_availability_details();
			  break;
		  default:
			  System.out.println("\nInvalid Option! Try again");
			  menu();
		}
	}

	
	private boolean membership_intial_note()
	{
		boolean cust_choice=false;
		Character appl_mem_resp='n';
		Scanner in=new Scanner(System.in);
		
	    System.out.println("We the team of "+getComp_name()+" are happy to invite you to be part of our family");
		System.out.println("Would you like to apply membership for yourself or for your family member.");
		System.out.println("Enter your choice as y/n:");
		appl_mem_resp = in.nextLine().charAt(0); 
		appl_mem_resp = Character.toLowerCase(appl_mem_resp);
		 if( !(appl_mem_resp.equals('n')) && !(appl_mem_resp.equals('y')) )
		 {
			 while( !(appl_mem_resp.equals('n')) && !(appl_mem_resp.equals('y')) )
			 {
				 System.out.println("Invalid option. Please choose among the following options.Y/n:");
				 appl_mem_resp=in.nextLine().charAt(0); 
				 appl_mem_resp = Character.toLowerCase(appl_mem_resp);
			 }
		 }
		if(appl_mem_resp.equals('y'))
	    {
	    	cust_choice = true;
	    }
		return cust_choice;
	}
	
	public void account_details(String cust_mem[]) 
	{
		System.out.println("\n--------------------------------------------");
		 System.out.println("            Member Details                  ");
		 System.out.println("--------------------------------------------");
		 System.out.println("Name           : "+cust_mem[0]
				            +"\nAddress        : "+cust_mem[1]
				            +"\nOccupation     : "+cust_mem[2]
				            +"\nDriver License : "+cust_mem[3]
				            +"\nContact        : "+cust_mem[4]);
		 System.out.println("--------------------------------------------");	
	}
	
	protected static void end_note()
	{
		System.out.println("\nThank you for visiting us today.");
		System.out.println("We wish you a wonderful day ahead.");
		System.out.println("**********************************");
		System.out.println("*      Life is a Journey         *");
		System.out.println("*       ENJOY THE RIDE           *");
		System.out.println("**********************************");
	}
}
