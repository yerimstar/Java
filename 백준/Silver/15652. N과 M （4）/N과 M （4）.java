// 중복 순열 + 비내림차순 ( 이전 값보다 크거나 같아야 함 )

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int[] result;
    static int n, m;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[m];

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
        for (int i = 1; i <= n; i++) {
            if (cnt != 0 && result[cnt - 1] > i)
                continue;
            result[cnt] = i;
            perm(cnt + 1);
        }
    }
}