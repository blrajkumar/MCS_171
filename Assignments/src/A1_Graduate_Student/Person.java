package A1_Graduate_Student;
import java.util.Scanner;

public class Person {
 String name;
 int    age;
 int    height;
 
 public void read()
 {
	 Scanner personInp = new Scanner(System.in);
	 
	 System.out.println("Enter your name: ");
	 this.name = personInp.nextLine();
	 
	 System.out.println("Enter your age: ");
	 this.age = Integer.parseInt(personInp.nextLine());
	
	 System.out.println("Enter your Height: ");
	 this.height = Integer.parseInt(personInp.nextLine());
 }
 
  public void display()
  {
	 System.out.println("Name : "     + this.name 
			 		+ "\nAge : "      + this.age
			        + "\nHeight : "   + this.height);
  }
  
}
