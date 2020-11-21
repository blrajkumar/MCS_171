package Lab06;

public class BookCar extends BinodCarShare implements Runnable 
{
	
   int cust_id;
   String car_code;

   public BookCar()
   {
	   
   }
   
   public BookCar(int cust_id,String car_code)
   {
	   System.out.println("hello admin3"); 
	   this.cust_id = cust_id;
	   this.car_code = car_code;
   }
   
	@Override
	public void run() 
	{
		System.out.println("hello admin4"); 
		admin_book_car(this.cust_id,this.car_code);
	}
   
   private  void admin_book_car(int cust_id,String car_code)
	{System.out.println("hello admin5"); 
		if (!getList_avail_car().contains(car_code))
		{
			System.out.println("The entered car-code is incorrect (or) Not available.\nBetter luck next time!");
		}
		else if (getList_avail_car().contains(car_code))
		{
			
			System.out.println("The Car("+car_code+") is booked for "+cust_id+". Happy and safe jorney!");
			//add_book_info(cust_id,car_code);
			update_Car_list(car_code);
		}
		  
	  
	}
}
