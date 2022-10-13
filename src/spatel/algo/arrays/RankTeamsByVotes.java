package spatel.algo.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In a special ranking system, each voter gives a rank from highest to lowest to all teams participated in the 
 * competition. The ordering of teams is decided by who received the most position-one votes. If two or more teams
 * tie in the first position, we consider the second position to resolve the conflict, if they tie again, we 
 * continue this process until the ties are resolved. If two or more teams are still tied after considering all 
 * positions, we rank them alphabetically based on their team letter.
 *
 * Given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according
 * to the ranking system described above.

 * Return a string of all teams sorted by the ranking system.
 * 
 * Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
 * Output: "ACB"
 * Explanation: 
 * Team A was ranked first place by 5 voters. No other team was voted as first place so team A is the first team.
 * Team B was ranked second by 2 voters and was ranked third by 3 voters.
 * Team C was ranked second by 3 voters and was ranked third by 2 voters.
 * As most of the voters ranked C second, team C is the second team and team B is the third. 
 *
 */
public class RankTeamsByVotes {
	
	public static void main(String[] args) {
		String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
		System.out.println(rankTeams(votes));
	}
   
	public static String rankTeams(String[] votes) {
		int len = votes[0].length();
		Map<Character, int[]> hash = new HashMap<>();
		for( String vote : votes) {
			for(int i = 0; i < len; i++) {
				char ch = vote.charAt(i);
				if(hash.get(ch) == null) {
					hash.put(ch, new int[len]);
				}
				hash.get(ch)[i]++;
			}
		}
		
		List<Character> list = new ArrayList<>();
		for(char ch : hash.keySet())
			list.add(ch);
		
		Collections.sort(list, (c1, c2)->{
			for(int i = 0; i < len; i++) {
				if(hash.get(c1)[i] != hash.get(c2)[i])
					return hash.get(c2)[i] - hash.get(c1)[i];
			}
			return c1-c2;
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < len; i++)
			sb.append(list.get(i));
		
		return sb.toString();
	}
}
