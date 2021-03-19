import java.util.*;

public class FactoryShape {
	/**
	 * 
	 * @param type string representing type of shape
	 * @param origin starting point of the shape
	 * @param shapeParameter list representing parameter of shape
	 * @return object of shape whose type is defined by string type
	 */
	public Shape createShape(String type, Point origin, List<Double> shapeParameter){
		if(type == null){
			return null;
		}
		else if(type == "Square"){
			Square square = new Square(origin, shapeParameter);
			return square;
		}
		else if(type == "Circle"){
			Circle circle = new Circle(origin, shapeParameter);
			return circle;
		}
		else if(type == "Rectangle"){
			Rectangle rectangle = new Rectangle(origin, shapeParameter);
			return rectangle;
		}
		return null;
	}

}
