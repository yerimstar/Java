import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Num{
        private long val;
        private int cnt;

        public Num(long val, int cnt){
            this.val = val;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int ans = bfs(a,b);
        System.out.println(ans);
    }
    private static int bfs(int a, int b){
        Queue<Num> q = new ArrayDeque<>();
        q.offer(new Num(a,1));
        while(!q.isEmpty()){
            Num n = q.poll();
            int cnt = n.cnt + 1;
            long val1 = n.val * 2;
            long val2 = n.val * 10 + 1;
            if (val1 == b || val2 == b) {
                return cnt;
            }
            if (val1 < b) {
                q.offer(new Num(val1, cnt));
            }
            if (val2 < b) {
                q.offer(new Num(val2,cnt));
            }
        }
        return -1;
    }
}