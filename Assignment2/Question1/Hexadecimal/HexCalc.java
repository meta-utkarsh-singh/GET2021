import java.util.*;

class HexCalc implements BaseConverter {
	private List<Character> hexLiterals = new ArrayList<Character>();
	private double baseHex = 16;
	private int baseDecimal = 10;
	private int asciiA = 65;
	/**
	 * sets the mapping of hex literals to
	 * A-F for numbers from 10-15
	 */
	HexCalc(){
		int ascii = asciiA;
		int noOfHexLiterals = 6;
		for(int i = 0; i<noOfHexLiterals ; i++){
			hexLiterals.add(i, (char)ascii);
			ascii++;
		}
	}
	public int convertToDecimal(String number){
		StringBuilder hexNumber = new StringBuilder();
		hexNumber.append(number);
		hexNumber.reverse();
		String reverseHexNumber = hexNumber.toString();
		int hexToDecimal = 0;
		double power = 0;
		for(int i = 0; i<reverseHexNumber.length() ; i++){
			char digit = reverseHexNumber.charAt(i);
			if(Character.digit(digit, baseDecimal)>=0 && Character.digit(digit, baseDecimal)<=9){
				int digitInteger = Character.digit(digit, baseDecimal);
				hexToDecimal = (int) (hexToDecimal + Math.pow(baseHex, power)*digitInteger);
			}
			else{
				int digitInteger = (digit-asciiA)+10;
				hexToDecimal = (int) (hexToDecimal + Math.pow(baseHex, power)*digitInteger);
			}
			power++;
		}
		return hexToDecimal;
	}
	public String convertFromDecimal(int number){
		int decimalNumber = number;
		Integer remainder = 0;
		StringBuilder decToHex = new StringBuilder();
		while(decimalNumber!=0){
			remainder = (int)(decimalNumber % baseHex);
			if(remainder<=9 && remainder>=0){
				decToHex.append(remainder.toString());
			}
			else{
				decToHex.append(hexLiterals.get(remainder-10));
			}
			decimalNumber = (int) (decimalNumber / baseHex);
		}
		return decToHex.reverse().toString();
	}
	public String addNumbers(String number1, String number2){
		Integer number1Integer = convertToDecimal(number1);
		Integer number2Integer = convertToDecimal(number2);
		Integer sum = number1Integer+number2Integer;
		String sumOfNumbers = convertFromDecimal(sum); 
		return sumOfNumbers;
	}
	public String multNumbers(String number1, String number2){
		Integer number1Integer = convertToDecimal(number1);
		Integer number2Integer = convertToDecimal(number2);
		Integer mult = number1Integer*number2Integer;
		String multOfNumbers = convertFromDecimal(mult); 
		return multOfNumbers;
	}
	public String subtractNumbers(String number1, String number2){
		Integer number1Integer = convertToDecimal(number1);
		Integer number2Integer = convertToDecimal(number2);
		Integer difference = Math.abs(number1Integer-number2Integer);
		String differenceOfNumbers = convertFromDecimal(difference); 
		return differenceOfNumbers;
	}
	public String divNumbers(String number1, String number2){
		Integer number1Integer = convertToDecimal(number1);
		Integer number2Integer = convertToDecimal(number2);
		Integer larger = Math.max(number1Integer,number2Integer);
		Integer smaller = Math.min(number1Integer,number2Integer);
		Integer division = larger/smaller;
		String divisionOfNumbers = convertFromDecimal(division);
		return divisionOfNumbers;
	}
	public boolean largerNumber(String number1, String number2){
		if(number1.compareTo(number2)==1){
			return true;
		}
		return false;
	}
	public boolean smallerNumber(String number1, String number2){
		if(number1.compareTo(number2)==-1){
			return true;
		}
		return false;
	}
	public boolean equalNumber(String number1, String number2){
		if(number1.compareTo(number2)==0){
			return true;
		}
		return false;
	}
}
