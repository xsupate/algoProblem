package spatel.algo.backtracking;

import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {

	public static void main(String[] args) {
         String str = "a1b2";
         for (String s : letterCasePermuation(str)) {
 			System.out.println(s);
 		}
	}

	public static List<String> letterCasePermuation(String str){
		LinkedList<String> result = new LinkedList<>();
		result.add(str);
		int len = str.length();
		for(int i = len-1; i >= 0; i--) {
			char ch = str.charAt(i);
			if(Character.isLetter(ch)) {
				int size = result.size();
				for(int j = 0; j < size; j++) {
					String s = result.poll();
					String left = s.substring(0, i);
					String right = s.substring(i+1);
					result.add(left+Character.toLowerCase(ch)+right);
					result.add(left+Character.toUpperCase(ch)+right);
				}
			}
		}
		
		return result;
	}
}
