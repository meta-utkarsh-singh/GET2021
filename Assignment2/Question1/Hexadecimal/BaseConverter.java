
interface BaseConverter {
	/**
	 * 
	 * @param number
	 * number : requires positive integer to be converted to decimal
	 * @return number in base 10
	 */
	int convertToDecimal(String number);
	
	/**
	 * 
	 * @param number
	 * requires : positive integer in base 10
	 * @return number in the required base
	 */
	String convertFromDecimal(int number);
	/**
	 * 
	 * @param number1
	 * 			requires: positive integer to be added
	 * @param number2
	 * 			requires: positive integer to be added
	 * @return  
	 * 		return: the sum of positive integers in the required base
	 */
	String addNumbers(String number1, String number2);
	/**
	 * 
	 * @param number1
	 * 			requires: positive integer to be subtracted
	 * @param number2
	 * 			requires: positive integer to be subtracted
	 * @return  
	 * 		return: the absolute difference between positive integers in the required base
	 */
	String subtractNumbers(String number1, String number2);
	/**
	 * 
	 * @param number1
	 * 			requires: positive integer to be multiplied
	 * @param number2
	 * 			requires: positive integer to be multiplied
	 * @return  
	 * 		return: the product of positive integers in the required base
	 */
	String multNumbers(String number1, String number2);
	/**
	 * 
	 * @param number1
	 * 			requires: positive integer to be divided
	 * @param number2
	 * 			requires: positive integer to be divided
	 * @return  
	 * 		return: the division of larger positive integer by the 
	 *              smaller positive integer in the required base
	 */
	String divNumbers(String number1, String number2);
	/**
	 * 
	 * @param number1
	 * 			requires: positive integer to be compared
	 * @param number2
	 * 			requires: positive integer to be compared
	 * @return
	 * 			return: returns true if number1 is greater than number2
	 */
	boolean largerNumber(String number1, String number2);
	/**
	 * 
	 * @param number1
	 * 			requires: positive integer to be compared
	 * @param number2
	 * 			requires: positive integer to be compared
	 * @return
	 * 			return: returns true if number1 is smaller than number2
	 */
	boolean smallerNumber(String number1, String number2);
	/**
	 * 
	 * @param number1
	 * 			requires: positive integer to be compared
	 * @param number2
	 * 			requires: positive integer to be compared
	 * @return
	 * 			return: returns true if number1 equals number2
	 */
	boolean equalNumber(String number1, String number2);
}
