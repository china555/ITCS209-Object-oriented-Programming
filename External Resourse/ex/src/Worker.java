//Parent class
public class Worker {
	public String name;
	public String sur;
	public String work;
	public int a;
	public Worker(String name, String sur, String work) {
		this.name = name;
		this.sur = sur;
		this.work = work;
	}
	@Override
	public String toString() {
		return "Name : "+this.name+"  Surname : "+this.sur+"\n"+work;
	}
	public int john(int a) {
		return a= 50;	
		}
}
