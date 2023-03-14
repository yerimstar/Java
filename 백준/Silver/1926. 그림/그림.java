import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int x,y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0;i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans1 = 0;
        int ans2 = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0; j < m;j++){
                if(!visited[i][j] && map[i][j] == 1){
                    visited[i][j] = true;
                    ans1 = Math.max(ans1,bfs(i,j));
                    ans2++;
                }
            }
        }
        sb.append(ans2).append("\n").append(ans1);
        System.out.println(sb);
    }
    private static int bfs(int x, int y){
        int[][] mv = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(x,y));
        int cnt = 1;
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int i = 0; i < 4; i++){
                int dx = cur.x + mv[i][0];
                int dy = cur.y + mv[i][1];
                if(dx < 0 || dx >= n || dy < 0 || dy >= m)
                    continue;
                if(!visited[dx][dy] && map[dx][dy] == 1){
                    visited[dx][dy] = true;
                    q.offer(new Node(dx,dy));
                    cnt++;
                }
            }
        }
        return cnt;
    }
}