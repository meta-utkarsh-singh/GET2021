import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*
;
public class TestPolynomial {

	@Test
	public void test() {
		Polynomial poly = new Polynomial();
		List<LinkedList<Quadruple>> polynomial = new ArrayList<LinkedList<Quadruple>>(); 
		Quadruple x = new Quadruple(3,'x',2,'-');
		Quadruple y = new Quadruple(3,'y',4,'-');
		Quadruple z = new Quadruple(4,'z',2,')');
		poly.createPolynomial(x, 0, polynomial);
		poly.createPolynomial(y, 0, polynomial);
		poly.createPolynomial(z, 1, polynomial);
		assertEquals(6,poly.getHighestDegree(polynomial));
	}

}
