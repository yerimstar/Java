import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m,k;
    static int result = Integer.MAX_VALUE;
    static int[][] arrLst,rotateLst;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arrLst = new int[n+1][m+1];

        for(int i =1;  i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++) {
                arrLst[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotateLst = new int[k][3];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            rotateLst[i][0] = r;
            rotateLst[i][1] = c;
            rotateLst[i][2] = s;
        }
        boolean[] visited = new boolean[k];
        int[] selected = new int[k];
        perm(0,selected,visited);
        System.out.println(result);

    }
    private static void perm(int cnt,int[] selected, boolean[] visited){
        if(cnt == k){
            int[][] copyArr = new int[n+1][m+1]; // 복사
            for(int i = 1; i <= n; i++){
                for(int j =1; j <= m; j++){
                    copyArr[i][j] = arrLst[i][j];
                }
            }
            for(int i = 0; i < k; i++){
                int idx = selected[i];
                rotateArray(copyArr, rotateLst[idx][0],rotateLst[idx][1],rotateLst[idx][2]);
            }

            for(int i = 1; i <= n; i++){
                int tmp = 0;
                for(int j = 1; j <= m; j++){
                    tmp += copyArr[i][j];
                }
                result = Math.min(tmp,result);
            }
        }
        for(int i = 0; i < k; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[cnt] = i;
                perm(cnt+1, selected,visited);
                visited[i] = false;
            }
        }
    }

    private static void rotateArray(int[][] copyArr, int r, int c, int s) {
        int sx = r-s;
        int sy = c-s;
        int ex = r + s;
        int ey = c + s;
        int[][] mv = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i = 0; i < s; i++){
            int x = sx + i;
            int y = sy + i;
            int tmp = copyArr[x][y];
            int change = 0;
            while(change < 4){
                int dx = x + mv[change][0];
                int dy = y + mv[change][1];
                if(sx+i <= dx && dx <= ex-i && sy + i <= dy && dy <= ey - i){
                    copyArr[x][y] = copyArr[dx][dy];
                    x = dx;
                    y = dy;
                }else{
                    change++;
                }
            }
            copyArr[x][y+1] = tmp;
        }
    }


}