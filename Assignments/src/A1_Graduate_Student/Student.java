package A1_Graduate_Student;
import java.util.Scanner;

public class Student extends Person {
	
    int    studentID;
    String         institutionName;
    String         phoneNumber;
    
    public Student() {
    }
    
    public void studIdGenr()
    {
    	//To Generate random int value from 2047100 to 2047300
    	//Syntax --> Math.random() * (max - min + 1) + min
    	this.studentID = (int)(Math.random() * (2047300 - 2047100 + 1) + 2047100);
    }
    
    public void read()
    {
    	super.read();// Calls the display function of super (Student) class
    	
    	studIdGenr();// Calls the "studIdGenr()" func that generates random student id
    	
    	Scanner studentInp = new Scanner(System.in);
    	System.out.println("Enter your Institution Name: ");
   	 	this.institutionName = studentInp.nextLine();
   	 
   	 	System.out.println("Enter your Phone Number: ");
   	 	this.phoneNumber = studentInp.nextLine();
    }
    
     public void display()
     {
        super.display();	 
   	    System.out.println("Student ID : "         + this.studentID
   			           + "\nInstitution Name : "   + this.institutionName
   			           + "\nPhone Number : "       + this.phoneNumber);

     }

}
