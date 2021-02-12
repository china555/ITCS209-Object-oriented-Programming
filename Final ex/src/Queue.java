public class Queue{
	public int[] data;
	public static int count=0;
	public int max;
	public Queue(int max) {
		this.data = new int[max];
		this.max = max;
	}
	public void push(int num) {
		this.data[count] = num;
		count++;
	}
	public void pop() {
		this.data[0] = 0;
		for(int i=0;i<count-1;i++) {
			data[i] = data[i+1];
		}
		count--;
	}
	public void display() {
		for(int i =0;i<count;i++)
		System.out.println(data[i]);
	}
	
	
}