import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> lst = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++){
            q.offer((int) Math.ceil((100.0-progresses[i])/speeds[i]));
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            int cnt = 1;
            while(!q.isEmpty() && cur >= q.peek()){
                cnt++;
                q.poll();
            }
            lst.add(cnt);
        }
        return lst;
    }
}