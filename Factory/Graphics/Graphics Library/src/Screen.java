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
	public int addShape(Point origin, String type, List<Double> shapeParameter){
		if(type == "Square"){
			if(origin.getX() > screen.getX() || origin.getY() > screen.getY()
					|| origin.getX() + shapeParameter.get(0)>screen.getX() || 
					origin.getY() + shapeParameter.get(0) > screen.getY()){
				return 0;
			}
		}
		else if(type == "Rectangle"){
			if(origin.getX() > screen.getX() || origin.getY() > screen.getY()
					|| origin.getX() + shapeParameter.get(0)>screen.getX() || 
					origin.getY() + shapeParameter.get(1) > screen.getY()){
				return 0;
			}
		}
		else if(type == "Circle"){
			if(origin.getX() > screen.getX() || origin.getY() > screen.getY()
					|| origin.getX() + shapeParameter.get(0)>screen.getX() || 
					origin.getY() + shapeParameter.get(0) > screen.getY()){
				return 0;
			}
		}
		FactoryShape factory = new FactoryShape();
		Shape shape = factory.createShape(type, origin, shapeParameter);
		areaOfShapes.add(shape);
		perimOfShapes.add(shape);
		timeStamp.add(shape);
		distanceFromOrigin.add(shape);
		shapeOnScreen.add(shape);
		return 1;
	}
	/**
	 * 
	 * @param shape shape that needs to be deleted
	 */
	public int deleteShape(Shape shape){
		if(shapeOnScreen.contains(shape)){
			shapeOnScreen.remove(shape);
			areaOfShapes.remove(shape);
			perimOfShapes.remove(shape);
			distanceFromOrigin.remove(shape);
			timeStamp.remove(shape);
			return 1;
		}
		else{
			System.out.println("Shape not found");
			return 0;
		}
	}
	/**
	 * 
	 * @param type type of shape that needs to be removed
	 */
	public int deleteShapeOnType(String type){
		if(type != "Square" && type != "Circle" && type != "Rectangle"){
			System.out.println("Shape not found");
			return 0;
		}
		for(int i = 0 ; i < shapeOnScreen.size() ; i++){
			if(shapeOnScreen.get(i).shapeType() == type){
				shapeOnScreen.remove(i);
			}
		}
		return 1;
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
	/**
	 * 
	 * @return getter for shapeOnScreen array
	 */
	public List<Shape> getShapesOnScreen(){
		List<Shape> shapeOnScreen = new ArrayList<Shape>();
		for(int i = 0 ; i < this.shapeOnScreen.size() ; i++){
			shapeOnScreen.add(this.shapeOnScreen.get(i));
		}
		return shapeOnScreen;
	}
	/**
	 * 
	 * @return getter for timeStamp array
	 */
	public List<Shape> getTimeStamp(){
		List<Shape> timeStamp = new ArrayList<Shape>();
		for(int i = 0 ; i < this.timeStamp.size() ; i++){
			timeStamp.add(this.timeStamp.get(i));
		}
		return timeStamp;
	}
	/**
	 * 
	 * @return getter for distanceFromOrigin array
	 */
	public List<Shape> getDistanceFromOrigin(){
		List<Shape> distanceFromOrigin = new ArrayList<Shape>();
		for(int i = 0 ; i < this.distanceFromOrigin.size() ; i++){
			distanceFromOrigin.add(this.distanceFromOrigin.get(i));
		}
		return distanceFromOrigin;
	}
	/**
	 * 
	 * @return getter for perimOfShape array
	 */
	public List<Shape> getPerimOfShapes(){
		List<Shape> perimOfShapes = new ArrayList<Shape>();
		for(int i = 0 ; i < this.perimOfShapes.size() ; i++){
			perimOfShapes.add(this.perimOfShapes.get(i));
		}
		return perimOfShapes;
	}
	/**
	 * 
	 * @return getter for areaOfShape array
	 */
	public List<Shape> getAreaOfShapes(){
		List<Shape> areaOfShapes = new ArrayList<Shape>();
		for(int i = 0 ; i < this.areaOfShapes.size() ; i++){
			areaOfShapes.add(this.areaOfShapes.get(i));
		}
		return areaOfShapes;
	}
}
