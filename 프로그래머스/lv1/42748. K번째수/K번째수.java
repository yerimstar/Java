import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] command : commands) {
        	int[] tmp = Arrays.copyOfRange(array, command[0]-1,command[1]);
            Arrays.sort(tmp);
        	answer[idx++] = tmp[command[2]-1];
        }
        return answer;
    }
}