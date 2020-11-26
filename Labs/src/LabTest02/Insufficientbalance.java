package LabTest02;

public class Insufficientbalance extends Exception
{
	public Insufficientbalance(String s)
    {
        // Call constructor of parent Exception
        super(s);
    }
}