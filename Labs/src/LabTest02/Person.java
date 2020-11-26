package LabTest02;

import java.util.ArrayList;
import java.util.Scanner;

public class Person extends SBI {
	
	private int person_id;
	private String name;
	private long account_num;
	private char account_type; // Current Account (c) , Savings Account (s)
	private String email;
	
	static {
		 System.out.println("**********************************");
		 System.out.println("* Welcome to our Banking System  *");
		 System.out.println("**********************************");
	}
	
	public Person(String prsn_name, String prsn_email, char prsn_acnt_type)
	{
		super();
		this.name = prsn_name;
		this.email = prsn_email;
		this.account_type = prsn_acnt_type;
		person_id_generator();
		account_num_generator();
	}
	
	private void person_id_generator()
	{
		this.setPerson_id((int)(Math.random() * (2047300 - 2047100 + 1) + 2047100));
		
		if(!list_person_ids.contains(this.getPerson_id()))
		{
			list_person_ids.add(this.getPerson_id());
		}
		else 
		{
			while(list_person_ids.contains(this.getPerson_id()))// To repeat the process until a unique id is generated
			{
				System.out.println("hello");
				this.setPerson_id((int)(Math.random() * (2047102 - 2047100 + 1) + 2047100));
				if(!list_person_ids.contains(this.getPerson_id())){list_person_ids.add(this.getPerson_id());break;}//Adds the newly created unique randomised student id to the "IDS" arraylist
			}
		}
	}
	

	private void account_num_generator()
	{
		this.setAccount_num((int)(Math.random() * (999999999L - 100000000L + 1) + 100000000L));
		
		if(!list_account_nums.contains(this.getAccount_num()))
		{
			list_account_nums.add(this.getAccount_num());
		}
		else 
		{
			while(list_account_nums.contains(this.getAccount_num()))// To repeat the process until a unique id is generated
			{
				System.out.println("hello");
				this.setAccount_num((int)(Math.random() * (999999999L - 100000000L + 1) + 100000000L));
				if(!list_account_nums.contains(this.getAccount_num())){list_account_nums.add(this.getAccount_num());break;}//Adds the newly created unique randomised student id to the "IDS" arraylist
			}
		}
	}
	
	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	
	public long getAccount_num() {
		return account_num;
	}

	public void setAccount_num(long account_num) {
		this.account_num = account_num;
	}
	
	void transactions()
	{
		char opt; Scanner stdInp = new Scanner(System.in);
		boolean trns = true;
		
		while(trns)
		{
			System.out.println("\nChoose the type of Transaction (d/w/q):-"); 
			System.out.println("Desposit --> 'd' "); 
			System.out.println("Withdraw --> 'w' ");
			System.out.println("Quit     --> 'q' ");
			opt = stdInp.nextLine().charAt(0);
			if (opt == 'd')
			{
				System.out.println("Enter the amount to be deposited:");
				this.deposit(Integer.parseInt(stdInp.nextLine()));
			}
			else if(opt == 'w')
			{
				System.out.println("Enter the amount to be withdrawn:");
				try 
				{
					this.withdraw(Integer.parseInt(stdInp.nextLine()));
				}catch (Insufficientbalance insuf)
				{
					   System.out.println(insuf.getMessage());
				}
			}
			else if(opt == 'q')
			{
				trns =false;
				System.out.println("Transaction Completed!");
			}
			else
			{
				System.out.println("Invalid option! Try again");
			}
		}
	}
	
	void accountDetails()
	{
		System.out.println("Person ID       : " + this.person_id);
		System.out.println("Name	        : " + this.name);
		System.out.println("Bank ID         : " + this.branch_id);
		System.out.println("Bank Name       : " + this.branch);
		System.out.println("Balance         : " + this.getBalance());
		System.out.println("Annual Interest : " + this.getAnnualInterest());
	}
}
