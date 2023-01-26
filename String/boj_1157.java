import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 단어 공부
public class boj_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine().toUpperCase();
        int[] alpha = new int[26];
        int maxsize = -1;
        char result = '?';

        for (int i = 0; i < str.length(); i++)
            alpha[str.charAt(i) - 'A'] += 1;

        for (int i = 0; i < 26; i++) {
            if (maxsize < alpha[i]) {
                maxsize = alpha[i];
                result = (char) (i + 65);
            } else if (maxsize == alpha[i]) { // 많이 사용된 알파벳이 여러개 나오는 경우
                result = '?';
            }
        }
        System.out.println(result);
    }
}
