
public class test_stack {
	public int[] data;
	public int count=0;
	public int max;
	public test_stack(int size) {
		// YOUR CODE GOES HERE
		
	}
	public void push(int num) {
		// YOUR CODE GOES HERE
		
	}
	public void pop() {
		// YOUR CODE GOES HERE
	
	}

	public void display() {
		System.out.print("Stack n["+count+"]: {");
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
