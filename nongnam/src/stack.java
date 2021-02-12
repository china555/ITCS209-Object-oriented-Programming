import java.util.ArrayList;

public class stack 
{
	public int num;
	public int count;
	public ArrayList<Integer> Stack = new ArrayList<Integer>();
	
	public void addStack(int num)
	{
		Stack.add(num);
	}
	
	public void removeStack()
	{
		Stack.remove(Stack.size()-1);
	}
}

