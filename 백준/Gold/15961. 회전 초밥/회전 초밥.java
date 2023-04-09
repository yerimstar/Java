import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int result = 0;

        int[] sushi = new int[n + k - 1]; // 초밥 입력받는 배열
        int[] count = new int[d + 1]; // 초밥의 가짓수만큼 배열을 만들어서 개수 체크
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        // 앞 쪽 k-1개를 뒤에 붙인다
        for (int i = 0; i < k - 1; i++) {
            sushi[n++] = sushi[i];
        }
        int cnt = 0;
        // 슬라이딩 윈도우로 이동하면서 개수 증가, 감소 시키기
        for (int i = 0; i < n; i++) {
            if (++count[sushi[i]] == 1) {
                cnt++;
            }
            // k개가 되는 순간부터 초밥의 가짓수를 체크한다.
            if (i >= k - 1) {
                // k번 이후부터는 슬라이딩 윈도우로 값 비교하기 위해서 k개 중에 가장 먼저 들어온 초밥을 제거한다.
                if (i >= k) {
                    if (--count[sushi[i - k]] == 0) {
                        cnt--;
                    }
                }
                // 쿠폰을 포함하고 있지 않으면 가짓수 1 증가
                if (count[c] == 0) {
                    result = Math.max(cnt + 1, result);
                } else {
                    result = Math.max(cnt, result);
                }
            }
        }
        System.out.println(result);
    }
}