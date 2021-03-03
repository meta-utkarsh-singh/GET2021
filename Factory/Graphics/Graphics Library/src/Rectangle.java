import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Rectangle implements Shape {
	private Point origin;
	private List<Double> sides;
	private String timeStamp;
	Rectangle(Point origin, List<Double> sides){
		this.origin = origin;
		this.sides = sides;
		this.timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
				   .format(LocalDateTime.now());
	}
	@Override
	public double getArea() {
		return this.sides.get(0)*this.sides.get(1);
	}
	@Override
	public double getPerimeter() {
		return 2*(this.sides.get(0)+this.sides.get(1));
	}
	@Override
	public Point getOrigin() {
		return this.origin;
	}
	@Override
	public boolean isPointEnclosed(Point checkPoint) {
		double checkPointX = checkPoint.getX();
		double checkPointY = checkPoint.getY();
		double rectX = this.origin.getX();
		double rectY = this.origin.getY();
		double sideLimit = rectX + this.sides.get(0);
		double upperLimit = rectY + this.sides.get(1);
		if(checkPointX >= rectX && checkPointX <= sideLimit && 
				checkPointY >= rectY && checkPointY <= upperLimit){
			return true;
		}
		return false;
	}
	@Override
	public String shapeType() {
		return "Rectangle";
	}
	@Override
	public String getTimeStamp() {
		return this.timeStamp;
	}
}
