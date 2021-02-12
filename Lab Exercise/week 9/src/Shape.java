
public abstract class Shape implements Comparable<Shape> {
	
   private String color;
   protected static double PI = 3.14;
   private String description;
   
   // Constructors
   public Shape (String color,String description) {
      this.color = color;
      this.description = description;
   }
   public String getColor() {
	return color;
   }
   public void setColor(String color) {
	this.color = color;
   }
@Override
   public String toString() {
      return "->"+this.description+"(color=" + color+", area="+getArea()+")";
   }
   public abstract double getArea();
   @Override
   public int compareTo(Shape shape) {//Object
	   if(this.getArea() > shape.getArea()) {//((Shape)shapes).getArea();
		   return 1;   
	   }
	   else if(this.getArea() < shape.getArea()) {
		   return -1;   
	   }
	   else {
		   return 0;
	   }
   }
}
