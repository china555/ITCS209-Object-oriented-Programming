import java.util.ArrayList;

public class cararraylist extends car
{
	public cararraylist(String version, int wheel, int engine, int distance) 
	{
		super(version, wheel, engine, distance);
		// TODO Auto-generated constructor stub
	}
	public ArrayList <car> nam; //[car]class name - [nam]arraylist name 
	public static void main(String[] args)
	{
		ArrayList<car> nam = new ArrayList<car>();
		car china = new car("panda", 10, 1000, 100000); //index[0]
		car nammy = new car("piggy", 90, 9000, 900000); //index[1]
		car child = new car("elephant", 2, 7000, 1000); //index[2]
		car mark = new car("amway", 3, 3000, 300000); //index[3]
		nam.add(china);
		nam.add(child);
		nam.add(nammy);
		nam.add(mark);
		nam.remove(child); //remove index 2 name child rearrange index still have china[0] nam[1] mark[2]  
		nam.remove(2); //remove index 2 name mark still have china[0] nam[1] 
		
		/* for each for(datatype variable : arraylistname)
		for(car i : nam)
 		{
			System.out.println(i.distance +" "+i.engine+" "+i.version+" "+i.wheel);
		}*/
		
		//normal for dont forget to call class name.get(i).information everytime
		for (int i = 0 ; i < nam.size() ; i++) 
		{
			System.out.println("distance : "+nam.get(i).distance+" "+"engine : "+nam.get(i).engine);
		} 
	}
}
