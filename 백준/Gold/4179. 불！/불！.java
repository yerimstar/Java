import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];
        Queue<Pos> q1 = new ArrayDeque<>();
        Queue<Pos> q2 = new ArrayDeque<>();
        int[][] dist1 = new int[r][c];
        int[][] dist2 = new int[r][c];

        for(int i = 0;i < r; i++){
            String str = br.readLine();
            for(int j= 0 ; j < c; j++){
                char ch = str.charAt(j);
                map[i][j] = ch;
                dist1[i][j] = -1;
                dist2[i][j] = -1;
                if(ch == 'F'){
                    q1.offer(new Pos(i,j));
                    dist1[i][j] = 0;
                }
                if(ch == 'J'){
                    q2.offer(new Pos(i,j));
                    dist2[i][j] = 0;
                }
            }
        }

        int[][] mv = {{0,1},{1,0},{0,-1},{-1,0}};
        // 불 확산
        while(!q1.isEmpty()){
            Pos p1 = q1.poll();
            for(int i = 0;i < 4; i++){
                int dx = p1.x + mv[i][0];
                int dy = p1.y + mv[i][1];
                if(dx < 0 || dx >= r || dy < 0 || dy >= c)
                    continue;
                if(dist1[dx][dy] >= 0 || map[dx][dy] == '#')
                    continue;
                dist1[dx][dy] = dist1[p1.x][p1.y] + 1;
                q1.offer(new Pos(dx,dy));
            }
        }
        // 지훈 이동
        while(!q2.isEmpty()){
            Pos p2 = q2.poll();
            for(int i = 0;i < 4; i++){
                int dx = p2.x + mv[i][0];
                int dy = p2.y + mv[i][1];
                if (dx < 0 || dx >= r || dy < 0 || dy >= c) {
                    System.out.println(dist2[p2.x][p2.y] + 1);
                    return;
                }
                if(dist2[dx][dy] >= 0 || map[dx][dy] == '#')
                    continue;
                if(dist1[dx][dy] != -1 && dist1[dx][dy] <= dist2[p2.x][p2.y] + 1)
                    continue;

                dist2[dx][dy] = dist2[p2.x][p2.y] + 1;
                q2.offer(new Pos(dx,dy));
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}