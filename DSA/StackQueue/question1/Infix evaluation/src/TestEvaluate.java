import static org.junit.Assert.*;

import org.junit.Test;


public class TestEvaluate {

	@Test
	public void test1() {
		String s = "( 1 + 2 )";
		InfixEvaluate i = new InfixEvaluate(s);
		assertEquals(3,i.evaluate());
	}
	@Test
	public void test2() {
		String s = "(1 * ( 5 + 7 ) + 2)";
		InfixEvaluate i = new InfixEvaluate(s);
		assertEquals(14,i.evaluate());
	}
	@Test
	public void test3() {
		String s = "(1 * (5 + 7) / 3 + 3 + 2)";
		InfixEvaluate i = new InfixEvaluate(s);
		assertEquals(9,i.evaluate());
	}
	@Test
	public void test4() {
		String s = "((1 * (5 + 7) / 3 + 3 + 2) & 9)";
		InfixEvaluate i = new InfixEvaluate(s);
		assertEquals(9,i.evaluate());
	}
	@Test
	public void test5() {
		String s = "()";
		InfixEvaluate i = new InfixEvaluate(s);
		assertEquals(0,i.evaluate());
	}
	@Test
	public void test6() {
		String s = "((1 * (5 + 7) / 3 + 3 + 2) == 9)";
		InfixEvaluate i = new InfixEvaluate(s);
		assertEquals(1,i.evaluate());
	}
}
