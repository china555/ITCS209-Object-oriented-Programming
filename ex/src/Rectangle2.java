
public class Rectangle2 {
	public int width;
	public int height;
	
	public Rectangle2() {
		width = 0;
		height = 0;
	}
	public int setWidth(int w) {
		if(w == 40) {
			return this.width = 20 ;
		}
		else {
			return this.width = 50;
		}
	}
	public void setheight(int h) {
		height = h;
	}
	public int area() {
		return width * height;
	}
	public static void main(String[] args) {
		Rectangle2 myRect = new Rectangle2();
		myRect.setWidth(40);
		myRect.setheight(50);
		System.out.println("myRect's area "+myRect.area());
	}

}
