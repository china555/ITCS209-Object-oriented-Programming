
public class test_queue {
	public int[] data;
	public int count;
	public int max;
	public test_queue(int max) {
		// YOUR CODE GOES HERE

	}
	public void in(int num) {
		// YOUR CODE GOES HERE

	}
	public void out() {
		// YOUR CODE GOES HERE

	}
	public void display() {
		System.out.print("Queue n["+count+"]: {");
		for(int i =0;i<count;i++) {
			if(i==count-1) {
				System.out.println(data[i]+"}\n");
			}
			else {
				System.out.print(data[i]+",");
			}
		}
	}
}
