package Lab03;

public interface CarRentalSystem 
{
	
	void menu(); //Display the menu to the user
	
	void register(); //Create new membership/account
	
	void login(); //Login with credentials and manage the account
	
	void quit(); //Exit/quit from the web-site
	
	void car_availability_details(); //Display Car availability details
	
	void account_details(int cust_id); //Display particular customer account details
	
	void rent_car(); //Rent an available car for a day
	
	void account_bal_payee(); //Check account balance and make necessary payments

}
