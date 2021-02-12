
public class Circle extends Shape {

		private double radius;
		private static double PI = 3.14;
		public Circle() {
			this.radius = 0;
		}
		Circle(String color,double radius){
			super.setColor(color);
			this.radius = radius;
		}
		public double getArea() {
			return PI * Math.pow(radius, 2);
			//return (22/7)*(radius * radius);
		}
		public double getArea(double radius) {
			this.radius = radius;
			return getArea();
		}
		@Override
		public String toString() {
			return "Circle[base="+this.radius+super.toString();
		}


}
