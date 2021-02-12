import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//สู้ๆนะน้ำ<3
//ขอบคุนน่ค่  ที่รัก -3-
//คลาส interface คือ คลาสที่มีแต่ชื่อ method เท่านั้น เป็นคลาสที่เป็นแม่แบบเฉยๆ 
//จะไม่มี body และ มี body ไม่ได้ จะมีแต่แม่แบบเฉยๆ  เลยอย่างเช่น 
public interface test {
	public int add(int a);
	public String name(String name,int num);
	public double sum(double money);
}//อันนี้เขาเรียกคลาส interface ส่วนถ้าเราอยากเอาแม่แบบอันนี้ไปใช้เราต้อง เขียนว่า
// implements เช่น
public class final_summary implements test{
	//มันจะขึ้นแดงตรงชื่อ class และบอกว่า ให้ add unimplemented method
	//แต่ถ้าไม่ขึ้นแสดงว่าแอดมาแล้ว
	@Override
	public int add(int a) {
		return 0;
	}
	//เห็นไหมว่าจะมี method ที่มีชื่อเดียวกันมาทั้งหมดเลยจาก interface ของเรา
	//และเหมือนกันเป้ะๆ แต่ในนี้สามารถมี body ได้แล้ว
	//อะไรที่ interface มี  มันจะต้องมีเหมือนclass interface เป้ะๆแค่นั้นเอง
	//แต่เราสามารถเพิ่ม method อื่นๆได้อย่างเช่น
	public String info(String info) {
		return info;
	}//เห็นไหมว่าได้เหมือนกัน 
	
