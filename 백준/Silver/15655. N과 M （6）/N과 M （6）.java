// 순열 + 오름차순 정렬

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int[] arr, result;
    static boolean[] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        result = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        perm(0);
        System.out.println(sb);
    }

    private static void perm(int cnt) {
        if (cnt == m) {
            for (int num : result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            if (cnt != 0 && result[cnt - 1] > arr[i])
                continue;
            visited[i] = true;
            result[cnt] = arr[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}