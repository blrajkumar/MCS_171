package LabTest01;
import java.util.Scanner;

public class Person {
 String name;
 int    age;
 String address;
 
 //default constructor
 public Person()
 {
	 
 }
 //Parameterised constructor
 public Person(String name, int age, String address)
 {
	 this.name=name;
	 this.age=age;
	 this.address=address;
 }
 
//copy constructor
 public Person(Person P)
 {
	 this.name=P.name;
	 this.age=P.age;
	 this.address=P.address;
 }
 
 public void read()
 {
	 Scanner personInp = new Scanner(System.in);
	 
	 System.out.println("Enter your name: ");
	 this.name = personInp.nextLine();
	 
	 System.out.println("Enter your age: ");
	 this.age = Integer.parseInt(personInp.nextLine());
	
	 System.out.println("Enter your Address: ");
	 this.address = personInp.nextLine();
 }
 
  public void show()
  {
	 System.out.println("Name : "     + this.name 
			 + "\nAge : "      + this.age
			 + "\nAddress : "   + this.address);
  }
  
}
