import java.util.ArrayList;

public class test {
	public ArrayList<String> cars;
	public ArrayList<Integer> num;
	  public static void main(String[] args) {
		/*  String[] array = {"A","B","C","D","E","F"}; //array[6];
		  ArrayList<String> cars = new ArrayList<String>();
	    cars.add("Volvo");  //index 0
	    cars.add("BMW");	//index 1
 	    cars.add("Ford");	//index 2
	    cars.add("Mazda");	//index 3
	    cars.add("Toyota");
	    
	    cars.remove(4);
	    for(int i =0;i<cars.size();i++) {
	    	System.out.println(cars.get(i)+" ");
	    }*/
		  ArrayList<Integer> num = new ArrayList<Integer>(); 
		  num.add(30);
		  num.add(50);
		  num.add(980);
		  num.add(10);
		  num.add(1);
		 int sum = 0;
		  for(Integer a : num) {
			  sum = sum + a;
		  }
		  System.out.println(sum);
	  }
}
