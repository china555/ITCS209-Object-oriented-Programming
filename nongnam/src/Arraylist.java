import java.util.ArrayList;

public class Arraylist {
	public ArrayList<China> nam ;
	public int total;
 public Arraylist() {
	nam = new ArrayList<China>();
}
 public void add(China lover) {
	 nam.add(lover);
 }
 public int getbalance() {
	 for(China a : nam ){
		 total = total + a.balance;
	 }
	 return total;
 }
}
