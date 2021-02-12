import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sort 
{
	public static ArrayList<String> x = new ArrayList<String>();
	
	public static void main(String[] args)
	{
		String file_name = "unsorted.txt";
		readText(file_name);
		printText(x);
		sortText(x);
	}
	
	public static List<String> readText(String file_name)
	{
		File file = new File(file_name);

		Scanner reader = null;
		try
		{
			reader = new Scanner(file);
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String word = null;		
		while(reader.hasNext())
		{
			word = reader.next();
			x.add(word);
		}
		return x;
	}
	
	public static void printText(ArrayList<String> x)
	{
		System.out.println(x);
	}
	
	public static void sortText(ArrayList<String> x)
	{
		String temp;
	    for (int j = 0; j < x.size(); j++)
	      {
	         for (int i = j + 1; i < x.size(); i++) 
	         {
	            // comparing strings
	            if (x.get(i).compareTo(x.get(j)) > 0) 
	            {
	               temp = x.get(i);
	               x.set(i, x.get(j));
	               x.set(j, temp);
	            }
	         }
	         System.out.println(x);
	      }
	}
}
