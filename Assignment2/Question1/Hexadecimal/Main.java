
public class Main {

	public static void main(String[] args) {
		String hexTest = "000F";
		int decTest = 155;
		HexCalc hexCalculator = new HexCalc();
		int ans = hexCalculator.convertToDecimal(hexTest);
		System.out.println(ans);
		System.out.println(hexCalculator.convertFromDecimal(decTest));
	}

}
