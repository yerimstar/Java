import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] oddNums = {1,3,5,7,9};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] startNums = {2,3,5,7};

        for(int start:startNums){
            primeSubSet(start,0);
        }
        System.out.println(sb);
    }

    private static void primeSubSet(int start, int cnt) {
        if(cnt == n-1){
            sb.append(start).append("\n");
            return;
        }
        for(int odd :oddNums){
            if(isPrime(10*start+odd)){
                primeSubSet(10*start+odd,cnt+1);
            }
        }
    }

    private static boolean isPrime(int n) {
        if(n <= 1){
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0){
                return false;
            }

        }
        return true;
    }
}