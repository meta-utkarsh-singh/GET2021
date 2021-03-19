import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class TestGraphics {

	@Test
	public void testFactorySquare() {
		FactoryShape factory = new FactoryShape();
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		Shape testSquare = factory.createShape("Square", origin, shapeParameter);
		assertTrue(testSquare!=null);
	}
	@Test
	public void testFactoryRectangle() {
		FactoryShape factory = new FactoryShape();
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		shapeParameter.add(2.0);
		Shape testRectangle = factory.createShape("Rectangle", origin, shapeParameter);
		assertTrue(testRectangle!=null);
	}
	@Test
	public void testFactoryCircle() {
		FactoryShape factory = new FactoryShape();
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		Shape testCircle = factory.createShape("Circle", origin, shapeParameter);
		assertTrue(testCircle!=null);
	}
	@Test
	public void testFactoryFail() {
		FactoryShape factory = new FactoryShape();
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		Shape testCircle = factory.createShape("uuuu", origin, shapeParameter);
		assertTrue(testCircle==null);
	}
	@Test
	public void testAdd() {
		Point screenMax = new Point(100.0,100.0);
		Screen screen = new Screen(screenMax);
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		screen.addShape(origin, "Circle", shapeParameter);
		assertEquals(screen.getShapesOnScreen().get(0).shapeType(),"Circle");
	}
	@Test
	public void testAddFail() {
		Point screenMax = new Point(100.0,100.0);
		Screen screen = new Screen(screenMax);
		Point origin = new Point(101,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		int value = screen.addShape(origin, "Circle", shapeParameter);
		assertEquals(value,0);
	}
	@Test
	public void testDelete() {
		Point screenMax = new Point(100.0,100.0);
		Screen screen = new Screen(screenMax);
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		screen.addShape(origin, "Circle", shapeParameter);
		assertEquals(screen.deleteShape(screen.getShapesOnScreen().get(0)),1);
	}
	@Test
	public void testDeleteFail() {
		FactoryShape factory = new FactoryShape();
		Point originSquare = new Point(1,2);
		List<Double> shapeParameterSquare = new ArrayList<Double>();
		shapeParameterSquare.add(5.0);
		Shape testSquare = factory.createShape("Square", originSquare, shapeParameterSquare);
		Point screenMax = new Point(100.0,100.0);
		Screen screen = new Screen(screenMax);
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		screen.addShape(origin, "Circle", shapeParameter);
		assertEquals(screen.deleteShape(testSquare),0);
	}
	@Test
	public void testDeleteOnType() {
		Point screenMax = new Point(100.0,100.0);
		Screen screen = new Screen(screenMax);
		Point origin = new Point(1,2);
		List<Double> shapeParameter = new ArrayList<Double>();
		shapeParameter.add(5.0);
		screen.addShape(origin, "Circle", shapeParameter);
		Point originSquare = new Point(4,5);
		List<Double> shapeParameterSquare = new ArrayList<Double>();
		shapeParameterSquare.add(6.0);
		screen.addShape(originSquare, "Square", shapeParameterSquare);
		Point originSquare1 = new Point(4,5);
		List<Double> shapeParameterSquare1 = new ArrayList<Double>();
		shapeParameterSquare1.add(6.0);
		screen.addShape(originSquare1, "Square", shapeParameterSquare1);
		assertEquals(screen.deleteShapeOnType("Square"),1);
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
		screen.addShape(originSquare, "Square", shapeParameterSquare);
		screen.addShape(origin, "Circle", shapeParameter);
		screen.sort(1);
		assertEquals(screen.getAreaOfShapes().get(1).shapeType(), "Square");
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
		screen.addShape(originSquare, "Square", shapeParameterSquare);
		screen.addShape(origin, "Circle", shapeParameter);
		screen.sort(4);
		assertEquals(screen.getTimeStamp().get(0).shapeType(), "Square");
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
		screen.addShape(originSquare, "Square", shapeParameterSquare);
		screen.addShape(origin, "Circle", shapeParameter);
		screen.addShape(originRectangle, "Rectangle", shapeParameterRect);
		screen.sort(2);
		assertEquals(screen.getDistanceFromOrigin().get(0).shapeType(), "Circle");
		assertEquals(screen.getDistanceFromOrigin().get(1).shapeType(), "Square");
	}
	@Test
	public void testCompareByPerimOfShape() {
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
		screen.addShape(originSquare, "Square", shapeParameterSquare);
		screen.addShape(origin, "Circle", shapeParameter);
		screen.addShape(originRectangle, "Rectangle", shapeParameterRect);
		screen.sort(3);
		assertEquals(screen.getPerimOfShapes().get(0).shapeType(), "Rectangle");
		assertEquals(screen.getPerimOfShapes().get(2).shapeType(), "Square");
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
		screen.addShape(originSquare, "Square", shapeParameterSquare);
		screen.addShape(origin, "Circle", shapeParameter);
		screen.addShape(originRectangle, "Rectangle", shapeParameterRect);
		List<Shape> enclosed = screen.enclosing(new Point(1,5));
		assertEquals(enclosed.get(0).shapeType(),"Square");
		assertEquals(enclosed.get(1).shapeType(),"Circle");
	}
}
