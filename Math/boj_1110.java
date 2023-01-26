// 더하기 사이클
/*
- 십의 자리, 일의 자리 분리 (몫, 나머지)
- while문 - 초기값과 같아질 때까지 로직 반복
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int tmp = n;
        int cnt = 0;
        int result;

        while (true) {
            result = (tmp % 10) * 10 + (tmp / 10 + tmp % 10) % 10;
            cnt++;
            if (result == n)
                break;
            tmp = result;
        }
        System.out.println(cnt);
    }
}
