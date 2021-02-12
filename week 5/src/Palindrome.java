import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		String original,reverse = "";
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a word or phrase to check if it is a palindrome:");
		original =sc.nextLine();
		int length = original.length();
		for(int i=length-1;i>=0;i--) {
			reverse = reverse + original.charAt(i);
		}
		 if(original.replaceAll("\\s+","").equalsIgnoreCase(reverse.replaceAll("\\s+", ""))) {
	         System.out.println("The input word “"+ original+"” is a palindrome.");
		 }
	      else {
	         System.out.println("The input phrase “"+ original+"” is not a palindrome.");
	      }
	}
}
