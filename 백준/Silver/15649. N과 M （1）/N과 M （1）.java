import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int n,m;
    static int[] result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        result = new int[m];

        // 순열 (중복 x)
        perm(0);
        System.out.println(sb);
    }
    private static void perm(int cnt){
        if(cnt == m){
            for(int num : result){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= n; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            result[cnt] = i;
            perm(cnt+1);
            visited[i] = false;
        }
    }
}