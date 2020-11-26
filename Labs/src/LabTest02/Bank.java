package LabTest02;

interface Bank 
{
	void createAccount(); 
	
	void deposit(double amount);
	
	void withdraw(double amount) throws Insufficientbalance;
	
	double getBalance();
	
	double getAnnualInterest();
}
