import java.util.ArrayList;
import java.util.Scanner;

//สมมุติเป็น class เปรียบเสมือน บลูปริ้น   เพราะงั้นลองมามองว่าเป็นบลูปริ้นรถ
public class blueprint_car 
{ 
	// attributes เปรียบเสมือน องค์ประกอบต่างๆของบลูปริ้น
	// ***********************************method คือ function ในภาษา C**************************************
	//methodก็คือพวก ชื่อและตามด้วย()ทั้งหลาย จะมี parameter หรือไม่มีก็แล้วแต่ก็เรียกว่า method
	//การสร้าง attributes ก็ต้องมี public or private 
	
	//ถ้าเป็น private จะสามารถใช้ได้แค่คลาสตัวเองเท่านั้น ถ้าอยากให้คลาสอื่นใช้ต้องสร้าง setกับ get ขึ้นมา
	
	//ex:  public ตามด้วย ชื่อ datatype(int,float,double,หรือชื่อคลาส) และตามด้วยชื่อตัวแปรที่เราต้องการ 
	
	// กด alt+shift+s เพื่อสร้าง get set แบบรวดเร็วและที่เราต้องการ ไม่ต้องไปนั่งกดทีละตัว และสร้างคอนตักได้เซม
	public int tire;
	public int door;
	public String name;
	public double Distance;
	private int engine;
	//constructors จะมีชื่อเดียวกับคลาสเป้ะๆเลย จะมีคอนตักกี่ตัวก็ได้ไม่จำเป็นต้องมีตัวเดียว // คอนตักคือการเตรียมพร้อมในการสร้าง new object ของคลาสนั้นๆ
	// สมมุติเราจะสร้างตึกๆนึงนะ เราส่งบลูปริ้นเปล่าๆไปให้วิศวะคิดว่ามันจะรู้ไหมว่าจะต้องสร้างตึกยังไง นั้นแหละ มันเลยต้องมีคอนตัก
	public blueprint_car(int tire, int door, String name, double distance, int engine)
	{
		//แต่ถ้าใช้ alt+shift+s มันจะมี super(); ขึ้นมาให้ลบทิ้งไป เพราะมันยังไม่ใช้ inheritance ลบๆไป5555 
		//เอาไว้ set ค่าของ attributes = ตัวที่ถูกส่งมาจาก object โดยการพาส parameter 
		// ex: blueprint_car honda = new blueprint_car(4, 8,"Civic",1000,5000); 
		//int tire ที่เป็นพารามิเตอร์ รับ 4 ไว้ , int door ที่เป็นพารามิเตอร์ รับ 8 ไว้ , String name ที่เป็นพารามิเตอร์ รับ "Civic" ไว้ 
		//double distance ที่เป็นพารามิเตอร์ รับ 1000 ไว้  ,   int engine ที่เป็นพารามิเตอร์ รับ 5000 ไว้
		//this. มันจะเป็นการชี้ไปยัง attribute โดยตรง จะใช้ก็ได้ไม่ใช้ก็ได้แล้วแต่ แต่ถ้าชื่อ attribute มันเหมือนกับชื่อ parameter มันจะทำให้โปรแกรม
		tire = tire;//มองว่าเป็นการจับตัว parameter = ตัว พารามิเตอร์  ลองมองจากสีเห็นไหมจะเป็นสีน้ำเงินที่บงบอกถึง parameter
		this.tire = tire; // คือการเซ็ต tire ของ คลาสนี้ เท่ากับตัวพารามิเตอร์ที่พาสมา ก็คือ 4
		this.door = door; // คือการเซ็ต door ของ คลาสนี้ เท่ากับตัวพารามิเตอร์ที่พาสมา ก็คือ 8
		this.name = name; // คือการเซ็ต name ของ คลาสนี้ เท่ากับตัวพารามิเตอร์ที่พาสมา ก็คือ "Civic"
		Distance = distance; // คือการเซ็ต distance ของ คลาสนี้ เท่ากับตัวพารามิเตอร์ที่พาสมา ก็คือ 1000//เห็นไหมว่าชื่อต่างก็ไม่ต้องมี this. ก็ได้
		this.engine = engine; // คือการเซ็ต engine ของ คลาสนี้ เท่ากับตัวพารามิเตอร์ที่พาสมา ก็คือ 5000
		
	}
	//เห็นไหมต้องมี get set เพราะ attribute engine มันเป็น private	
	public int getEngine() 
	{
		return engine;
	}
	public void setEngine(int engine) 
	{
		this.engine = engine;
	}
}
// คลาสอีกคลาสนึงซึ่งเอามาใช้ทดลอง
class car_tester
{
	public static void main(String[] agrs) 
	{
		//การ สร้าง object//
		//ชื่อคลาสที่จะสร้าง     ตามด้วยชื่อตัวแปร     = new constructor ของคลาสนั้น //** กด ctrl+space ให้เป็นประโยชน์
	/*ex object No.1*/ blueprint_car honda = new blueprint_car(4, 8, "Civic", 1000, 5000);
	/*ex object No.2*/ blueprint_car Toyota = new blueprint_car(3, 120, "Fortuner", 20, 9000);
	//ตัวแปรที่เป็น honda กับ toyota สามารถ เรียกใช้อะไรก็แล้วแต่ในคลาส blueprint_car ได้เพราะเหมือนได้รับความสามารถทั้งหมดมาแล้ว
	//สามารถ call method ได้ เรียก attributeได้  แต่ 2 ตัวนี้ค่าจะไม่เหมือนกันนะ มันคือคนละ object กันเลยค่าของมันจะเป็นค่าที่เราส่งไปทั้งนั้น
	//สมมุติอยากเปลี่ยน engine ของ honda จากเดิม 5000 ใช่ปะ เราก็ call method โดยใช้ honda.setEngine(2000); แค่นี้ค่าก็เปลี่ยน
	//จาก 1000 เป็น 2000 แล้ว หรืออีกวิธีพวก attribute ที่เป็น public สามารถ เปลี่ยนได้ตรงๆเลย เช่น honda.tire = 5;
		honda.setEngine(2000);
		honda.tire = 5; //แค่นี้ก็จะถูกเปลี่ยนแล้ว จาก 4 ล้อ เป็น 5 ล้อ
		System.out.println(honda.getEngine());//ต้องใช้ getEngine() เพราะว่า attribute เป็น private ถูกไหม
		//จะใช้ object ไหนก็ดูดีๆนะครับ
		
		//=======================ต้อง import มาใช้ด้วย :เหมือนบรรทัด 1=====================================
		//ชื่อคลาส Arraylist < data typeหรือ ชื่อคลาสก็ได้ > ตามด้วยตัวแปรที่เอามาเก็บ = new ArrayList< data type<หรือ ชื่อคลาสก็ได้ >();
		//data type : int,float,double,String,bit,byte,หรือชื่อคลาส
		ArrayList<blueprint_car> car = new ArrayList<blueprint_car>();
		//new ArrayList<blueprint_car>() ตรงส่วนนี้สำคัญเพราะว่าถ้าไม่มี มันจะขึ้นว่า exception in main อะไรนี่แหละ
		//มันคือการ initial ของ Arraylist
		car.add(Toyota); //คือการที่เราบอกว่า arraylist ตัวนี้เก็บคลาสนี้ แสดงว่าเก็บได้แค่ที่เป็น  blueprint_car นำหน้า
		//โดยการแอด Toyota เข้าไปนั้นมันจะแอดไปที่ index 0 ในอาเรลิส
		car.add(honda); //โดยการแอด honda เข้าไปนั้นมันจะแอดไปที่ index 1 ในอาเรลิส
		car.remove(honda);//เป็นการลบ ชื่อที่เป็น honda ออกและช่องอาเรลิสถูกลดลง เราสามรถ remove index ก็ได้ ex: car.remove(1);
		car.get(0).door = 5; //เเก้ข้อมูล ในindexนั้นๆ 
		//Arraylist สามารถใช้ for each ได้หลักการ คือ
				//for(เป็น data type ที่Arraylistเก็บเช่นข้างบนก็คือ blueprint_car แล้วตามด้วย ตัวแปรแะไรก็ได้มารันลูป : เป็นชื่อ Arraylist)
			for(blueprint_car i : car ) {
				System.out.println(i.Distance);// i ในที่นี้จะมีความสามารถของ คลาสblueprint_car ทั้งหมด สามารถ .(dot) 
				//ค่าอะไรก็ได้ของคลาสนี้ เช่น i.tire,i.engine บลาๆๆๆๆๆๆ และ 
				//ใน forนี้จะปริ้น distance ของ object ที่ยังอยู่ใน Arraylist ทั้งหมด
			}
		//Scanner : ก็คือ scanf ในภาษาซีแหละ แต่ว่าเรื่องมากกว่าหน่อยเพราะต้องสร้าง object ขึ้นมาก่อนเพื่อสามารถใช้ความสามารถของคลาสscanner ได้
		//เช่น Scanner sc = new Scanner(System.in);
		//ตอนนี้ sc เป็น object ที่สามารถใช้ความสามารถของ คลาส scanner ได้
		Scanner sc = new Scanner(System.in);
		int wheel;
		wheel = sc.nextInt(); // เป็นการรับค่าเข้าตัวแปร wheelหรือคล้ายๆ scanf
		int doors = sc.nextInt();//เป็นการรับค่าเข้าตัวแปร doors หรือคล้ายๆ สมมุติใส่ 45
		String name = sc.next();//เป็นการรับค่าเข้าตัวแปร name หรือคล้ายๆ สมมุติใส่ Serie1
		int distance = sc.nextInt();//เป็นการรับค่าเข้าตัวแปร distance หรือคล้ายๆ สมมุติใส่ 6000
		int engine = sc.nextInt();//เป็นการรับค่าเข้าตัวแปร engine หรือคล้ายๆ  สมมุติใส่ 4000
		//เอาตัวที่รับค่าของข้างบนทั้งหมดมาสร้างเป็น object ใหม่ได้  เช่น
		blueprint_car Ferrari = new blueprint_car(wheel, doors, name, distance, engine);
		//wheel ตรงนี้จะเท่ากับ 45 ของข้างบนที่ใส่มา doors,name,distance,engine ด้วยจะมีค่าเท่ากับข้างบนหมด
		//@Override //ชื่อ method เเละ parameter เหมือนกัน มีการเขียนทับ
		//@overload //ชื่อ method เหมือน  'เเต่' parameter แตกต่างกัน
		//Inheritance เป็นการสืบทอดจาก parent class ไปสู่ child child class
		
		//if(ชื่อ array instanceof คลาสหรืออะไรก็แล้วแต่ที่เราหา ) 
		{
			//คือการเช็ค arrayในทุกช่อง  หาว่ามีสิ่งที่เราหาไหมถ้าเจอก็จะเข้ามาใน if และทำไรต่อที่เรากำหนดไว้
		}
		/////////////////////////////////////////////////////////////////////////////////////////
		//array ธรรมดา
		//int[] x ต้องมีการ initial ค่าไว้ด้วย ไม่งั้นมันจะขึ้นว่า exception in main
		//เลยต้องมี initial แบบนี้ด้วย int[] x = new int[n];
		int[] x = {1,2,3,4,5,6};
		int[] y = x;
		if(x.equals(y)) {
			
		}
		
	}
}
