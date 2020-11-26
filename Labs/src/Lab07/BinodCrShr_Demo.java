package Lab07;

import Lab06.BinodCarShare;

import Lab06.BinodCarShare;
import Lab06.Member;

public class BinodCrShr_Demo 
{
	static 
	{
		String fits1 ="\t     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
				   //  +"\t     /                              \\\n"
				     +"\t    /                                \\\n"
	                 +"\t   /                                  \\\n"
				     +"\t  /                                    \\\n"
				     +"\t /                                      \\\n"
				     +"\t|                                        |\n"
				    // +"\t|                                        |\n"
				     +"\t|                                        |";
		
		
			
	    String raj ="\t|________________________________________|";
	           raj+="\n\t|                                        |";
		       raj+="\n\t| MCS 171  - Java Lab                    |";
	           raj+="\n\t| Name     : Rajkumar B L                |";
	           raj+="\n\t| Reg.No   : 2047120                     |";
	           raj+="\n\t| Concepts : Exception,Package,Thread    |";
	           raj+="\n\t|________________________________________|";  
	           
	           
	           
	    String fits2 ="\t\\                                        /\n"
	    		   + "\t \\                                      /\n"
	    		   + "\t  \\                                    /\n"
	    		   + "\t   \\                                  /\n"
	               + "\t    |                                |\n"
	               + "\t    |                                |";
	    
	    String crshr ="\t    **********************************\n"
	                 +"\t    *    ______                      *\n"
	                 +"\t    *   /|_||_\\`.__                  *\n"
	                 +"\t    *  (   _    _ _\\ BINOD CARSHARE  *\n"
	                 +"\t    *  =`-(_)--(_)-'                 *\n"
	                 +"\t    *                                *\n"
	                 +"\t    **********************************";  
	    
	    System.out.println(fits1);	
	    System.out.println(raj);
	    System.out.println(fits2);
	    System.out.println(crshr);
	    welcome.welcome_note();
	}
	
	static class welcome
	{
		private static void welcome_note()
		{
			 System.out.println("\nWelcome to Binod Carshare homepage");
		}
	}

	public static void main(String[] args)
	{
		int mem_count=0;
	
		if(args.length==1)
		  {
			  mem_count = Integer.parseInt(args[0]);
			  if (mem_count>= 1)
			  {
				  Member[] cr = new Member[Integer.parseInt(args[0])];
				  for (int x=0; x < Integer.parseInt(args[0]); x++)
				  {
					  
					  System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					  System.out.println("|           Rider   -->  "+ (x+1) +"       |");
					  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					  cr[x] = new Member("all");
				  }	
			  }
		  }
		else
		{
			BinodCarShare.end_note();
		}
	}
}
