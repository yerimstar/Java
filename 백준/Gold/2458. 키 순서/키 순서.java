import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 인접 행렬
        int[][] graph = new int[n+1][n+1];
        // 인접 행렬 초기화
        for(int i = 1;i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                if(i == j){
                    continue;
                }else{
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        // 거리 저장
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
        }
        // 최단 거리 계산
        for(int k = 1; k < n+1; k++){ // 중간점
            for(int i = 1; i < n+1; i++) { // 시작
                for (int j = 1; j < n + 1; j++) { // 끝
                    if(i == j)
                        continue;
                    if(graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 1; i < n+1; i++){
            int cnt = 0;
            for(int j = 1; j < n+1; j++){
                if(i == j)
                    continue;
                if(graph[i][j] != Integer.MAX_VALUE || graph[j][i] != Integer.MAX_VALUE) {
                    cnt++;
                }
            }
            if(cnt == n-1){
                ans++;
            }
        }
        System.out.println(ans);
    }
}