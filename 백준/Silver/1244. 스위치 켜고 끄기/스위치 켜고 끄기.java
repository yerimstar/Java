import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] switchLst = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n+1; i++){
            switchLst[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = Integer.parseInt(br.readLine());
        for(int i = 0; i < cnt; i++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (sex == 1) {
                for(int j = 1; j < n/num+1; j++){
                    switchLst[j*num] = switchLst[j*num] == 1 ? 0: 1;
                }
            } else if (sex == 2) {
                int check = num <= (n-num) ? num : n-num;
                switchLst[num] = switchLst[num] == 1 ? 0 : 1;
                for(int j = 1; j < check + 1; j++){
                    if(switchLst[num-j] == switchLst[num+j] && num-j != 0){
                        switchLst[num-j] = switchLst[num-j] == 1 ? 0 : 1;
                        switchLst[num+j] = switchLst[num+j] == 1 ? 0 : 1;
                    }else{
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n+1; i++){
            sb.append(switchLst[i] + " ");
            if(i % 20 == 0)
                sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}