package ex;


public class BookTitle {
	private String title;
	private Author author;
	private String publisher;
	private double price;
	private int quantity;
	public static int total=0;
	BookTitle(String title,Author author,String publisher,double price,int quantity){
		this.title=title;
		this.author = author;
		this.publisher=publisher;
		this.price=price;
		this.quantity=quantity;
		total = total +quantity;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getauthor() {
		return author;
	}
	public void setauthor(Author author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void returnbook() {
		System.out.println("Book title "+"<"+getTitle()+"> "+"ha been returned.  Thanhs.");
		this.quantity++;
		total++;
	}
	public void checkout() {
		
		if(this.quantity>0) {
			System.out.println("Book title "+"<"+getTitle()+"> "+"is borrowed.");
			this.quantity--;
			total--;
		}
		else {
		System.out.println("No Book title "+"<"+getTitle()+"> "+"left.  Come back later.");
	}
}
}
class BookLoanApplication{
	public static void main(String[] args) {
		Author writter = new Author("Tar",65484);
		BookTitle book1 = new BookTitle("Java",writter,"Tarrang",99.99,3);
		BookTitle book2 = new BookTitle("C++", writter, "Chinaco.",59.99,2);
		book1.checkout();
		book1.checkout();
		book1.checkout();
		book2.checkout();
		book2.checkout();
		book2.checkout();
		book1.returnbook();
		book1.returnbook();
		book2.returnbook();
		book2.returnbook();
		System.out.println("Book title "+"<"+book1.getTitle()+"> has "+book1.getQuantity()+" copies left.");
		System.out.println("Book title "+"<"+book1.getTitle()+"> has "+book2.getQuantity()+" copies left.");
		System.out.println("The total number of books left in the library is "+BookTitle.total+".");
	}
}
class Author{
	private String Name;
	private int phone;
	Author(String Name,int phone){
		this.Name =Name;
		this.phone = phone;
	}
	public void setName(String name) {
		this.Name=name;
	}
	public String getName() {
		return Name;
	}
	public void setphone(int phone) {
		this.phone = phone;
	}
	public int getphone() {
		return phone;
	}
}
