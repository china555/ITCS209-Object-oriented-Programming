import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Sorting {
	public static List<String> words;
	public static void main(String[] args) {
		try {
			words = new ArrayList<String>();
			original(read("C:\\Users\\kitti\\Desktop\\unsorted.txt"));
			Bubble(words);
			System.out.println(parlindrome("??!??"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public	 static List<String> read(String file) throws IOException{
		BufferedReader read = new BufferedReader(new FileReader(file));
		String pattern = "(.+)";
		Pattern pat = Pattern.compile(pattern);
		String line = read.readLine();
		while(line != null) {
			Matcher match = pat.matcher(line);
			if(match.find()) {
				for(String i : match.group(1).split(" ")) {
					words.add(i);
				}
				line = read.readLine();
			}
		}
		return words;
	}
	public static void original(List<String> words) {
		System.out.print("[");
		
		for(int i=0;i<words.size();i++) {
			if(i != words.size()-1) {
			System.out.print(words.get(i)+",");
			}
			else {
				
				System.out.println(words.get(i)+"]");
			}
		}
	}
	public static void Bubble(List<String> words){
		for(int i=0;i<words.size();i++) {
			for(int j =i;j<words.size();j++) {
				if(words.get(i).compareTo(words.get(j))<0) {
					String temp = words.get(j);
					words.set(j, words.get(i));
					words.set(i, temp);
				}
			}
			System.out.println("Pass "+(i+1)+words);
		}
	}
	public static boolean parlindrome(String temp) {
		boolean check = false;
		//System.out.println(temp);
		temp = temp.toLowerCase();
		temp = temp.replaceAll(" ","");
		temp = temp.replaceAll("\" ","");
		temp = temp.replaceAll("\\?","");
		temp = temp.replaceAll("!","");
		temp = temp.replaceAll("\\'","");
		temp = temp.replaceAll("\\.","");
		temp = temp.replaceAll(",","");
		
		//System.out.println(temp);
		if(temp.length()>1) {
			if(temp.charAt(0)==temp.charAt(temp.length()-1)) {
				parlindrome(temp.substring(1,temp.length()));
				//System.out.println(temp);
				check = true;
			}
			else {
			
				check = false;
			}
		}
		return check;
	}
	
}
