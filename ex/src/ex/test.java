package ex;

public class test {
		public static void main(String[] args) {
			privatee one = new privatee("Nam");
			System.out.println(one.getInformation("nam"));
			one.setInformation("luv Nam", "china");
			System.out.println(one.getInformation("china"));
		}

}
