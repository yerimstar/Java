import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int answer = set.size() >= n/2 ? n/2 : set.size();
        return answer;
    }
}