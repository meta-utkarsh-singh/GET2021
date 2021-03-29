import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Circle implements Shape {
	private Point origin;
	private List<Double>radius;
	private String timeStamp;
	Circle(Point origin, List<Double> radius){
		this.origin = origin;
		this.radius = radius;
		this.timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
				   .format(LocalDateTime.now());
	}
	@Override
	public double getArea() {
		return 3.14 * this.radius.get(0) * this.radius.get(0);
	}
	@Override
	public double getPerimeter() {
		return 2 * 3.14 * this.radius.get(0);
	}
	@Override
	public Point getOrigin() {
		return this.origin;
	}
	@Override
	public boolean isPointEnclosed(Point checkPoint) {
		double circleX = this.origin.getX();
		double circleY = this.origin.getY();
		double checkPointX = checkPoint.getX();
		double checkPointY = checkPoint.getY();
		double distanceFromCenter = Math.sqrt(Math.pow(circleX+this.radius.get(0)
				-checkPointX, 2)
				+ Math.pow(checkPointY+this.radius.get(0)-circleY, 2));
		if(distanceFromCenter <= this.radius.get(0)){
			return true;
		}
		return false;
	}
	@Override
	public String shapeType() {
		return "Circle";
	}
	@Override
	public String getTimeStamp() {
		return timeStamp;
	}
}
