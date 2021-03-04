
public class HcfLcm {
	/**
	 * 
	 * @param x larger positive integer for hcf
	 * @param y smaller positive integer for hcf
	 * @return the hcf of x and y
	 */
	public int hcf(int x , int y) {
		if(y == 0){
			return x;
		}
		return hcf(y, x%y);
	}
	/**
	 * 
	 * @param x positive integer for lcm
	 * @param y positive integer for lcm
	 * @return lcm of two numbers
	 */
	public int lcm(int x, int y){
		return (int)((x*y)/hcf(Math.max(x,y),Math.min(x, y)));
	}
}
