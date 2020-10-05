package Lab02;

/* *********************************************************
 * MCS 172 - Java
 * Lab 01
 * Student Full Name   : Rajkumar B L  
 * Student ID number   : 2047120
 **********************************************************/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class CarRentalSystem {
	
	static String comp_name;
	static String comp_addr;
	static String comp_phone;
	private static String[][] share_holders = new String[20][2];
	private static Map<String,String[]> cust_info = new HashMap<String,String[]>();
	private static String[][] car_info =  { 
			     {"Chev-Beat","Auto","Hatchback","2000","Available"},
				 {"Nissan-Macro","Manual","Hatchback","1500","Available"},
				 {"kia-Forte","Auto","Sedan","3000","Available"},
				 {"Toyoto-Corolla","Auto","Sedan","2500","Available"},
				 {"Nissan-Rogue","Auto","SUV","4000","Available"} 
			   };
	
	//helper variables
	private int cust_info_pointer = 0;
	private int cust_id_generator = 0;
       
	public CarRentalSystem() {}
	
	//Static block --> this gets executed before the main method
	// Intializes static variables
	static 
	{
		comp_name  = "Binod CarShare";
	    comp_addr  = "52 - Haynes Avenue, North York, Tiruppur, Tamilnadu, India - 641663";
		comp_phone = "0421 - 2047120";
		
	    System.out.println("**********************************");
	    System.out.println("*    ______                      *");
	    System.out.println("*   /|_||_\\`.__                  *");
	    System.out.println("*  (   _    _ _\\  BINOD CARSHARE *");
	    System.out.println("*  =`-(_)--(_)-'                 *");
	    System.out.println("*                                *");
	    System.out.println("**********************************");    
	 }
	
	//Static class need no reference object of outer class to call methods
	//Static class can have access to only static members of the outer class 
	static class welcome
	{
		private static void welcome_note()
		{
			 System.out.println("Welcome to "+comp_name+" ");
			 System.out.println("");
		}
	}
	
	public String[][] getShare_holders() {
		return share_holders;
	}

	public void setShare_holders(String[][] share_holders) {
		this.share_holders = share_holders;
	}
	private void get_user_details()
	{
		
	}
	
	
	private int membership_intial_note()
	{
		int no_of_cust=0;
		Character appl_mem_resp='n';
		Scanner in=new Scanner(System.in);
		
	    System.out.println("We the team of "+comp_name+" would like to invite you to be part of our family");
		System.out.println("Would you like to apply membership for yourself and your family members.");
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
	    	System.out.println("Enter the number of cutomers,");
	    	System.out.println("for whom you would like to apply for the membership.");
	    	System.out.println("Input in range (1 to 10): ");
	    	no_of_cust = Integer.parseInt(in.nextLine());
	    	while((no_of_cust<1) || (no_of_cust>10))
	    	{
	    		System.out.println("Invalid option. Please enter in the range (1 t0 10): ");
	    		no_of_cust = Integer.parseInt(in.nextLine());	
	    	}
	    }
		return no_of_cust;
	}
	
	public String membership_msg(String ocup)
	{
	  String outp_msg="";
	  if (ocup.equalsIgnoreCase("student"))	
	  {
		  outp_msg = "Thank you for choosing "+comp_name+"!\n"
		  	     +"You made the right choice. We are happy to have you onboard\n"
		             +"To celebrate your choice, we are happy to offer you with one year free membership\n"
		             +"Stay tuned for further updates";
	  }
	  else
	  {
		  outp_msg = "Thank you for choosing "+comp_name+"!\n"
		  	     +"The complete membership portfolio for "+ocup+"s is yet to be designed"
		   	     +"\nSorry for the inconvinience caused. Stay tuned for further updates";
	  }
	  
	  return outp_msg;
	}
	
	private String verify_user_details()
	{
		 Scanner in=new Scanner(System.in);
		 Character valid ='n';
		 // Getting verification from the user to check
		 //If the above entered details are correct
		 System.out.println("Please verify if the above information is Correct.Y/n:");
		 valid = in.nextLine().charAt(0); 
		 valid = Character.toLowerCase(valid);	 
		 
		 //If the user enters "n" --> meaning the information is incorrect
		 //The do part --> customer entry details is repeated, where the user enters the details again
		 if(valid.equals('n')) {
			 System.out.println("Please re-enter the correct deatails: \n");
			 }
		 else if( !(valid.equals('n')) && !(valid.equals('y')) ){
			 while( !(valid.equals('n')) && !(valid.equals('y')) )
			 {
				 System.out.println("Invalid option. Please choose among the following options.Y/n:");
				 valid=in.nextLine().charAt(0); 
			 }
			 if(valid.equals('n')) 
			 {
				 System.out.println("Please re-enter the correct details: \n");
			 }
		 }
		 else{
			 
		 }
		 valid = Character.toLowerCase(valid);
		 return valid.toString();
	}
	
	
	private static void end_note()
	{
		 System.out.println("Thank you for visting our website.");
		 System.out.println("We wish you a wonderful day ahead.");
		 System.out.println("**********************************");
		 System.out.println("*      Life is a Journey         *");
		 System.out.println("*       ENJOY THE RIDE           *");
		 System.out.println("**********************************");
	}
	
	public void system_enrolling()
	{
		 Scanner in=new Scanner(System.in);
		 Character valid ='n';
		 int no_of_cust=0;
		 
		 //calling membership_intial_note() method to ask if the user
		 //wants to apply for membership for them and their family
		 //and return int value of number of members applying
		 no_of_cust = membership_intial_note();
		 
		 //Only execute if the no_of_cust is greater than 0
		 //If the no_of_cust=0 this means that the user does'nt want to apply for membership
		 //Hence we don't execute the if block when it is zero
		 if(no_of_cust>0)
		 {
			 String cust_mem[][] = new String[no_of_cust][6];
			 for(int x=1; x<=no_of_cust; x++)
			 {   
				 System.out.println("Enter the details for member "+x+": "); 
				 do {	 
					 // Getting user details and storing them in an array --> cust_mem
					 System.out.println("Enter your name: ");
					 cust_mem[x-1][0]=in.nextLine();
					 System.out.println("Enter your Address: ");
					 cust_mem[x-1][1]=in.nextLine();
					 System.out.println("Enter your Occupation: ");
					 cust_mem[x-1][2]=in.nextLine();
					 System.out.println("Enter your Driver License: ");
					 cust_mem[x-1][3]=in.nextLine();
					 System.out.println("Enter your Contact information: ");
					 cust_mem[x-1][4]=in.nextLine();
					 System.out.println("\nThank you for entering the details.");
					 System.out.println("Name: "+cust_mem[x-1][0]
							            +"\nAddress: "+cust_mem[x-1][1]
							            +"\nOccupation: "+cust_mem[x-1][2]
							            +"\nDriver License: "+cust_mem[x-1][3]
							            +"\nContact: "+cust_mem[x-1][4]);
					 
					 //Call verify_user_details method to handle the verification part 
				     valid = verify_user_details().charAt(0); 
				 }
				 while (!(valid.equals('y')));
		         //cust_mem[5]="CRS"+cust_id_generator;
				 System.out.println(membership_msg(cust_mem[x-1][2]));
				 
			  }
			 //Calling the member_add function to load all the info to the cust_info database
			 member_add(cust_mem);
		 }
		 else
		 {
			 System.out.println("\n============= End ================\n\n");
		 }
	   }


	private void member_add(String [][] mem_info)
	{
	    for(int x=0;  x<mem_info.length; x++)
	    {
	    	member_add(mem_info[x]);
	    }
	}
	
	private void member_add(String [] mem_info)
	{
		this.cust_info.put("CRS"+cust_id_generator,mem_info);
	}

	public static void main(String[] args)
	{ 
	  
	  CarRentalSystem.welcome stc_cls = new  CarRentalSystem.welcome();
	  stc_cls.welcome_note();
		  
	  if(args.length==1 && (Integer.parseInt(args[0]) >= 1))
	  {
		  CarRentalSystem[] cr = new CarRentalSystem[Integer.parseInt(args[0])];
		  for (int x=0; x < Integer.parseInt(args[0]); x++)
		  {
			  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			  System.out.println("|   Customer Membership -->  "+ (x+1) +"   |");
			  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			  cr[x] = new CarRentalSystem();
			  cr[x].system_enrolling();
		  }
		  
		  end_note();
		 
	  }
	  else
	  {
		  end_note();
	  }
    }
}