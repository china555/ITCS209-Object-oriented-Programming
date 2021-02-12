
public class testst {
	public static void main(String[] args) {
		/*stack data = new stack();
		data.addStack(1);
		data.addStack(2);
		data.addStack(3);
		data.addStack(4);
		data.addStack(5);
		data.addStack(20);
		data.addStack(62);
		data.addStack(7);
		data.removeStack();
		data.removeStack();
		for(int i: data.Stack) {
			System.out.println(i);
		}*/
		queue info = new queue();
		info.addQueue(1);
		info.addQueue(2);
		info.addQueue(3);
		info.addQueue(4);
		info.addQueue(5);
		info.addQueue(6);
		info.addQueue(7);
		info.addQueue(8);
		info.addQueue(9);
		info.addQueue(10);
		info.removeQueue();
		for (int i: info.Queue)
		{
			System.out.println(i);
		}
	}
}