import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double x = Integer.parseInt(st.nextToken());
        double y = Integer.parseInt(st.nextToken());

        long z = (long) ((y*100 / x));
        if(z >= 99){
            System.out.println(-1);
            return;
        }
        long s = 1;
        long e = (long)Math.pow(10,9);
        while(s < e){
            long mid = (s+e)/2;
            long check = (long)(((y+mid)*100/(x+mid)));
            if(check <= z){
                s = mid + 1;
            }else{
                e = mid;
            }
        }
        System.out.println(s);
    }
}