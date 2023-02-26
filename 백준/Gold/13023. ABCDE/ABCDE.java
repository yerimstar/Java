import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int ans;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // ArrayList 배열 초기화
        graph = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        // 그래프 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        // 어디서 시작할지 모르니까 -> 모두 탐색
        for(int i = 0; i < n; i++){
            visited[i] = true;
            dfs(i, 0);
            if(ans > 0){
                System.out.println(1);
                return;
            }
            visited[i] = false;
        }
        System.out.println(0);
    }

    // dfs
    private static void dfs(int x, int cnt) {
        // 4개의 간선이 연결되어 있으면 종료
        if (cnt == 4) {
            ans = cnt;
            return;
        }
        for (int node : graph[x]) {
            if (!visited[node]) {
                visited[node] = true;
                dfs(node, cnt + 1);
                visited[node] = false;
            }
        }
    }
}