import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r,c,ans;
    static boolean[] alpha;
    static int[][] map;
    static int[][] mv = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        alpha = new boolean[26]; // 'A' ~ 'Z' ( 알파벳 방문처리 )
        for(int i = 0; i < r; i++){
            char[] cLst = br.readLine().toCharArray();
            for(int j = 0; j < c; j++){
                map[i][j] = cLst[j]-65;
            }
        }
        alpha[map[0][0]] = true;
        dfs(0,0,1);
        System.out.println(ans);
    }

    private static void dfs(int x, int y, int cnt){
        ans = Math.max(ans,cnt); // 최댓값 갱신
        for(int i = 0; i < 4; i++){
            int dx = x + mv[i][0];
            int dy = y + mv[i][1];
            if(0 <= dx && dx < r && 0 <= dy && dy < c) {
                if (!alpha[map[dx][dy]]) {
                    alpha[map[dx][dy]] = true;
                    dfs(dx, dy, cnt + 1);
                    alpha[map[dx][dy]] = false;
                }
            }
        }
    }
}