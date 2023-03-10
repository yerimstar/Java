import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int x,y,time;

        public Pos(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "x=" + x +
                    ", y=" + y +
                    ", time=" + time +
                    '}';
        }
    }
    static int n,ansTime;
    static int[][] map;
    static int sharkX,sharkY,sharkSize,eatCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0;i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n;j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num == 9){
                    sharkX = i;
                    sharkY = j;
                    sharkSize = 2;
                    eatCnt = 0;
                    map[i][j] = 0;
                }
            }
        }
        if(nothing()){
            System.out.println(0);
        }else {
            bfs();
            System.out.println(ansTime);
        }
    }
    private static void bfs(){
        int[][] mv = {{0,1},{1,0},{0,-1},{-1,0}};
        PriorityQueue<Pos> q = new PriorityQueue<>(new Comparator<Pos>() {
            @Override
            public int compare(Pos o1, Pos o2) {
                if(o1.time == o2.time){
                    if (o1.x == o2.x)
                        return o1.y - o2.y;
                    return o1.x - o2.x;
                }
                return o1.time-o2.time;
            }
        });

        Pos cur = null;
        boolean sharkChanged = true;
        while(sharkChanged){
            if(nothing())
                return;
            boolean[][] visited = new boolean[n][n];
            q.offer(new Pos(sharkX,sharkY,0));
            visited[sharkX][sharkY] = true;
            sharkChanged = false;

            while(!q.isEmpty()){
                cur = q.poll();
                // ????????? ???????????? ????????????
                if(map[cur.x][cur.y] < sharkSize && map[cur.x][cur.y] != 0){
                    eatCnt += 1;
                    ansTime += cur.time; // ???????????? ???????????? ?????? ??????

                    // ?????? ?????? ??????
                    if(sharkSize == eatCnt){
                        sharkSize += 1;
                        eatCnt = 0;
                    }

                    // ???????????? ??????
                    sharkX = cur.x;
                    sharkY = cur.y;
                    map[cur.x][cur.y] = 0;
                    q.clear();
                    sharkChanged = true;
                    break;
                }

                for(int i = 0; i < 4; i++){
                    int dx = cur.x + mv[i][0];
                    int dy = cur.y + mv[i][1];
                    // ?????? ???????????? continue
                    if(dx < 0 || dx >= n || dy < 0 || dy >= n)
                        continue;
                    // ?????? ????????? ???????????? ?????????, ???????????? ???????????? ????????? ????????? ?????? ??????
                    if(!visited[dx][dy] && map[dx][dy] <= sharkSize){
                        visited[dx][dy] = true;
                        q.offer(new Pos(dx,dy,cur.time+1));
                    }
                }
            }
        }
    }
    private static boolean nothing(){
        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sum += map[i][j];
            }
        }
        if(sum == 0){
            return true;
        }
        return false;
    }
}