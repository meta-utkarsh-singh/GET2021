import java.util.*;

public class Screen {
	private Point screen;
	private List<Shape> shapeOnScreen = new ArrayList<Shape>();
	private List<Shape> areaOfShapes = new ArrayList<Shape>();
	private List<Shape> perimOfShapes = new ArrayList<Shape>();
	private List<Shape> timeStamp = new ArrayList<Shape>();
	private List<Shape> distanceFromOrigin = new ArrayList<Shape>();
	/**
	 * 
	 * @param screen XMAX and YMAX, representing dimensions of the screen 
	 */
	Screen(Point screen){
		this.screen = screen;
	}
	/**
	 * 
	 * @param origin
	 * @param type
	 * @param shapeParameter
	 */
	public void addShape(Point origin, String type, List<Double> shapeParameter){
		FactoryShape factory = new FactoryShape();
		Shape shape = factory.createShape(type, origin, shapeParameter);
		areaOfShapes.add(shape);
		perimOfShapes.add(shape);
		timeStamp.add(shape);
		distanceFromOrigin.add(shape);
		shapeOnScreen.add(shape);
	}
	/**
	 * 
	 * @param shape shape that needs to be deleted
	 */
	public void deleteShape(Shape shape){
		if(shapeOnScreen.contains(shape)){
			shapeOnScreen.remove(shape);
			areaOfShapes.remove(shape);
			perimOfShapes.remove(shape);
			distanceFromOrigin.remove(shape);
			timeStamp.remove(shape);
		}
		else{
			System.out.println("Shape not found");
		}
	}
	/**
	 * 
	 * @param type type of shape that needs to be removed
	 */
	public void deleteShapeOnType(String type){
		if(type != "Square" || type != "Circle" || type != "Rectangle"){
			System.out.println("Shape not found");
			return;
		}
		for(int i = 0 ; i < shapeOnScreen.size() ; i++){
			if(shapeOnScreen.get(i).shapeType() == type){
				shapeOnScreen.remove(i);
			}
		}
	}
	/**
	 * 
	 * @param typeOfSort type of sorting that needs to be performed
	 */
	public void sort(int typeOfSort){
		if(typeOfSort == 1){
			Collections.sort(areaOfShapes, new CompareByArea());
		}
		else if(typeOfSort == 2){
			Collections.sort(distanceFromOrigin, new CompareByDistanceFromOrigin());
		}
		else if(typeOfSort == 3){
			Collections.sort(perimOfShapes, new CompareByPerimeter());
		}
		else if(typeOfSort == 4){
			Collections.sort(timeStamp, new CompareByTimeStamp());
		}
		else {
			System.out.println("Enter valid type of sort");
		}
	}
	/**
	 * 
	 * @param p point that needs to be checked for enclosing
	 * @return list of shapes that enclose the point p
	 */
	public List<Shape> enclosing(Point p){
		List<Shape> isEnclosing = new ArrayList<Shape>();
		for(int i = 0 ; i < shapeOnScreen.size() ; i++) {
			if(shapeOnScreen.get(i).isPointEnclosed(p)){
				isEnclosing.add(shapeOnScreen.get(i));
			}
		}
		return isEnclosing;
	}
}
