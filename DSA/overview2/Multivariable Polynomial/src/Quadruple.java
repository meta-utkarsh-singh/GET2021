/**
 * 
 * @author utkarsh.singh_metacu
 * 
 * NOTE: PLEASE READ NOTE FOR POLYNOMIAL CLASS BEFORE THIS FOR BETTER UNDERSTANDING.
 * 
 * Each quadruple represents a single variable for 
 * part of the linked list. It defines its coefficient,
 * the variable symbol, power
 * and the next symbol which shows the sign by which the current part
 * of the polynomial is related to the next part
 * 
 */

public class Quadruple {
	private int coeff = 0;
	private char variable;
	private int power;
	private char nextSymbol;
	
	Quadruple(int coeff, char variable, int power, char nextSymbol) {
		this.coeff = coeff;
		this.variable = variable;
		this.power  = power;
		this.nextSymbol = nextSymbol;
	}
	/**
	 * 
	 * @return getter for coeff
	 */
	public int getCoeff(){
		return this.coeff;
	}
	/**
	 * 
	 * @return getter for variable
	 */
	public int getVariable(){
		return this.variable;
	}
	/**
	 * 
	 * @return getter for power
	 */
	public int getPower(){
		return this.power;
	}
	/**
	 * 
	 * @return getter for nextSymbol
	 */
	public int getNextSymbol(){
		return this.nextSymbol;
	}
}
