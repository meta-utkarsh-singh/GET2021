import java.util.*;

/**
 * 
 * @author utkarsh.singh_metacu
 * 
 * Note: This class is used for creating a polynomial
 * 		 and getting the highest degree of polynomial.
 * 		 A list of linked list is used for representing the multivariate polynomial.
 * 		 Each index of list represents individual parts of coefficient, 
 * 		 for example: For list 3x(y^4)+(z^2)+20
 * 		 			  index 0 of list represents the part 
 * 					  (3x(y^4)) using linked list
 * 					  index 1 represents the the part (z^2) 
 * 					  using linked list and so on.
 * 		 Each of these parts is stored in a Quadruple
 */
public class Polynomial {
	/**
	 * 
	 * @param q coefficient to be added
	 * @param indexForQuadruple index at which the coefficient is added
	 * @param polynomial polynomial in which it needs to be added
	 */
	public void createPolynomial(Quadruple q, int indexForQuadruple, List<LinkedList<Quadruple>>polynomial) {
		polynomial.get(indexForQuadruple).addLast(q);
	}
	/**
	 * 
	 * @param polynomial list of linked list representing a multivariate polynomial
	 * @return the maximum degree of multivariate polynomial
	 */
	public int getHighestDegree(List<LinkedList<Quadruple>>polynomial){
		int maxDegree = 0;
		int sumOfPower = 0;
		for(int i = 0 ; i < polynomial.size() ; i++){
			LinkedList<Quadruple> llAtI = polynomial.get(i);
			sumOfPower = 0;
			for(int j = 0 ; j < llAtI.size() ; j++){
				sumOfPower = sumOfPower + llAtI.get(j).getPower();
			}
			maxDegree = Math.max(sumOfPower, maxDegree);
		}
		return maxDegree;
	}
}
