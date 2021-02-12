package ex;

import java.util.ArrayList;

class message{
	public String message;
	public String type;
	public String address;
	public String Giver;
	public String reciever;
public message(String message,String type,String address,String Giver,String reciever) {
	this.message = message;
	this.type = type;
	this.address = address;
	this.Giver = Giver;
	this.reciever = reciever;
}
}
public class send {
	public static void main(String[] agrs) {
		ArrayList<message> listmessage = new ArrayList<message>();
		listmessage.add(new message("Hello Tar","Greeeting","Mahidol","china","Tar"));
		listmessage.remove(0);
	}
}
