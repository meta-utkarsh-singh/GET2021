package com.get.formulaEvaluator;
import java.util.*;

public class ChemicalMassCalculator {
	private int massO = 16;
	private int massH = 1;
	private int massC = 12;
	/**
	 * 
	 * @param s chemical formula
	 * @return mass of the given chemical
	 */
	public int getMass(String s){
		Stack<Integer> st = new Stack<Integer>();
		if(s.length() == 0){
			assert(false);
		}
		int sumInBracket = 0;
		int totalMass = 0;
		for(int i = 0 ; i < s.length(); i++){
			if(s.charAt(i) == 'C'){
				st.push(massC);
			}
			else if(s.charAt(i) == 'O'){
				st.push(massO);
			}
			else if(s.charAt(i) == 'H'){
				st.push(massH);
			}
			else if(s.charAt(i) == '('){
				st.push(-1);
			}
			else if(s.charAt(i) == ')'){
				sumInBracket = 0;
				while(st.peek() != -1){
					sumInBracket = sumInBracket + st.pop();
				}
				st.pop();
				st.push(sumInBracket);
			}
			else if(s.charAt(i)<='9' && s.charAt(i)>='0'){
				String number = ""+s.charAt(i);
				int j = i+1;
				while(j<s.length()){
					if(s.charAt(j)!='C' || s.charAt(j)!='O' 
						|| s.charAt(j)!='H' || s.charAt(j) == '('
						|| s.charAt(j) == ')'){
						break;
					}
					number = number+s.charAt(j);
					j++;
				}
				int massMultiplier = Integer.parseInt(number);
				int totalMassCurrentElement = st.pop()*massMultiplier;
				st.push(totalMassCurrentElement);
			}
			else {
				assert(false);
			}
		}
		while(!st.isEmpty()){
			totalMass = totalMass + st.pop();
		}
		return totalMass;
	}
}
