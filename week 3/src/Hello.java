
public class Hello {
	public static void main(String[] agrs) {
		Author rowling = new Author("J.K. Rowling",'f');
		System.out.println("Hello "+rowling.getname());
		rowling.setPhoneNum("001-1234-2346");
		Author kondo = new Author("Marie Kondo",'f');
		System.out.println("Hello "+kondo.getname());
		System.out.println("Number of authors is "+Author.count);
		System.out.println("To contact "+rowling.getname()+
							" Please call "+ rowling.getPhoneNum());
		System.out.println("To contact "+kondo.getname()+
							" Please call "+ kondo.getPhoneNum());
	}

}
