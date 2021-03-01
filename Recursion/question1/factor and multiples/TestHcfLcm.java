import static org.junit.Assert.*;

import org.junit.Test;


public class TestHcfLcm {

	@Test
	public void testHCF1(){
		int x = 6;
		int y = 9;
		HcfLcm hl = new HcfLcm();
		assertEquals(3, hl.hcf(y, x));
	}
	@Test
	public void testHCF2(){
		int x = 1;
		int y = 0;
		HcfLcm hl = new HcfLcm();
		assertEquals(1, hl.hcf(x, y));
	}
	@Test
	public void testHCF3(){
		int x = 16;
		int y = 4;
		HcfLcm hl = new HcfLcm();
		assertEquals(4, hl.hcf(y, x));
	}
	@Test
	public void testLCM(){
		int x = 6;
		int y = 9;
		HcfLcm hl = new HcfLcm();
		assertEquals(18, hl.lcm(y, x));
	}
}
