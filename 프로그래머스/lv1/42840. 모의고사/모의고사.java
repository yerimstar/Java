import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> solution(int[] answers) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        for(int i = 0; i < answers.length; i++) {
        	if(arr1[i%5] == answers[i]) {
        		cnt1++;
        	}
        	if(arr2[i%8] == answers[i]) {
        		cnt2++;
        	}
        	if(arr3[i%10] == answers[i]) {
        		cnt3++;
        	}
        }
        int[] tmp = {cnt1,cnt2,cnt3};
        int maxNum = 0;
        for(int ans : tmp) {
        	maxNum = Math.max(ans, maxNum);
        }
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
        	if(maxNum == tmp[i-1])
        		lst.add(i);
        }
        return lst;
    }
}