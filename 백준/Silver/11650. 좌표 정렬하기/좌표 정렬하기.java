import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pos{
        private int x;
        private int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Pos> pq = new PriorityQueue<>(new Comparator<Pos>() {
            @Override
            public int compare(Pos o1, Pos o2) {
                if(o1.x==o2.x){
                    return o1.y-o2.y;
                }
                return o1.x-o2.x;
            }
        });
        for(int i = 0;i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pos p = pq.poll();
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }
        System.out.println(sb);
    }

}