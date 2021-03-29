import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Triangle implements Shape {
	private Point origin;
	private Point apex;
	private List<Double> baseHeightApex;
	private String timeStamp;
	Triangle(Point origin, List<Double> baseHeightApex){
		this.origin = origin;
		this.baseHeightApex = baseHeightApex;
		this.timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
				   .format(LocalDateTime.now());
		this.apex = new Point(baseHeightApex.get(2),baseHeightApex.get(3));
	}
	/**
	 * helper method to find area of triangle using vertices of a triangle
	 * @param a point a of triangle
	 * @param b point b of triangle
	 * @param c point c of triangle
	 * @return area of triangle
	 */
	private double getAreaFromVertices(Point a, Point b, Point c) {
		double area = (a.getX()*(b.getY()-c.getY())+b.getX()*(c.getY()-a.getY())+
						c.getX()*(a.getY()-b.getY()));
		return area;
	}
	@Override
	public String getTimeStamp() {
		return this.timeStamp;
	}
	@Override
	public String shapeType() {
		return "Triangle";
	}

	@Override
	public double getArea() {
		return (this.baseHeightApex.get(0)*this.baseHeightApex.get(1))/2;
	}

	@Override
	public double getPerimeter() {
		Point a = this.origin;
		Point b = new Point(origin.getX()+this.baseHeightApex.get(0),origin.getY());
		Point c = this.apex;
		double distAB = Math.sqrt(Math.pow(a.getX()-b.getX(), 2)+
				Math.pow(a.getY()-b.getY(), 2));
		double distBC = Math.sqrt(Math.pow(b.getX()-c.getX(), 2)+
				Math.pow(b.getY()-c.getY(), 2));
		double distAC = Math.sqrt(Math.pow(a.getX()-c.getX(), 2)+
				Math.pow(a.getY()-c.getY(), 2));
		return (distAB + distBC + distAC);
	}

	@Override
	public Point getOrigin() {
		return this.origin;
	}

	@Override
	public boolean isPointEnclosed(Point checkPoint) {
		Point a = this.origin;
		Point b = new Point(origin.getX()+this.baseHeightApex.get(0),origin.getY());
		Point c = this.apex;
		double areaOfOriginalTriangle = getAreaFromVertices(a,b,c);
		double area1 = getAreaFromVertices(checkPoint,a,b);
		double area2 = getAreaFromVertices(checkPoint,a,c);
		double area3 =getAreaFromVertices(checkPoint,b,c);
		if(area1+area2+area3 == areaOfOriginalTriangle) {
			return true;
		}
		return false;
	}

}
