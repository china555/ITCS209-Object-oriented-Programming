import java.util.Scanner;

public class perfectnum 
{
	public static int a;
	
	public static void main(String[] args)
	{
		Scanner num = new Scanner(System.in);
		
		System.out.print("Enter number : ");
		a = num.nextInt();
		//System.out.println(a);
		
		int sum = 0 ;
		
		for(int i = 1 ; i <= a-i ; i++ )
		{
			if(a%i == 0 && i != a)
			{
				System.out.print(i);
				sum = sum + i ;
			}	
			if(i<= a-1 && i*2 != a)
			{
				System.out.print(" + ");
			}
		}
		System.out.println(" = "+sum);
		
		if(sum == a)
		{
			System.out.println(a + " is Perfect Number");
		}
		else 
		{
			System.out.println(a + " is NOT Perfect Number");
		}
	}
}
