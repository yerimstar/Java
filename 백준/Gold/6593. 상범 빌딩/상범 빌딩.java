import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int l,r,c,sx,sy,sz,ex,ey,ez;
    static char[][][] map;
    static int[][][] visited;
    static int[][] mv = {{-1,0,0},{1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
    static class Pos{
        private int x;
        private int y;
        private int z;
        public Pos(int x, int y,int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken()); // 층
            r = Integer.parseInt(st.nextToken()); // 행
            c = Integer.parseInt(st.nextToken()); // 열

            if(l == 0 && r == 0 && c == 0){
                break;
            }

            map = new char[l][r][c];
            visited = new int[l][r][c];

            for(int i = 0; i < l; i++){
                for(int j = 0;j < r; j++){
                    String str = br.readLine();
                    for(int k = 0; k < c; k++){
                        char ch = str.charAt(k);
                        map[i][j][k] = ch;
                        if(ch == 'S'){
                            sx = i;
                            sy = j;
                            sz = k;
                        }
                        if(ch == 'E'){
                            ex = i;
                            ey = j;
                            ez = k;
                        }
                    }
                }
                br.readLine();
            }

            int time = bfs();
            if(time == -1){
                sb.append("Trapped!").append("\n");
            }else{
                sb.append("Escaped in ").append(time).append(" minute(s).").append("\n");
            }
        }
        System.out.println(sb);
    }
    private static int bfs(){
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(sx,sy,sz));
        while(!q.isEmpty()){
            Pos p = q.poll();
            // 탈출
            if(p.x == ex && p.y == ey && p.z == ez){
                return visited[p.x][p.y][p.z];
            }
            for(int i = 0;i < 6; i++){
                int dx = p.x + mv[i][0];
                int dy = p.y + mv[i][1];
                int dz = p.z + mv[i][2];
                if(dx < 0 || dx >= l || dy < 0 || dy >= r || dz < 0 || dz >= c)
                    continue;
                if(visited[dx][dy][dz] == 0){
                    if(map[dx][dy][dz] == '.' || map[dx][dy][dz] == 'E'){
                        visited[dx][dy][dz] = visited[p.x][p.y][p.z] + 1;
                        q.offer(new Pos(dx,dy,dz));
                    }
                }
            }
        }
        return -1;
    }
}