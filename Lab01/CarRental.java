
/* *********************************************************
 * MCS 172 - Java
 * Lab 01
 * Student Full Name   : Rajkumar B L  
 * Student ID number   : 2047120
 **********************************************************/
import java.util.Arrays;
import java.util.Scanner;
public class CarRental {
	
	static String comp_name  = "Binod CarShare";
	static String comp_addr  = "52 - Haynes Avenue, North York, Tiruppur, Tamilnadu, India - 641663";
	static String comp_phone = "0421 - 2047120";
	private String[][] share_holders = new String[20][2];
	protected String[][] cust_info = new String[100][5];
	protected int cust_info_pointer = 0;
	public String[][] car_info =  { 
			     {"Chev-Beat","Auto","Hatchback","2000","Available"},
				 {"Nissan-Macro","Manual","Hatchback","1500","Available"},
				 {"kia-Forte","Auto","Sedan","3000","Available"},
				 {"Toyoto-Corolla","Auto","Sedan","2500","Available"},
				 {"Nissan-Rogue","Auto","SUV","4000","Available"} 
			   };
	
       
	public CarRental() {}
    
	public String membership_msg(String ocup)
	{
	  String outp_msg="";
	  if (ocup.equalsIgnoreCase("student"))	
	  {
		  outp_msg = "Thank you for choosing "+comp_name+"!\n"
		  	     +"You made the right choice. We are haooy to have you onboard\n"
		             +"To celebrate your choice, we are happy to offer you with one year free membership\n"
		             +"Stay tuned for further updates";
	  }
	  else
	  {
		  outp_msg = "Thank you for choosing "+comp_name+"!\n"
		  	     +"The complete membership portfolio for "+ocup+"s is yet to be designed"
		   	     +"Sorry for the inconvinience caused. Stay tuned for further updates";
	  }
	  
	  return outp_msg;
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
	
	private String member_add_all(String [][] mem_info)
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
	 System.out.println("Welcome to "+comp_name+" ");
	 System.out.println("We the team of "+comp_name+" would like to invite you to be part of our family");
	 Scanner in=new Scanner(System.in);
	 CarRental cr1 = new CarRental();
	 
	 Character valid ='n';
	 String cust_mem[] = new String[5];
	 do {
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
		 
		 System.out.println("Please verify if the above information is Correct.Y/n:");
		 valid = in.next().charAt(0); 
		 valid = Character.toLowerCase(valid);	 
		 
		 if(valid.equals('y')){
			 System.out.println(cr1.member_add(cust_mem));
		 }
		 else if(valid.equals('n')) {
			 System.out.println("Please re-enter the correct deatails: \n");
			 }
		 else if(!(valid.equals('n')) && !(valid.equals('y'))){
			 System.out.println("Invalid option. Please choose among the following options.Y/n:");
			 valid=in.next().charAt(0); 
		 }
		 else{
			 
		 }
		 valid = Character.toLowerCase(valid);	
	 }
	 while (!(valid.equals('y')));
	 
    }

}
