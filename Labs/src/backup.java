
/* *********************************************************
 * MCS 172 - Java
 * Lab 01
 * Student Full Name   : Rajkumar B L  
 * Student ID number   : 2047120
 * Domain - Car Rental System
 **********************************************************/
import java.util.Arrays;
import java.util.Scanner;
public class backup {
	
	static String comp_name;
	static String comp_addr;
	static String comp_phone;
	private String[][] share_holders = new String[20][2];
	private String[][] cust_info = new String[100][5];
	private int cust_info_pointer = 0;
	private String[][] car_info =  { 
			     {"Chev-Beat","Auto","Hatchback","2000","Available"},
				 {"Nissan-Macro","Manual","Hatchback","1500","Available"},
				 {"kia-Forte","Auto","Sedan","3000","Available"},
				 {"Toyoto-Corolla","Auto","Sedan","2500","Available"},
				 {"Nissan-Rogue","Auto","SUV","4000","Available"} 
			   };
       
	public backup() {}
	
	//Static block --> this gets executed before the main method
	// Intializes static variables
	static 
	{
		comp_name  = "Binod CarShare";
	    comp_addr  = "52 - Haynes Avenue, North York, Tiruppur, Tamilnadu, India - 641663";
		comp_phone = "0421 - 2047120";
		
	    System.out.println("***************************************");
	    System.out.println("*     ______                          *");
	    System.out.println("*    /|_||_\\`.__                      *");
	    System.out.println("*   (   _    _ _\\    BINOD CARSHARE   *");
	    System.out.println("*   =`-(_)--(_)-'                     *");
	    System.out.println("*                                     *");
	    System.out.println("***************************************");    
	 }
	
	//Static class need no reference object of outer class to call methods
	//Static class can have access to only static members of the outer class 
	static class welcome
	{
		private static void welcome_note()
		{
			 System.out.println("Welcome to "+comp_name+" ");
			 System.out.println("We the team of "+comp_name+" would like to invite you to be part of our family");
		}
	}
	
	public String[][] getShare_holders() {
		return share_holders;
	}

	public void setShare_holders(String[][] share_holders) {
		this.share_holders = share_holders;
	}
	
	private void verify_user_details()
	{
		
	}
	
	public void system_enrolling()
	{
		 Scanner in=new Scanner(System.in);
		 Character valid ='n';
		 String cust_mem[] = new String[5];
		 backup[] cr;
		 
		 do {	 
			 // Getting user details and storing them in an array --> cust_mem
			 System.out.println("Enter your name: ");
			 cust_mem[0]=in.nextLine();
			 System.out.println("Enter your Address: ");
			 cust_mem[1]=in.nextLine();
			 System.out.println("Enter your Occupation: ");
			 cust_mem[2]=in.nextLine();
			 System.out.println("Enter your Driver License: ");
			 cust_mem[3]=in.nextLine();
			 System.out.println("Enter your Contact information: ");
			 cust_mem[4]=in.nextLine();
			 System.out.println("\nThank you for entering the details.");
			 System.out.println("Name: "+cust_mem[0]
					            +"\nAddress: "+cust_mem[1]
					            +"\nOccupation: "+cust_mem[2]
					            +"\nDriver License: "+cust_mem[3]
					            +"\nContact: "+cust_mem[4]);
			 
			 verify_user_details();
			 // Getting a verification from the user to check
			 //If the above entered details are correct
			 System.out.println("Please verify if the above information is Correct.Y/n:");
			 valid = in.nextLine().charAt(0); 
			 valid = Character.toLowerCase(valid);	 
			 
			 //If the customer information is valid. It is then stored into the customer database
			 //in this case --> It is Cust_info[][] which is 2d array
			 if(valid.equals('y')){
				 System.out.println(this.member_add(cust_mem));
			 }
			 //If the user enters "n" --> meaning the information is incorrect
			 //The do part --> customer entry details is repeated, where the user enters the details again
			 else if(valid.equals('n')) {
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
					 System.out.println("Please re-enter the correct deatails: \n");
				 }
			 }
			 else{
				 
			 }
			 valid = Character.toLowerCase(valid);	
		 }
		 while (!(valid.equals('y')));
		 
	    }
	
	private String member_add(String [] mem_info)
	{
		
		this .cust_info[0][0]=mem_info[0];  //Name
		this .cust_info[this.cust_info_pointer][1]=mem_info[1];  //Address
		this .cust_info[this.cust_info_pointer][2]=mem_info[2];  //Occupation
		this .cust_info[this.cust_info_pointer][3]=mem_info[3];  //Driver License
		this .cust_info[this.cust_info_pointer][4]=mem_info[4];  //Contact
		this.cust_info_pointer=this.cust_info_pointer+1;  //Moving the 2d array pointer to next row
		
		return membership_msg(this .cust_info[this.cust_info_pointer-1][2]);
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
	
	
	
	
	
	private String member_add(String [][] mem_info)
	{
		int mem_info_pointer =0;
		String add_msg="";
		
		for(;this.cust_info_pointer<this.cust_info.length;this.cust_info_pointer++,mem_info_pointer++)
		{
			this .cust_info[this.cust_info_pointer][0] = mem_info[mem_info_pointer][0]; //Name
			this .cust_info[this.cust_info_pointer][1] = mem_info[mem_info_pointer][1]; //Address
			this .cust_info[this.cust_info_pointer][2] = mem_info[mem_info_pointer][2]; //Occupation
			this .cust_info[this.cust_info_pointer][3] = mem_info[mem_info_pointer][3]; //Driver License
			this .cust_info[this.cust_info_pointer][4] = mem_info[mem_info_pointer][4]; //Contact
		}
			
		if ( ((mem_info.length - mem_info_pointer) == 1) || (mem_info.length < (this.cust_info.length - (this.cust_info_pointer+1))) )
		{
			add_msg="All members have been added sucessfully.";
		}
		else if (mem_info.length > (mem_info_pointer+1))
		{
			add_msg="Sorry only partial data has been entered into the system./n";
			add_msg="We will work on the issue and report you as soon as possible./n";
		}
		else
		{
			add_msg="Sorry no data has been entered into the system./n";
			add_msg="We will work on the issue and report you as soon as possible./n";		
		}
		
		return add_msg;
	}
	
	public static void main(String[] args)
	{ 
	  backup.welcome stc_cls = new  backup.welcome();
	  stc_cls.welcome_note();
	  backup cr1 = new backup();
      cr1.system_enrolling();
    }
}