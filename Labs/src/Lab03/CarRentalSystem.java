package Lab03;

/* *********************************************************
 * MCS 172 - Java
 * Lab 03
 * Student Full Name   : Rajkumar B L  
 * Student ID number   : 2047120
 * Domain - Car Rental Management System
 **********************************************************/

public interface CarRentalSystem 
{
    static final String comp_sur_name = " CARSHARE";
	
	void menu(); //Display the menu to the user
	
	void register(); //Create new membership/account
	
	void login(); //Login with credentials and manage the account
	
	void quit(); //Exit/quit from the web-site
	
	void car_availability_details(); //Display Car availability details
	
	void account_details(int cust_id); //Display particular customer account details
	
	void rent_car(); //Rent an available car for a day
	
	void account_bal_payee(); //Check account balance and make necessary payments

}
