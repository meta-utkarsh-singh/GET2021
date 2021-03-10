import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class TestStringProcessor {

	@Test
	public void testGetUniqueElement() {
		String s = "hello byee";
		StringProcessor sp = new StringProcessor();
		List<Character> actual = sp.getUniqueElement(s);
		assertEquals(true,actual.contains('h'));
		assertEquals(true,actual.contains('o'));
		assertEquals(true,actual.contains('b'));
		assertEquals(true,actual.contains('y'));
		assertEquals(false,actual.contains('e'));
	}

}
