import java.util.ArrayList;
import java.util.Scanner;

public class GraduateStudent extends Student {
	
	 String  prgName;
	 int     noOfSubjects;
	 String  classTeacherName;
	 
	 public GraduateStudent() {
	    }
	 
	 public void read()
	 {
	    	super.read(); // Calls the display function of super (Student) class
	    	Scanner grdStudentInp = new Scanner(System.in);
	    	
	    	System.out.println("Enter your Program Name: ");
	   	 	this.prgName = grdStudentInp.nextLine();
	   	 
	    	System.out.println("Enter the number of subjects enrolled: ");
	    	this.noOfSubjects = Integer.parseInt(grdStudentInp.nextLine());
	   	 
	   	 	System.out.println("Enter the name of your class teacher: ");
	   	 	this.classTeacherName = grdStudentInp.nextLine();
	   	 	
	   	 
	  }
	    
	  public void display()
	  {  
		 super.display();
	   	 System.out.println("Program Name : "    + this.prgName
	   			         +"\nNo. of Subjects : " + this.noOfSubjects
	   			         +"\nClass Teacher : "   + this.classTeacherName);
	   	 
	   	  System.out.println("----------------------***-------------------\n");
	     }

	public static void main(String[] args) {
		
		int noOfStd;
		Scanner stdInp = new Scanner(System.in);
		System.out.println("Enter the number of students to add to the list: ");
		noOfStd =  Integer.parseInt(stdInp.nextLine()); //Stores the Number of student to be added to the list
		
		ArrayList<GraduateStudent> grdStdList = new ArrayList<GraduateStudent>(); //Arraylist--> List of grad student objects
		ArrayList<Integer> ids = new ArrayList<Integer>();//Arraylist--> Stores the list of unique student id's of all students objects till now
		
		for(int k=0; k < noOfStd; k++)
		{
			grdStdList.add(new GraduateStudent());
			grdStdList.get(k).read();
			
			int currentID = grdStdList.get(k).studentID; //Stores the current student id generated randomly from STUDENT class
			if(!ids.contains(currentID)) //Checks if the "ids" arraylist does'nt have the currently generated student id
			 {
				ids.add(currentID); //Adds the currentID to the "ids" arraylist if not already contained
			 }  
			else //If the "ids" arraylist already contained the "CurrentID" then the following else part is executed
			{
				while(ids.contains(currentID))// To repeat the process until a unique id is generated
				{
					grdStdList.get(k).studIdGenr();//Calls the "studIdGenr()" method to generate a new random id to override the existing one
					currentID = grdStdList.get(k).studentID;//Stores the current newly created student id generated randomly from STUDENT class
					if(!ids.contains(currentID)){ids.add(currentID);break;}//Adds the newly created unique randomised student id to the "IDS" arraylist
				}
			}
			
			grdStdList.get(k).display();// Calls the display function
		}
		
		System.out.println("||| Student information has been successfully updated to the list  ||| ");
		stdInp.close();
	}

}
