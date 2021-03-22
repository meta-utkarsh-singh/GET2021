import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class TestStringProcessor {

	@Test
	public void testGetUniqueElement() {
		String s = "hello byee";
		StringProcessor sp = new StringProcessor();
		int value = sp.getUniqueElement(s);
		assertEquals(6,value);
	}

}
