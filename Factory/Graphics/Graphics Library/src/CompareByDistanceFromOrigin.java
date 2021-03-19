import java.util.Comparator;


public class CompareByDistanceFromOrigin implements Comparator<Shape> {

	@Override
	public int compare(Shape shape1, Shape shape2) {
		double distanceFromOriginShape1 = Math.pow(shape1.getOrigin().getX(), 2)+
										  Math.pow(shape1.getOrigin().getY(), 2);
		double distanceFromOriginShape2 = Math.pow(shape2.getOrigin().getX(), 2)+
										  Math.pow(shape2.getOrigin().getY(), 2);
		return (int) (distanceFromOriginShape1 - distanceFromOriginShape2);
	}

}
