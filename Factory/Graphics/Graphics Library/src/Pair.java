
public class Pair {
	private Shape shape;
	private double value;
	/**
	 * 
	 * @param origin origin Shape of the shape
	 * @param shapeType type of shape
	 * 
	 * Note: creates a pair consisting of 
	 * 		 origin and shapeType
	 */
	Pair(Shape shape, double value){
		this.shape = shape;
		this.value = value;
	}
	/**
	 * 
	 * @return first value in the pair
	 */
	public Shape first(){
		return this.shape;
	}
	/**
	 * 
	 * @return second value in the pair
	 */
	public double second(){
		return this.value;
	}
}
