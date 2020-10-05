package Multple_inheritance;

interface A
{
	default void show() 
	{
		System.out.println("This is Interface A");
	}
}

interface B
{
	default void show()
	{
		System.out.println("This is Interface B");
	}
}

public class Multi_inherit implements A,B
{
	public void show() 
	{
		A.super.show();
		B.super.show();
  	}
	
	public static void main(String args[])
	{
		Multi_inherit obj = new Multi_inherit();
		obj.show();
	}
    
}
