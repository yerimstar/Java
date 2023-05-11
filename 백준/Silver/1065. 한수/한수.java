import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] checked = new int[1001];
        if(n < 100){
            System.out.println(n);
        }else{
            checked[99] = 99;
            for(int i = 100; i < n+1; i++){
                int hundred = i / 100;
                int ten = (i-hundred*100)/10;
                int one = i-hundred*100-ten*10;
                if((hundred-ten) == (ten-one)){
                    checked[i] = checked[i-1]+1;
                }else{
                    checked[i] = checked[i-1];
                }
            }
            System.out.println(checked[n]);
        }
    }
}