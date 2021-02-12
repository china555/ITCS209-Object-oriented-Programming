package ex;

class People{
	public String name;
	public String lastname;
	public People (String name, String lastname) {
		this.name = name;
		this.lastname = lastname;
	}
}
class usergive extends People{
	private String message;
	public int password = 98567;
	public usergive(String name, String lastname,String message,int password) {
		super(name, lastname);
		this.password = password;
		this.setMessage(message);
		// TODO Auto-generated constructor stub
	}
	public String getMessage(int password) {
		if(password == 98567)
		return message;
		else
		{
			return "blank";
		}
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
class userre extends People{
	
	public String address;
	private String message;
	public int password;        
	public userre(String name, String lastname,String address,String message,int password) {
		super(name, lastname);
		this.password = password;
		// TODO Auto-generated constructor stub
	}
	public String getMessage(int password) {
		if(password == 98567)
			return message;
			else
			{
				return "blank";
			}
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
class freighter extends People{

	public int ID;
	private String message;
	public int password;
	public freighter(String name, String lastname,int ID,String message,int password) {
		super(name, lastname);
		this.password = password;
		this.setMessage(message);
		
		// TODO Auto-generated constructor stub
	}
	public String getMessage(int password) {
		if(password == 98567)
			return message;
			else
			{
				return "blank";
			}
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
public class Delivery {
	public static void main(String[] agrs) {
		usergive firstsend = new usergive("check", "checker", "Birdbox",98567);
		freighter send = new freighter("Tar", "Tatar", 6088, "null",0);
		userre receive = new userre("china","china", "waddadf", "null",0);
		System.out.println("Before send to freighter "+send.getMessage(0));
		send.password = firstsend.password;
		send.setMessage(firstsend.getMessage(send.password));
		System.out.println("After send to freighter "+send.getMessage(send.password));
		System.out.println("Before sent message "+receive.getMessage(0));
		receive.password = send.password;
		receive.setMessage(send.getMessage(send.password));
		System.out.println("After receive message "+receive.getMessage(send.password));
		
	}
}
