
public class foodtester 
{
	public static void main(String[] args)
	{
		food china = new food("Nam", "Sweet", 1); 
		System.out.println(china.amount_of_dish + china.getTaste() );
		china.setTaste("spicy");
		System.out.println(china.amount_of_dish + china.getTaste());
		china.amount_of_dish = 2;	
		System.out.println(china.amount_of_dish + china.getTaste());
	}

}
