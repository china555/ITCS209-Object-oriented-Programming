import java.util.ArrayList;

public class queue 
{
	public int num;
	public ArrayList<Integer> Queue = new ArrayList<Integer>();
	
	public void addQueue(int num)
	{
		Queue.add(num);
	}
	
	public void removeQueue()
	{
		Queue.remove(0);
	}
}
