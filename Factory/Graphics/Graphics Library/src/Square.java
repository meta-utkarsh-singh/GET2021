import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Square implements Shape {
	private Point origin;
	private List<Double> side;
	private String timeStamp;
	Square(Point origin, List<Double> side){
		this.origin = origin;
		this.side = side;
		this.timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
				   .format(LocalDateTime.now());
	}
	@Override
	public double getArea() {
		double sideOfSquare = side.get(0);
		return sideOfSquare * sideOfSquare;
	}
	@Override
	public double getPerimeter() {
		return 4 * side.get(0);
	}
	@Override
	public Point getOrigin() {
		Point origin = new Point(this.origin.getX(), this.origin.getY());
		return origin;
	}
	@Override
	public boolean isPointEnclosed(Point checkPoint) {
		double checkPointX = checkPoint.getX();
		double checkPointY = checkPoint.getY();
		double squareX = this.origin.getX();
		double squareY = this.origin.getY();
		double sideLimit = squareX + this.side.get(0);
		double upperLimit = squareY + this.side.get(0);
		if(checkPointX >= squareX && checkPointX <= sideLimit && 
				checkPointY >= squareY && checkPointY <= upperLimit){
			return true;
		}
		return false;
	}
	@Override
	public String shapeType() {
		return "Square";
	}
	@Override
	public String getTimeStamp() {
		return this.timeStamp;
	}
}
