import java.util.Scanner;

public class Palindrome2 {
	public static String palindrome(String a,String b) {
		int j = a.length();
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)==b.charAt(j-1)) {
				return "palindrome";
			}
			j--;
		}
		return "not";
	}
	public static void main(String[] args) {
		String original,reverse = "";
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a word or phrase to check if it is a palindrome2:");
		original =sc.nextLine();
		reverse = original;
		System.out.println(palindrome(original,reverse));
		 
	}
}
