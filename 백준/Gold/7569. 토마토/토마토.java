import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Tomato{
        int z,x, y, day;
        public Tomato(int z, int x, int y, int day){
            this.z = z;
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
    static int[][][] map;
    static boolean[][][] visited;
    static int n,m,h,tomatoCnt;
    static Queue<Tomato> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][n][m];
        visited = new boolean[h][n][m];
        q = new ArrayDeque<>();
        for(int i = 0;i < h; i++){
            for(int j = 0; j < n;j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++){
                    int num = Integer.parseInt(st.nextToken());
                    map[i][j][k] = num;
                    if(num == 0){ // 익지 않은 토마토 개수
                        tomatoCnt++;
                    }else if(num == 1){
                        q.offer(new Tomato(i,j,k,0));
                        visited[i][j][k] = true;
                    }
                }
            }
        }
        // 모든 토마토가 익어있는 상태
        if(tomatoCnt == 0){
            System.out.println(0);
        }else{
            int ans = bfs();
            if(tomatoCnt > 0){
                System.out.println(-1);
            }else {
                System.out.println(ans);
            }
        }
    }
    private static int bfs(){
        int cnt = 0;
        int[][] mv = {{-1,0,0},{1,0,0},{0,-1,0},{0,1,0},{0,0,-1},{0,0,1}};

        while(!q.isEmpty()){
            Tomato cur = q.poll();
            cnt = Math.max(cur.day,cnt);
            for(int i = 0;i < 6; i++){
                int dz = cur.z + mv[i][0];
                int dx = cur.x + mv[i][1];
                int dy = cur.y + mv[i][2];
                if(dz < 0 || dz >= h || dx < 0 || dx >= n || dy < 0 || dy >= m)
                    continue;
                if(!visited[dz][dx][dy] && map[dz][dx][dy] == 0){
                    visited[dz][dx][dy] = true;
                    q.offer(new Tomato(dz,dx,dy,cur.day+1));
                    tomatoCnt--;
                }
            }
        }
        return cnt;
    }
}