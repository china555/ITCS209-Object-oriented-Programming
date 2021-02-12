
public class Grade {
	public int score;
	public char[] a= {'A','B'};
	public static int max;
	public static int min;
	Grade(int score){
		this.score = score;
	}
	public void calculate () {
		if() {
			
		}
	}
	public void avg() {
		int i=0,max1 = this.score;;
		for(i=0;i<=10;i++) {
					max1++;
					System.out.println(max1);
			while(max1%10==0) {
				max = max1;
			}
		}
		System.out.println("You"+max);
	}
	public static void main(String[] args) {
		Grade one = new Grade(44);
		one.avg();
	}
}
