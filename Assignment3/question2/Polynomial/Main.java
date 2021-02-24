import java.util.*;

class Pair {
	private int sizeOfPair = 2;
	private int arr[] = new int[sizeOfPair];
	
	/**
	 * 
	 * @param value1 first value of pair
	 * @param value2 second value of pair
	 * the constructor creates a pair of unrelated values
	 */
	Pair(int value1, int value2){
		arr[0] = value1;
		arr[1] = value2;
	}
	/**
	 * 
	 * @return the first value of the pair
	 */
	public int first(){
		return this.arr[0];
	}
	/**
	 * 
	 * @return the second value of pair
	 */
	public int second(){
		return this.arr[1];
	}
	
}

class Poly {
	private Pair polynomial[];
	private int sizeOfPolynomial;
	/**
	 * 
	 * @param polynomial polynomial entered by the user
	 */
	Poly(Pair polynomial[]){
		this.polynomial = polynomial;
		this.sizeOfPolynomial = this.polynomial.length;
	}
	/**
	 * 
	 * @param arrList list to be converted to array
	 * @return return the list converted into array
	 */
	private Pair[] listToArray(ArrayList<Pair> arrList){
		int sizeOfList = arrList.size();
		Pair arr[] = new Pair[arrList.size()];
		for(int i = 0 ; i < sizeOfList ; i++){
			arr[i] = arrList.get(i);
		}
		return arr;
	}
	/**
	 * 
	 * @param mp map that needs to converted to array of type Pair
	 * @return map converted into a array of type Pair
	 */
	private Pair[] mapToArray(HashMap<Integer, Integer> mp){
		Iterator mpItr = mp.entrySet().iterator();
		ArrayList<Pair> mpToList = new ArrayList<Pair>();
		while(mpItr.hasNext()){
			Map.Entry mapElement = (Map.Entry)mpItr.next(); 
			Pair values = new Pair((int)mapElement.getKey(), (int)mapElement.getValue());
			mpToList.add(values);
		}
		return listToArray(mpToList);
	}
	/**
	 * 
	 * @param value the value at which polynomial's solution needs to be returned
	 * @return the value of polynomial for the given number
	 */
	public float evaluate(float value){
		float valueOfPolynomial = 0;
		for(int i = 0 ; i < sizeOfPolynomial ; i++){
			valueOfPolynomial = (float) (valueOfPolynomial + (Math.pow(value, polynomial[i].first()) * polynomial[i].second()));
		}
		return valueOfPolynomial;
	}
	/**
	 * 
	 * @return degree of polynomial inserted in sorted order of degrees
	 */
	public int degree(){
		return this.polynomial[this.sizeOfPolynomial - 1].first();
	}
	/**
	 * 
	 * @param p1 first polynomial that needs to be added
	 * @param p2 second polynomial that needs to be added
	 * @return returns the summed up polynomial
	 */
	public Poly addPoly(Poly p1, Poly p2){
		ArrayList<Pair> addPolyList = new ArrayList<Pair>();
		for(int i = 0 ; i < Math.max(p1.sizeOfPolynomial, p2.sizeOfPolynomial) ; i++){
			if(i < p1.sizeOfPolynomial && i < p2.sizeOfPolynomial){
				if(p1.sizeOfPolynomial == p2.sizeOfPolynomial){
					int degree = p1.polynomial[i].first();
					int coeff = p1.polynomial[i].second() + p2.polynomial[i].second();
					Pair addedValue = new Pair(degree , coeff);
					addPolyList.add(addedValue);
				}
				else if(p1.polynomial[i].first() > p2.polynomial[i].first()){
					addPolyList.add(p2.polynomial[i]);
					addPolyList.add(p1.polynomial[i]);
				}
				else if(p1.polynomial[i].first() < p2.polynomial[i].first()){
					addPolyList.add(p1.polynomial[i]);
					addPolyList.add(p2.polynomial[i]);
				}
			}
			else if(i < p1.sizeOfPolynomial && i >= p2.sizeOfPolynomial){
				addPolyList.add(p1.polynomial[i]);
			}
			else if(i >= p1.sizeOfPolynomial && i < p2.sizeOfPolynomial) {
				addPolyList.add(p2.polynomial[i]);
			}
		}
		Pair addPolyArr[] = listToArray(addPolyList); 
		Poly addedPoly = new Poly(addPolyArr);
		return addedPoly;
	}
	/**
	 * 
	 * @param p1 polynomial that needs to be multiplied
	 * @param p2 second polynomial that needs to be multiplied
	 * @return return multiplied polynomial
	 */
	public Poly multiplyPoly(Poly p1, Poly p2){
		HashMap<Integer,Integer> multPoly = new HashMap<Integer, Integer>();
		for(int i = 0 ; i < p1.sizeOfPolynomial ; i++) {
			for(int j = 0 ; j < p2.sizeOfPolynomial ; j++){
				int degree = p1.polynomial[i].first() + p2.polynomial[j].first();
				int coeff = p1.polynomial[i].second() * p2.polynomial[j].second();
				if(multPoly.get(degree) == null) {
					multPoly.put(degree, coeff);
				}
				else {
					multPoly.put(degree, multPoly.get(degree)+coeff);
				}
			}
		}
		Poly multipliedPoly = new Poly(mapToArray(multPoly));
		return multipliedPoly;
	}
	/**
	 * prints the polynomial on console
	 */
	public void showPoly(){
		for(int i = 0 ; i < this.sizeOfPolynomial ; i++){
			System.out.println(this.polynomial[i].first()+" "+this.polynomial[i].second()+" ");
		}
	}
	
}

public class Main {

	public static void main(String[] args) {
		Pair p1 = new Pair(2,3);
		Pair p2 = new Pair(1,4);
		Pair p3 = new Pair(0,5);
		Pair p4 = new Pair(2,6);
		Pair p5 = new Pair(1,7);
		Pair p6 = new Pair(0,8);
		Pair[] poly1 = new Pair[3];
		Pair[] poly2 = new Pair[3];
		poly1[0] = p3;
		poly1[1] = p2;
		poly1[2] = p1;
		poly2[0] = p6;
		poly2[1] = p5;
		poly2[2] = p4;
		Poly polynomial1 = new Poly(poly1);
		Poly polynomial2 = new Poly(poly2);
		polynomial1.addPoly(polynomial1,polynomial2).showPoly();
	}

}
