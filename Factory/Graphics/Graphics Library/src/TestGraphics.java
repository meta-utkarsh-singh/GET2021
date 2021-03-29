import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class TestGraphics {

	@Test
	public void testFactorySquare() {
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		Shape testSquare = FactoryShape.createShape(Shape.ShapeType.Square, origin, shapeParameter);
		assertTrue(testSquare!=null);
	}
	@Test
	public void testFactoryRectangle() {
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		shapeParameter.add(2.0);
		Shape testRectangle = FactoryShape.createShape(Shape.ShapeType.Rectangle, origin, shapeParameter);
		assertTrue(testRectangle!=null);
	}
	@Test
	public void testFactoryCircle() {
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		Shape testCircle = FactoryShape.createShape(Shape.ShapeType.Circle, origin, shapeParameter);
		assertTrue(testCircle!=null);
	}
	@Test
	public void testFactoryFail() {
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		Shape testCircle = FactoryShape.createShape(null, origin, shapeParameter);
		assertTrue(testCircle==null);
	}
	@Test
	public void testAdd() {
		Point screenMax = new Point(100.0,100.0);
		Screen screen = new Screen(screenMax);
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		screen.addShape(origin, Shape.ShapeType.Circle, shapeParameter);
		assertEquals(screen.getShapesOnScreen().get(0).shapeType(),Shape.ShapeType.Circle.name());
	}
	@Test
	public void testAddFail() {
		Point screenMax = new Point(100.0,100.0);
		Screen screen = new Screen(screenMax);
		Point origin = new Point(101,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		int value = screen.addShape(origin, Shape.ShapeType.Circle, shapeParameter);
		assertEquals(value,0);
	}
	@Test
	public void testDelete() {
		Point screenMax = new Point(100.0,100.0);
		Screen screen = new Screen(screenMax);
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		screen.addShape(origin, Shape.ShapeType.Circle, shapeParameter);
		assertEquals(screen.deleteShape(screen.getShapesOnScreen().get(0)),1);
	}
	@Test
	public void testDeleteFail() {
		Point originSquare = new Point(1,2);
		List<Double> shapeParameterSquare = new ArrayList<Double>();
		shapeParameterSquare.add(5.0);
		Shape testSquare = FactoryShape.createShape(Shape.ShapeType.Square, originSquare, shapeParameterSquare);
		Point screenMax = new Point(100.0,100.0);
		Screen screen = new Screen(screenMax);
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		screen.addShape(origin, Shape.ShapeType.Circle, shapeParameter);
		assertEquals(screen.deleteShape(testSquare),0);
	}
	@Test
	public void testDeleteOnType() {
		Point screenMax = new Point(100.0,100.0);
		Screen screen = new Screen(screenMax);
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		screen.addShape(origin, Shape.ShapeType.Circle, shapeParameter);
		Point originSquare = new Point(4,5);
		List<Double> shapeParameterSquare = new ArrayList<Double>();
		shapeParameterSquare.add(6.0);
		screen.addShape(originSquare, Shape.ShapeType.Square, shapeParameterSquare);
		Point originSquare1 = new Point(4,5);
		List<Double> shapeParameterSquare1 = new ArrayList<Double>();
		shapeParameterSquare1.add(6.0);
		screen.addShape(originSquare1, Shape.ShapeType.Square, shapeParameterSquare1);
		assertEquals(screen.deleteShapeOnType(Shape.ShapeType.Square),1);
	}
	@Test
	public void testCompareByArea() {
		Point originSquare = new Point(1,2);
		List<Double> shapeParameterSquare = new ArrayList<Double>();
		shapeParameterSquare.add(20.0);
		Point screenMax = new Point(100.0,100.0);
		Screen screen = new Screen(screenMax);
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		screen.addShape(originSquare, Shape.ShapeType.Square, shapeParameterSquare);
		screen.addShape(origin, Shape.ShapeType.Circle, shapeParameter);
		screen.sort(1);
		assertEquals(screen.getAreaOfShapes().get(1).shapeType(), Shape.ShapeType.Square.name());
	}
	@Test
	public void testCompareByTimeStamp() {
		Point originSquare = new Point(1,2);
		List<Double> shapeParameterSquare = new ArrayList<Double>();
		shapeParameterSquare.add(20.0);
		Point screenMax = new Point(100.0,100.0);
		Screen screen = new Screen(screenMax);
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		screen.addShape(originSquare, Shape.ShapeType.Square, shapeParameterSquare);
		screen.addShape(origin, Shape.ShapeType.Circle, shapeParameter);
		screen.sort(4);
		assertEquals(screen.getTimeStamp().get(0).shapeType(), Shape.ShapeType.Square.name());
	}
	@Test
	public void testCompareByDistanceFromOrigin() {
		Point originSquare = new Point(1,4);
		List<Double> shapeParameterSquare = new ArrayList<Double>();
		shapeParameterSquare.add(20.0);
		Point originRectangle = new Point(5,4);
		List<Double> shapeParameterRect = new ArrayList<Double>();
		shapeParameterRect.add(4.0);
		shapeParameterRect.add(5.0);
		Point screenMax = new Point(100.0,100.0);
		Screen screen = new Screen(screenMax);
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		screen.addShape(originSquare, Shape.ShapeType.Square, shapeParameterSquare);
		screen.addShape(origin, Shape.ShapeType.Circle, shapeParameter);
		screen.addShape(originRectangle, Shape.ShapeType.Rectangle, shapeParameterRect);
		screen.sort(2);
		assertEquals(screen.getDistanceFromOrigin().get(0).shapeType(), Shape.ShapeType.Circle.name());
		assertEquals(screen.getDistanceFromOrigin().get(1).shapeType(), Shape.ShapeType.Square.name());
	}
	@Test
	public void testCompareByPerimOfShape() {
		Point originTriangle = new Point(1,2);
		List<Double> shapeParameterTriangle = new ArrayList<Double>();
		shapeParameterTriangle.add(5.0);
		shapeParameterTriangle.add(3.0);
		shapeParameterTriangle.add(2.0);
		shapeParameterTriangle.add(7.0);
		Point originSquare = new Point(1,4);
		List<Double> shapeParameterSquare = new ArrayList<Double>();
		shapeParameterSquare.add(20.0);
		Point originRectangle = new Point(5,4);
		List<Double> shapeParameterRect = new ArrayList<Double>();
		shapeParameterRect.add(4.0);
		shapeParameterRect.add(5.0);
		Point screenMax = new Point(100.0,100.0);
		Screen screen = new Screen(screenMax);
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		screen.addShape(originSquare, Shape.ShapeType.Square, shapeParameterSquare);
		screen.addShape(origin, Shape.ShapeType.Circle, shapeParameter);
		screen.addShape(originRectangle, Shape.ShapeType.Rectangle, shapeParameterRect);
		screen.addShape(originTriangle, Shape.ShapeType.Triangle, shapeParameterTriangle);
		screen.sort(3);
		assertEquals(screen.getPerimOfShapes().get(0).shapeType(), Shape.ShapeType.Triangle.name());
		assertEquals(screen.getPerimOfShapes().get(2).shapeType(), Shape.ShapeType.Circle.name());
	}
	@Test
	public void testEnclosing() {
		Point originSquare = new Point(1,4);
		List<Double> shapeParameterSquare = new ArrayList<Double>();
		shapeParameterSquare.add(20.0);
		Point originRectangle = new Point(50,55);
		List<Double> shapeParameterRect = new ArrayList<Double>();
		shapeParameterRect.add(4.0);
		shapeParameterRect.add(5.0);
		Point screenMax = new Point(100.0,100.0);
		Screen screen = new Screen(screenMax);
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(25.0);
		screen.addShape(originSquare, Shape.ShapeType.Square, shapeParameterSquare);
		screen.addShape(origin, Shape.ShapeType.Circle, shapeParameter);
		screen.addShape(originRectangle, Shape.ShapeType.Rectangle, shapeParameterRect);
		List<Shape> enclosed = screen.enclosing(new Point(1,5));
		assertEquals(enclosed.get(0).shapeType(),Shape.ShapeType.Square.name());
	}
	@Test
	public void testFactoryTriangle() {
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		shapeParameter.add(3.0);
		shapeParameter.add(2.0);
		shapeParameter.add(7.0);
		Shape testSquare = FactoryShape.createShape(Shape.ShapeType.Triangle, origin, shapeParameter);
		assertTrue(testSquare!=null);
	}
}
