public class StringOperation {
	/**
	 * 
	 * @param s1 first string to be compared
	 * @param s2 second string to be compared
	 * @return 1 if the strings are equal,
	 * 		   0 in all other cases
	 */
	public int compare(String s1, String s2){
		if(s1 == null || s2 == null){
			System.out.print("Enter a string");
			return -1;
		}
		if(s1.length() != s2.length()){
			return 0;
		}
		for(int i = 0 ; i < s1.length() ; i++){
			if(s1.charAt(i) != s2.charAt(i)){
				return 0;
			}
		}
		return 1;
	}
	/**
	 * 
	 * @param s string that needs to be reversed
	 * @return reversed string
	 */
	public String reverse(String s){
		String reverseString = new String();
		for(int i = 0 ; i < s.length() ; i++){
			reverseString = reverseString + s.charAt(s.length()-i-1);
		}
		return reverseString;
	}
	/**
	 * 
	 * @param s string which needs its case to be inverted
	 * @return string with inverted case
	 */
	public String invertCase(String s) {
		String invertCaseString = new String();
		int asciiA = 65;
		int asciiLowerA = 97;
		int diffBetweenCases = asciiLowerA - asciiA;
		for(int i = 0 ; i < s.length() ; i++){
			if((int) s.charAt(i) <= 90 && (int) s.charAt(i)>=65){
				invertCaseString = invertCaseString + (char) (s.charAt(i)+diffBetweenCases);
			}
			else if((int) s.charAt(i) >= 97 && (int) s.charAt(i) <= 122){
				invertCaseString = invertCaseString + (char)(s.charAt(i) - diffBetweenCases);
			}
			else {
				invertCaseString = invertCaseString + s.charAt(i);
			}
		}
		return invertCaseString;
	}
	/**
	 * 
	 * @param s string in which the largest word needs to be found
	 * @return largest word present in a string
	 */
	public String largestWord(String s){
		int lengthOfWord = 0;
		int maxLength = 0;
		String largestWord = new String();
		String word = new String();
		for(int i = 0 ; i < s.length() ; i++){
			if(i == s.length() - 1 && lengthOfWord+1 >= maxLength){
				largestWord = word + s.charAt(i);
				continue;
			}
			if(s.charAt(i) == ' '){
				if(lengthOfWord >= maxLength){
					largestWord = word;
					maxLength = lengthOfWord;
				}
				lengthOfWord = 0;
				word = "";
				continue;
			}
			lengthOfWord++;
			word = word + s.charAt(i);
		}
		return largestWord;
	}
}
