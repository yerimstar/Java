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
    static int[][] mv = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc < t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            char[][] map = new char[h][w];
            int[][] visitedf = new int[h][w];
            for(int i = 0;i < h;i++){
                Arrays.fill(visitedf[i],-1);
            }
            int[][] visiteds = new int[h][w];
            for(int i = 0;i < h;i++){
                Arrays.fill(visiteds[i],-1);
            }
            Queue<Pos> fire = new ArrayDeque<>();
            Queue<Pos> sg = new ArrayDeque<>();
            for(int i = 0;i < h; i++){
                String str = br.readLine();
                for(int j = 0;j < w; j++){
                    char c = str.charAt(j);
                    if(c == '*'){
                        fire.offer(new Pos(i,j));
                        visitedf[i][j] = 0;
                    }else if(c == '@'){
                        sg.offer(new Pos(i,j));
                        visiteds[i][j] = 0;
                    }
                    map[i][j] = c;
                }
            }
            int ans = 0;
            // 불 이동
            while(!fire.isEmpty()){
                Pos p = fire.poll();
                for(int i = 0;i < 4; i++){
                    int dx = p.x + mv[i][0];
                    int dy = p.y + mv[i][1];
                    if(dx < 0 || dx >= h || dy < 0 || dy >= w)
                        continue;
                    // 방문했거나, 벽이거나, 불인 경우 넘어감
                    if(visitedf[dx][dy] >= 0 || map[dx][dy] == '#')
                        continue;
                    visitedf[dx][dy] = visitedf[p.x][p.y] + 1;
                    fire.offer(new Pos(dx,dy));
                }
            }

            // 상근이 이동
            boolean flag = true;
            while(!sg.isEmpty()){
                Pos p = sg.poll();
                for(int i = 0;i < 4; i++){
                    int dx = p.x + mv[i][0];
                    int dy = p.y + mv[i][1];
                    // 탈출
                    if(dx < 0 || dx >= h || dy < 0 || dy >= w){
                        sb.append(visiteds[p.x][p.y] + 1).append("\n");
                        flag = false;
                        break;
                    }
                    if(visiteds[dx][dy] >= 0 || map[dx][dy] == '#')
                        continue;
                    if(visitedf[dx][dy] != -1 && visitedf[dx][dy] <= visiteds[p.x][p.y] + 1)
                        continue;

                    visiteds[dx][dy] = visiteds[p.x][p.y] + 1;
                    sg.offer(new Pos(dx,dy));

                }
                if(!flag){
                    break;
                }
            }
            if(flag){
                sb.append("IMPOSSIBLE").append("\n");
            }
        }
        System.out.println(sb);
    }
}