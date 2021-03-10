import java.util.*;

public class StringProcessor {
	private Map<String, List<Character>> cache = new HashMap<String, List<Character>>();
	
	/**
	 * 
	 * @param s string whose unique characters need to be retrieved
	 * @return list consisting of unique characters
	 */
	public List<Character> getUniqueElement(String s){
		if(s.length() == 0){
			assert(false);
		}
		if(cache.get(s) != null){
			return cache.get(s);
		}
		List<Character> unique = new ArrayList<Character>();
		Map<Character, Integer> checkUnique = new HashMap<Character, Integer>();
		for(int i = 0 ; i < s.length() ; i++){
			if(s.charAt(i) == ' '){
				continue;
			}
			if(checkUnique.get(s.charAt(i)) == null){
				checkUnique.put(s.charAt(i), 1);
				continue;
			}
			checkUnique.replace(s.charAt(i), checkUnique.get(s.charAt(i))+1);
		}
		for(Map.Entry<Character, Integer> it : checkUnique.entrySet()){
			if(it.getValue() == 1){
				unique.add(it.getKey());
			}
		}
		cache.put(s, unique);
		return unique;
	}
}
