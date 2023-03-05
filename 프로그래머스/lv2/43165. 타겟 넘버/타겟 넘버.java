import java.util.*;

class Solution {
    static class Num {
        int x;
        int idx;

        public Num(int x, int idx) {
            this.x = x;
            this.idx = idx;
        }
    }
    public int solution(int[] numbers, int target) {
        int ans = 0;
        Queue<Num> q = new ArrayDeque<>();
        q.offer(new Num(numbers[0], 0));
        q.offer(new Num(-numbers[0], 0));

        while (!q.isEmpty()) {
            Num cur = q.poll();
            if (cur.idx == numbers.length - 1) {
                if (cur.x == target) {
                    ans++;
                }
            } else {
                q.offer(new Num(cur.x + numbers[cur.idx + 1], cur.idx + 1));
                q.offer(new Num(cur.x - numbers[cur.idx + 1], cur.idx + 1));
            }
        }
        return ans;
    }
}