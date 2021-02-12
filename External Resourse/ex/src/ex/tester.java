package ex;

public class tester {
	public static void main(String[] args) {
		teacher china = new teacher("Kittikorn", "Keerati", "6188086",15000);
		System.out.println(china.firstname+" "+china.lastname+" "+china.getGender("m")+" "+china.getSalary());
	}

}
