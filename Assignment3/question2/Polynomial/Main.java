


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
