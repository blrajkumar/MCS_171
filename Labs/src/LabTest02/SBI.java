package LabTest02;

import java.util.ArrayList;

public class SBI implements Bank {
	
	static String bank_name = "SBI";
	static String branch_id;
	static String branch;
	static String location;
	private double balance;
	private double monthly_interest_rate;
	protected static ArrayList<Integer> list_person_ids = new ArrayList<Integer>();
	protected static ArrayList<Long> list_account_nums = new ArrayList<Long>();
    
	public SBI() {
		createAccount();
	}
	
	@Override
	public void createAccount() {
		branch_id = "031288";
		branch    = "SBI - TIRUPUR";
		location  = "PN ROAD,TIRUPUR-641601";
		setMonthlyInterest(3.5);
	}

	@Override
	public void deposit(double amount) {
		if(amount>=1) {
		setBalance(balance+amount);
        System.out.println("Amount Successfully deposited");
        }
		else {
			System.out.println("Something went wrong. Try again in sometime!");
		}
	}

	@Override
	public void withdraw(double amount) throws Insufficientbalance
	{
		if( (this.getBalance() - amount)<0)
		{
			throw new Insufficientbalance("Insuffician Balance Exception Occured!\nThe withdraw amount exceeds current account balance :(");
		}
		else {setBalance(balance-amount);}
	}
    

	public void setBalance(double amt) {
		this.balance = amt;
	}
	
	@Override
	public double getBalance() {
		return this.balance;
	}

	@Override
	public double getAnnualInterest() {
		return this.monthly_interest_rate/100;
	}
	
	void setMonthlyInterest(double ir) {
		this.monthly_interest_rate = ir;
	}

}
