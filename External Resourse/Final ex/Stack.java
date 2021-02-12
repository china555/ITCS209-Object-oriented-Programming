
public class Stack {
	public int[] data;
	public static int count=0;
	public int max;
	public Stack(int x) {
		// TODO Auto-generated constructor stub
		this.data = new int[x];
		this.max = x;
	}
	public void push(int x) {
		if(this.max>count) {
		this.data[count] = x;
		count++;
		}
		else {
			System.out.println("idiot");
			return;
		}
		
	}
	public void pop() {
		data[count-1] = 0;
		count--;
	}
	public void peek() {
		System.out.println(data[count-1]);
	}
	public void display() {
		for(int i=0;i<count;i++) {
			System.out.print(data[i]+" ");
		}
	}
}
