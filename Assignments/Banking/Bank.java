package A2_Banking;

interface Bank 
{
	void createAccount(); // Creating new account for particular bank
	
	void deposit(double amount);
	
	void withdraw(double amount);
	
	double getBalance();
	
	double getAnnualInterest(); //Returns annual interest
}
