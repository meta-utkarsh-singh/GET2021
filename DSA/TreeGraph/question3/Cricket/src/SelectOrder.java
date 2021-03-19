import java.util.*;
public class SelectOrder {
	/**
	 * 
	 * @param arr list representing number of 
	 * 		  balls left to be bowled by each bowler
	 * @param noOfBallsFace no of balls to be faced by batsmen
	 * @param noOfBallers total no of bowlers
	 * @return list of order in which the bowlers bowl
	 */
	public List<Integer> getOrder(List<Integer> arr, int noOfBallsFace, int noOfBallers){
		if(arr.size() == 0){
			return null;
		}
		Collections.sort(arr);
		Collections.reverse(arr);
		int i = 0;
		int sum = arr.get(i);
		List<Integer> ansArr = new ArrayList<Integer>();
		ansArr.add(arr.get(i));
		while(sum < noOfBallsFace){
			i++;
			if(sum < noOfBallsFace && i >= arr.size()){
				return null;
			}
			ansArr.add(arr.get(i));
			sum = sum + arr.get(i);
		}
		return ansArr;
	}
}
