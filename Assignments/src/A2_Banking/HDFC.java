package A2_Banking;

public class HDFC implements Bank {
	
	static String bank_name = "HDFC";
	static String branch_id;
	static String branch;
	static String location;
	private double balance;
	private double monthly_interest_rate;
    
	public HDFC() {
		createAccount();
	}
	
	@Override
	public void createAccount() {
		branch_id = "031288";
		branch    = "HDFC - COIMBATORE";
		location  = "5A KALAPATTI MAIN ROAD COIMBOTORE 641604";
		setMonthlyInterest(4.0);
	}

	@Override
	public void deposit(double amount) {
		setBalance(balance+amount);
	}

	@Override
	public void withdraw(double amount) {
		try
		{
			if( (this.getBalance() - amount)<0)
			{
				throw new Insufficientbalance("The withdraw amount exceeds current account balance :(");
			}
			else {setBalance(balance-amount);}
		}catch(Insufficientbalance e)
		{
			System.out.println(e);
		}
	}
    

	public void setBalance(double amt) {
		balance = amt;
	}
	
	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public double getAnnualInterest() {
		return monthly_interest_rate/100;
	}
	
	void setMonthlyInterest(double ir) {
		monthly_interest_rate = ir;
	}

}
