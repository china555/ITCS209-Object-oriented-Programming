package ex;

public class Pet {
	public String name;
	public int age;
	public String skill;
	public Pet(String name,int age,String skill) {
		this.name = name;
		this.age = age;
	}
}
 class dog extends Pet{
	public dog(String name, int age, String skill) {
		super(name, age, skill);
		this.skill = skill = "bark";
		// TODO Auto-generated constructor stub
	}
	
}
 class cat extends Pet{

	public cat(String name, int age, String skill) {
		super(name, age, skill);
		this.skill = skill = "scratch";
		// TODO Auto-generated constructor stub
	}
	 
 }
 class bird extends Pet{

	public bird(String name, int age, String skill) {
		super(name, age, skill);
		this.skill = skill = "Parody sound like human";
		// TODO Auto-generated constructor stub
	}
	 
 }
class rabbit extends Pet{

	public rabbit(String name, int age, String skill) {
		super(name, age, skill);
		this.skill = skill = "jump high";
		// TODO Auto-generated constructor stub
	}
	
}
class show{ 
	public static void main(String[] agrs) {
		dog a = new dog("pert", 10,null);
		System.out.println(a.skill );
		
	}
}
