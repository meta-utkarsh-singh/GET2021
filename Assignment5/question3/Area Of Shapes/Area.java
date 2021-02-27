
public class Area {
	/**
	 * 
	 * @param height positive double representing height of triangle
	 * @param base positive double representing base of triangle
	 * @return area of triangle
	 */
	public double areaOfTriangle(double height, double base) {
		if(base <= 0 || height <= 0){
			System.out.println("Enter valid values");
			return -1;
		}
		return (base * height / 2);
	}
	/**
	 * 
	 * @param height positive double representing height of rectangle
	 * @param base positive double representing width of rectangle
	 * @return area of rectangle
	 */
	public double areaOfRectangle(double height , double width){
		if(height <= 0 || width <= 0){
			System.out.println("Enter valid values");
			return -1;
		}
		return height*width;
	}
	/**
	 * 
	 * @param width positive double representing width of square
	 * @return area of square
	 */
	public double areaOfSquare(double width){
		if(width <= 0){
			System.out.println("Enter valid value");
			return -1;
		}
		return width*width;
	}
	/**
	 * 
	 * @param width positive double representing radius of circle
	 * @return area of circle
	 */
	public double areaOfCircle(double radius){
		if(radius<=0){
			System.out.println("Enter valid value");
			return -1;
		}
		return 3.14*radius*radius;
	}
}
