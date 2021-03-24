
public class Pair {
	private int bowlerNo;
	private int noOfBalls;
	
	Pair(int bowlerNo, int noOfBalls) {
		this.bowlerNo = bowlerNo;
		this.noOfBalls = noOfBalls;
	}
	/**
	 * 
	 * @return getter for bowlerNo
	 */
	public int getBowlerNo(){
		return this.bowlerNo;
	}
	/**
	 * 
	 * @return getter for noOfBalls
	 */
	public int getNoOfBalls(){
		return this.noOfBalls;
	}
	/**
	 * 
	 * @param noOfBalls value of no of balls for setter
	 */
	public void set(int noOfBalls) {
		this.noOfBalls = noOfBalls;
	}
}
