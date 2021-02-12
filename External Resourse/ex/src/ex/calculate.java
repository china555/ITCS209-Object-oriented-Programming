package ex;

import java.util.Scanner;

class Circle{
	public double Pi = 3.14;
	public double radius;
	public Circle (double radius) {
		this.radius = radius;
	}
	public double calculate() {
		return (Pi*Pi)*radius;
	}
} 
class Square{
	public int side;
	public Square(int side) {
		this.side = side;
	}
	public int calculate() {
		return side*side;
	}
}
class Triangle{
	public double base;
	public double height;
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;	
	}
	public double calculate() {
			return (base*height)/2;
		}
}
public class calculate {
	public static void main(String[] args) {
		Circle a = new Circle(5);
		System.out.println(a.calculate());
		
		Scanner x = new Scanner(System.in);
		int input = x.nextInt();
		Square b = new Square(input);
		System.out.println(b.calculate());
		
		Triangle c = new Triangle(5, 10);
		System.out.println(c.calculate());
	}

}


