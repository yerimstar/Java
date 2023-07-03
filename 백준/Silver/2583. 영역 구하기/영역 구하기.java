import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] board;
    static boolean[][] visited;
    static int[][] mv = {{1,0},{0,1},{-1,0},{0,-1}};

    static class Pos{
        private int x;
        private int y;
        public Pos(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[m][n];
        visited = new boolean[m][n];
        int k = Integer.parseInt(st.nextToken());
        for(int i = 0;i < k; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int j = y1; j < y2; j++){
                for(int l = x1; l < x2; l++){
                    board[j][l] = 1;
                }
            }
        }
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < m; i++){
            for(int j = 0;j < n; j++){
                if(!visited[i][j] && board[i][j] == 0){
                    int cnt = bfs(i,j);
                    list.add(cnt);
                    ans++;
                }
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(ans).append("\n");
        for(int i = 0; i < list.size();i++){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }
    private static int bfs(int x, int y){
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(x,y));
        visited[x][y] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            Pos p = q.poll();
            cnt++;
            for(int i = 0;i < 4; i++){
                int dx = p.x + mv[i][0];
                int dy = p.y + mv[i][1];
                if(dx < 0 || dx >= m || dy < 0 || dy >= n)
                    continue;
                if(!visited[dx][dy] && board[dx][dy] == 0){
                    visited[dx][dy] = true;
                    q.offer(new Pos(dx,dy));
                }
            }
        }
        return cnt;
    }
}