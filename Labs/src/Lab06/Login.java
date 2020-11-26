package Lab06;

import java.util.Scanner;

import PassMasking.PasswordField;

public class Login extends BinodCarShare
{
	private int id;
	private String pass;
	private boolean admin=false;
	
	public Login()
	{
	}
    
	protected boolean verify_details()
	{
		int userid;
		String pass;
		boolean valid=false;
		int attempt=0;
		
		while(!valid && attempt <4)
		{
			Scanner in=new Scanner(System.in);
			System.out.println("Enter the user id: ");
		    userid = Integer.parseInt(in.nextLine());
		    //pass = PasswordField.readPassword("Enter the password:");
		    System.out.println("Enter the password:");
		    pass = in.nextLine();
    		attempt++;
		    if(contains_cust_id(userid))
		    {
		    	if(get_cust_id_pass(userid).equals(pass))
		    	{
		    		id = userid;
		    		this.pass = pass;
		    		if (id == 2131197 && this.pass.equals("Binod197!")) {
		    			admin=true;
		    		}
		    		System.out.println("Login Successfull !!!");
		    		if(admin) {System.out.println("\nWelcome Admin");}
		    		valid=true;
		    	}
		    }
		    if(!valid&&attempt<4)
	    	{
	    		System.out.println("Invalid Username/Password. Try again!");
	    		System.out.println("Account will be locked after 3 uncessfull tries.\n");
	    		System.out.println("Attempt : "+(attempt));
	    	}
		    if(attempt==4)
		    {
		    	System.out.println("Account Locked :(");
		    }
		}
		
		return valid;
	}

	protected void login_menu() 
	{
		char choice;
		Scanner in=new Scanner(System.in);
		
		boolean valid_input = false;
		do
		{
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("           Login Menu             ");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			if(!admin)
			{
				System.out.println("A|a || Account Details");
			}
			System.out.println("c/C || Car availability list");
			System.out.println("b/B || Book a car");
			System.out.println("q/Q || Logout");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Choose from the above menu options:");
			choice = in.nextLine().charAt(0);
			choice = Character.toLowerCase(choice);
		
			switch(choice)
			{
			  
				  case 'a':
						  if(!admin)
						  {
							  account_details(getCust_info(id));
							  valid_input = false;
						  }
						  else
						  {
							  System.out.println("\nInvalid Option! Try again");
						  }
						  break;
				  case 'c':
						  car_availability_details();
						  valid_input = false;
						  break;
				  case 'b':
						  if(!admin)
						  {
							  try
							  {
							    book_car();
							    
							  }catch (InvalidLicenseException licen)
							  {
								  
								  System.out.println(licen.getMessage());
							  }
						  }
						  else
						  {
							  admin_multi_booking();
						  }
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
	
	private void admin_multi_booking()
	{
		BookCar b1 = new BookCar(2047120,"#NS1112");
		BookCar b2 = new BookCar(2047197,"#NS1112");
		Thread t1 =new Thread(b1);
		Thread t2 =new Thread(b2);
		t1.start();
		t2.start();
		while(t1.isAlive() || t2.isAlive()) 
		{
			
	    }
		
	}
}
