import java.util.ArrayList;

public class sum 
{
	public ArrayList<Integer> china;
	public static int sum;
	
	public static void main(String[] args)
	{ 
		ArrayList<Integer> china = new ArrayList<Integer>();
		china.add(200);
		china.add(20);
		china.add(50);
		china.add(7);
		china.add(500);
		
		china.remove(2); //remove some index so its rearrange
		china.remove(3);
		
		sum = 0;
		for(Integer i : china)
		{
			sum = sum + i;
		}
		System.out.println(sum);
	}
}
