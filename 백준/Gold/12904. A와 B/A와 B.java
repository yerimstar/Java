import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());
        // 같아질 때까지 반복
        while (t.length() > s.length()) {
            // A인 경우 -> 문자 삭제
            if (t.charAt(t.length() - 1) == 'A') {
                t.deleteCharAt(t.length() - 1);
            }
            // B인 경우 -> 문자 삭제 + 뒤집기
            else if (t.charAt(t.length() - 1) == 'B') {
                t.deleteCharAt(t.length() - 1);
                t.reverse();
            }
        }
        // s와 t가 같다면 -> 1 출력
        if (s.toString().equals(t.toString())) {
            System.out.println(1);
        }
        // 다르다면 -> 0 출력
        else {
            System.out.println(0);
        }

    }
}