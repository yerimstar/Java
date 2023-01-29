import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 3kg, 5kg
public class boj_2839{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int bagCnt = 0;
        while(true) {
            if(n % 5 == 0) {
                bagCnt += n/5;
                break;
            }

            if(n < 3) {
                bagCnt = -1;
                break;
            }

            n -= 3;
            bagCnt += 1;

        }
        System.out.println(bagCnt);
    }

}
