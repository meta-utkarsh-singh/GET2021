import java.util.*;

public class InfixEvaluate {
	private String arr;
	private Stack<Integer> value = new Stack<Integer>();
	private Stack<String> symbols = new Stack<String>();
	
	InfixEvaluate(String arr){
		this.arr = arr;
	}
	/**
	 * 
	 * @param number number in string to be converted to integer
	 * @return returns string number in integer type
	 */
	private int convertToInt(String number){
		int numberInt = Integer.parseInt(number);
		return numberInt;
	}
	/**{
	 * 
	 * @param op operator to be applied
	 * @param a left value
	 * @param b right value
	 * @return returns result based on operator
	 */
	private int getEvaluation(String op, int b, int a){
		switch(op){
		case "+":
			return a+b;
		case "-":
			return a-b;
		case "*":
			return a*b;
		case "/":
			return a/b;
		case ">":
			if(a>b){
				return 1;
			}
			else{
				return 0;
			}
		case "<":
			if(a<b){
				return 1;
			}
			else{
				return 0;
			}
		case "&":
			return a&b;
		case "|":
			return a | b;
		}
		if(op.compareTo(">=") == 0){
			if(a>=b){
				return 1;
			}
			else{
				return 0;
			}
		}
		else if(op.compareTo("<=") == 0){
			if(a<=b){
				return 1;
			}
			else {
				return 0;
			}
		}
		else if(op.compareTo("==") == 0){
			if(a==b){
				return 1;
			}
			else{
				return 0;
			}
		}
		else if(op.compareTo("!=") == 0){
			if(a!=b){
				return 1;
			}
			else{
				return 0;
			}
		}
		return -1;
	}
	/**
	 * 
	 * @param op1 operator 1 whose precedence is to be checked
	 * @param op2 operator 2 whose precedence is to be checked
	 * @return true of op2 has higher precedence then op1
	 * 		   false in other cases
	 */
	public boolean higherPrec(String op1, String op2){
		if((op1 == "(" || op1==")")){
			return false;
		}
		else if((op1 == "*" || op1 == "/") && (op2=="+" || op2=="-" 
				|| op2 == "==" || op2=="&&" || op2=="||" || op2=="!=" ||
				op2 == ">=" || op2 == "<=" || op2=="&" || op2=="|" || op2 == "!="
				|| op2 == "<" || op2==">" || op2 == "*" || op2 == "/")){
			return false;
		}
		else if((op1 == "+" || op1 == "-") && (op2 == "==" || op2=="&&"
				|| op2=="||" || op2 == "!=" || op2 == ">=" || op2 == "<="
				|| op2=="&" || op2=="|" || op2=="!=" || op2 == "<" || op2==">"
				|| op2 == "+" || op2 == "-")){
			return false;
		}
		else if((op1 == "==" || op1 == "!=") && (op2=="&&"
				|| op2=="||" || op2 == "!=" || op2 == ">=" || op2 == "<="
				|| op2=="&" || op2=="|" || op2 == "<" || op2==">"
				|| op2 == "==" || op2 == "!=")){
			return false;
		}
		else if((op1 == "==" || op1 == "!=") && (op2=="&&"
				|| op2=="||" || op2 == "!=" || op2 == ">=" || op2 == "<="
				|| op2=="&" || op2=="|" || op2 == "<" || op2==">"
				|| op2 == "==" || op2 == "!=")){
			return false;
		}
		else if((op1 == "<" || op1 == ">" || op1=="<=" || op1==">=") && (op2=="&&"
				|| op2=="||" || op2=="&" || op2=="|"
				|| op2 == "<" || op2 == ">" || op2=="<=" || op2==">=")){
			return false;
		}
		else if((op1 == "&") && (op2=="&&"
				|| op2=="||" || op2=="|"
				|| op2 == "&")){
			return false;
		}
		else if((op1 == "|") && (op2=="&&"
				|| op2=="||" || op2 == "|")){
			return false;
		}
		else if((op1 == "&&") && (op2=="||" || op2 == "&&")){
			return false;
		}
		return true;
	}
	/**
	 * 
	 * @return final evaluated value of the expression
	 */
	public int evaluate(){
		for(int i = 0 ; i < this.arr.length() ; i++){
			if(arr.charAt(i) == ' ' ){
				continue;
			}
			if(arr.charAt(i) >= '0' && arr.charAt(i)<='9'){
				String fullNumber = new String();
				char digit = arr.charAt(i);
				int j = i;
				while(digit != ' ' && digit != ')' && j<this.arr.length()){
					fullNumber = fullNumber+arr.charAt(j);
					j++;
					digit = arr.charAt(j);
				}
				value.push(convertToInt(fullNumber));
			}
			else if(arr.charAt(i) == '('){
				symbols.push("(");
			}
			else if(arr.charAt(i) == ')'){
				while(symbols.peek() != "("){
					value.push(getEvaluation(symbols.pop(),value.pop(),value.pop()));
				}
				symbols.pop();
			}
			else{
				if(symbols.empty() || symbols.peek()=="("){
					String op = new String();
					while(arr.charAt(i)!=' ' && i<arr.length()-1){
						op = op + arr.charAt(i);
						i++;
					}
					symbols.push(op);
					continue;
				}
				String op = new String();
				while(arr.charAt(i)!=' ' && i<arr.length()-1){
					op = op + arr.charAt(i);
					i++;
				}
				while(!symbols.empty() && higherPrec(op, symbols.peek()) && symbols.peek()!="("){
					value.push(getEvaluation(symbols.pop(),value.pop(),value.pop()));
				}
				symbols.push(op);
			}
		}
		while(!symbols.empty()){
			value.push(getEvaluation(symbols.pop(),value.pop(),value.pop()));
		}
		if(value.size() == 0){
			return 0;
		}
		return value.pop();
	}
}
