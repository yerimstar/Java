import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
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
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        // 입력
        for(int i = 0;i < n; i++){
            String str = br.readLine();
            for(int j = 0;j < n; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        int ans = 0; // 단지수
        ArrayList<Integer> house = new ArrayList<>(); // 집의 수
        for(int i = 0;i < n; i++){
            for(int j = 0;j < n; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    int cnt = bfs(i,j);
                    house.add(cnt);
                    ans++;
                }
            }
        }
        Collections.sort(house);
        StringBuilder sb = new StringBuilder();
        sb.append(ans).append("\n");
        for(int i = 0;i < house.size();i++){
            sb.append(house.get(i)).append("\n");
        }
        System.out.println(sb);
    }
    private static int bfs(int x, int y){
        int cnt = 0;
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(x,y));
        visited[x][y] = true;
        while(!q.isEmpty()){
            Pos p = q.poll();
            cnt++;
            for(int i = 0;i < 4; i++){
                int dx = p.x + mv[i][0];
                int dy = p.y + mv[i][1];
                if(dx < 0 || dx >= n || dy < 0 || dy >= n)
                    continue;
                if(!visited[dx][dy] && map[dx][dy] == 1){
                    q.offer(new Pos(dx,dy));
                    visited[dx][dy] = true;
                }
            }
        }
        return cnt;
    }
}