	//method ไหนที่มาจาก class interface ไม่ควรไปเปลี่ยนแปลงชื่อหรือ
	//parameter ต่างๆไม่งั้นมันจะขึ้นแดงตรงclass นี้ ละเตือนเราว่ามันไม่มี method นี้นะ 
	//และมันจะให้ทำการ add method นั้นเข้ามา
	@Override
	public String name(String name, int num) {
		return null;
	}
	@Override
	public double sum(double money) {
		return 0;
	}
}
//เป็นคลาสที่สามารถสร้าง abstract method ได้
public abstract class  test_abstact{// เป็นคลาสที่ เป็นแค่นามธรรมเฉยๆ มีแค่ชื่อคลาส
	//ไม่สามารถสร้าง object ได้ 
	//เป็นคลาสที่สามารถมี body ได้ปกติเหมือนคลาสทั่วๆไป เหมือน week10 เข้าใจง่ายดี
	public abstract int mem(int a);//เป็น method ที่สร้างมาเพื่อให้คลาสอื่นที่ extend ต้องมีเหมือนเป้ะ
}
class Set1_Map{
	public static void main(String[] args) {
		Set<String> word = new HashSet<String>(); // ต้อง = new HashSet<String>();
		//ต้อง import import java.util.HashSet; กับ  import java.util.Set;
		// = new HashSet<String>(); เพราะเป็นการ initial ค่าของ ตัวแปร set
		//word คือตัวแปรของ set ที่สามารถเก็บข้อมูลได้แค่ Stringจะเก็บ datatype อะไรขึ้นอยู่กับข้างใน <>
		//ซึ่งถ้า จาก ex เก็บ String จะใส่พวก int ไม่ได้หรือ datatype ที่เป็น object แล้วเพราะว่าเรากำหนด
		//ไปแล้วว่าให้เก็บ datatype String
		//set จะไม่เก็บตัวซ้ำละไม่มี index
		//for each ของ ตัวแปรเซ็ตใช้แบบนี้
		//for(datatype ที่เก็บใน <>ในนี้คือString และตามด้วย variableที่เราจะตั้งอะไรก็ได้ และ : และสุดท้ายใส่ตัวแปร ที่เราจะรันค่า
		//ในที่นี้เรา ใช้ ตัวแปร set ที่มีชื่อว่า word พวก ArrayList Set map คือใช้ได้หมด หรือ array ปกติก็ได้
		//for(String i : word)
		//{
		//	System.out.println(i); //มันก็จะปริ้นข้อมูลทั้งหมดที่อยู่ในนี้ได้เลย
		// ใน แลปมีลองดูนะ สู้ๆๆๆๆ
		//}
		Map<Integer,String> nongnam = new HashMap<Integer,String>();
		//import java.util.HashMap;มาเพื่อใช้  Hashmap กับ import java.util.Map; เพื่อใช้ Map
		// = new HashMap<Integer,String>(); เพราะเป็นการ initial ค่าของ ตัวแปร Map
		//nongnam คือตัวแปร Map ที่ประกอบไปด้วย key index  และ value ในตัวอย่าง เราเก็บkey index เป็น integer
		//และ value เป็น String ซึ่ง เก็บเป็น object ก็ได้แค่เปลี่ยนตัวหลังเช่นน  Map<String,Car> nongnam1 เป็นต้น
		//ไม่มี key index เพราะงั้นใช้ for ธรรมดา ไม่ได้ต้องใช้ for each เพราะมันไม่รู้ค่าที่แน่นอนของ index แต่ละ index
		//เลยต้องใช้ keyindex ในการรัน loop 
		//for(int run : nongnam.keyset())
		//{
			//System.out.println(nongnam.get(run)); มันจะปริ้นค่าของ แต่ละช่องมาแต่ถ้า
		    //System.out.println(run); มันจะปริ้น keyindex ออกมา
		//}
		//recursion คือ คล้ายๆ loop แต่ว่าเป็นการ call method จนถึง  base case ของมันเหมือน week 12 ลองดู
		//base case จะอยู่บนเสมอ
		//sorting ก็ดู week 13
/*
	try 
	{
	File file = new File("ใส่ directory ของไฟล์ที่จะอ่านลงไป ");f //บอกว่าชื่อไฟล์เฉยๆ
	FileReader prepareread = new FileReader(ใส่ชื่อไฟล์ลงไปในนี้คือไฟล์ของข้างบน file);//เหมือนบอกว่าจะอ่านไฟล์นี้เฉยๆ
	BufferedReader read = new BufferedReader(ใช่ชื่อ filereader ในนี้คือ  prepareread); อ่านไฟล์นี้เรียบร้อยพอเขียนอันนี้
		BufferedReader read = new BufferedReader(new FileReader(movieFilename));   
		String pattern =  "([\\d]+),(.+)\\s\\(([\\d]+)\\)\\\"?,(.+)"; //pattern ของ regular expression  
			Pattern pat = Pattern.compile(pattern); การบอกว่าเราจะเอา regular ข้างบนมาใช้กับโปรแกรม
			String line = read.readLine();   // กำหนดการอ่านบรรทัดแรกเฉยๆ เพราะเขาบอกไม่เอาบรรทัดแรกเลยต้องอ่านก่อน
			while(line != null) { // ถ้า == null ปุบ ออก ลูป
			{
				line = read.readLine();  //อ่านไฟล์ทีละบรรทัด
				if(line!= null) // เช็คอีกทีว่ามันว่างไหม ถ้ามันว่างก็ชวนไปกินข้าว
				{
					Matcher match = pat.matcher(line);//เป็นการmacth กับ patternที่เรา compile แล้วกับแต่ละบรรทัด
					if(match.find()) ถ้าข้างบนมัน match มันจะเข้า if
					{
					regex = regular expression
					เวลาอ่านไฟล์มันอ่านเป็น String แต่สามารถเปลี่ยนเป็นแต่ละ data type ได้เช่น 
					//เป็น int Integer.parseInt()
					 * double = Double.parseDouble() เป็นต้น
						int mid = Integer.parseInt(match.group(1));  //regex กลุ่มแรกเราเป็น mid
						String title = match.group(2);    //กลุ่ม 2 ก็ชื่อหนัง ไม่ต้องเปลี่ยน type เพราะเป็นสติงอยู่ละ
						int year = Integer.parseInt(match.group(3));    //set year for group 3 of data
						String tags = match.group(4);     //set tags for group 4 of data
						Movie movie = new Movie(mid, title, year);
						for(String tag : tags.split("\\|"))       //เป็นการแยก tag แยกโดย |
						{
							movie.addTag(tag);   //add tag into each movie 
						}
						movies.put(mid,movie);   //put into movies
					}
				}
			}
		} 
		catch (FileNotFoundException e)  
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movies;
	}
	}
}*/
