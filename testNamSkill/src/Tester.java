
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person china = new Person("China", 19);
		china.setBalance(500);
		System.out.println(china.getInterest(0.3));
		Student arm = new Student("Arm", 18, "6188128");
		arm.setBalance(75000);
		System.out.println(arm.getInterest(0.25, 5));
	}

}
