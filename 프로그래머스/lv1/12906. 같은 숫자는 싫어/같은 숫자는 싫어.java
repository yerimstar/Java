import java.util.*;

public class Solution {
   public static Stack<Integer> solution(int[] arr) {
		Stack<Integer> s = new Stack<>();
		for(int num : arr) {
			if(s.isEmpty()) {
				s.push(num);
			}else {
				if(s.peek() != num) {
					s.push(num);
				}
			}
		}
		return s;
	}
}