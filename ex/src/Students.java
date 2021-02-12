
public class Students extends Worker  {
	public int ID;
	public Students(String name, String sur, String work,int id) {
		super(name, sur, work);
		this.name = name;
		this.sur = sur;
		this.work = work;
		this.ID = id;
		// TODO Auto-generated constructor stub
	}
	public int john(int a) {
		return a;
	}
	public String toString() {
		return this.ID+" "+super.toString();
	}
	public static void main(String[] args) {
		Students one = new Students("Phakin", "O", "Student", 6188000);
		System.out.println(one.toString());
	}
}
