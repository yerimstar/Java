import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int k,minVal, maxVal;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String W = br.readLine();
            k = Integer.parseInt(br.readLine());

            ArrayList<Integer>[] lst = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                lst[i] = new ArrayList<>();
            }

            for (int i = 0; i < W.length(); i++) {
                lst[W.charAt(i)-'a'].add(i);
            }

            minVal = W.length()+1;
            maxVal = -1;

            for(int i = 0; i < 26; i++){
                if(lst[i].size() < k)
                    continue;
                check(lst[i]);
            }

            if(minVal == (W.length()+1) || maxVal == -1)
                sb.append(-1).append("\n");
            else
                sb.append(minVal).append(" ").append(maxVal).append("\n");
        }
        System.out.println(sb);
    }
    private static void check(ArrayList<Integer> lst){
        for(int i = 0; i < lst.size()-k+1; i++){
            minVal = Math.min(minVal, lst.get(i+k-1)-lst.get(i)+1);
            maxVal = Math.max(maxVal, lst.get(i+k-1)-lst.get(i)+1);
        }
    }
}