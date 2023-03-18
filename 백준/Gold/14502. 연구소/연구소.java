import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pos{
        int x, y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] mv = {{0,1},{1,0},{0,-1},{-1,0}};
    static ArrayList<Pos> posList;
    static int[][] map,copyMap;
    static int n,m,ans;
    static int[] numbers;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        numbers = new int[3];
        posList = new ArrayList<Pos>();
        for(int i = 0;i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num == 0){
                    posList.add(new Pos(i,j));
                }
            }
        }
        perm(0,0);
        System.out.println(ans);
    }
    private static void perm(int cnt, int start){
        // 세울 벽 3개 위치 선택
        if(cnt == 3){
            // 배열 복사
            copyMap = new int[n][m];
            for(int i = 0; i < n; i++){
                copyMap[i] = map[i].clone();
            }
            // 벽 세우기
            for(int num: numbers){
                copyMap[posList.get(num).x][posList.get(num).y] = 1;
            }
            // 바이러스 확산
            visited = new boolean[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(!visited[i][j] && copyMap[i][j] == 2){
                        bfs(i,j);
                    }
                }
            }
            // 안전영역 구하기
            int area = 0;
            for(int i = 0;i < n; i++){
                for(int j = 0; j < m; j++){
                    if(copyMap[i][j] == 0)
                        area+=1;
                }
            }
            ans = Math.max(area,ans);
            return;
        }
        for(int i = start; i < posList.size();i++){
            numbers[cnt] = i;
            perm(cnt+1,i+1);
        }

    }
    private static void bfs(int x, int y){
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(x,y));
        visited[x][y] = true;
        while(!q.isEmpty()){
            Pos cur = q.poll();
            for(int i = 0; i < 4; i++){
                int dx = cur.x + mv[i][0];
                int dy = cur.y + mv[i][1];
                if(dx < 0 || dx >= n || dy < 0 || dy >= m)
                    continue;
                if(!visited[dx][dy] && copyMap[dx][dy] == 0){
                    copyMap[dx][dy] = 2;
                    visited[dx][dy] = true;
                    q.offer(new Pos(dx,dy));
                }
            }

        }
    }
}