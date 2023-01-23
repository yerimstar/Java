import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1476 {
    public static void main(String[] args) throws IOException {
        int E,S,M,tmpE,tmpS,tmpM;
        int year = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        while(true){
            year++;
            tmpE = (year % 15) == 0 ? 15 : year % 15;
            tmpS = (year % 28) == 0 ? 28 : year % 28;
            tmpM = (year % 19) == 0 ? 19 : year % 19;
            if(tmpE == E && tmpS == S && tmpM == M)
                break;
        }
        System.out.print(year);
    }
}
