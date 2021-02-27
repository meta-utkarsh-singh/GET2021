
public class Main {

	public static void main(String[] args) {
		String hexTest = "F";
		String hexTest1 = "000F";
		int decTest = 155;
		HexCalc hexCalculator = new HexCalc();
		int ans = hexCalculator.convertToDecimal(hexTest);
		System.out.println(ans);
		System.out.println(hexCalculator.convertFromDecimal(decTest));
		System.out.println(hexCalculator.largerNumber(hexTest1, hexTest));
		System.out.println(hexCalculator.smallerNumber(hexTest, hexTest1));
		System.out.println(hexCalculator.equalNumber(hexTest, hexTest1));
	}

}
