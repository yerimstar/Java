import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 중복 x, 순열
 * 오름차순
 */
public class Main {
    static StringBuilder sb;
    static int n, m;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        result = new int[m];

        perm(0);
        System.out.println(sb);
    }

    private static void perm(int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i])
                continue;
            // 처음 넣는 값이 아닌 경우, 직전에 들어간 값과 대소비교 진행 ( for 오름차순 정렬 )
            if (cnt != 0 && result[cnt - 1] > i)
                continue;
            visited[i] = true;
            result[cnt] = i;
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}