import java.util.Comparator;


public class CompareByTimeStamp implements Comparator<Shape>{

	@Override
	public int compare(Shape shape1, Shape shape2) {
		return shape1.getTimeStamp().compareTo(shape2.getTimeStamp());
	}

}
