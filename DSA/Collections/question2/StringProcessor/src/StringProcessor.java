import java.util.*;

public class StringProcessor {
	private Map<String, Integer> cache = new HashMap<String, Integer>();
	
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
		for(int i = 0 ; i < s.length() ; i++){
			if(!unique.contains(s.charAt(i))){
				unique.add(s.charAt(i));
			}
		}
		cache.put(s, unique.size());
		return unique.size();
	}
}
