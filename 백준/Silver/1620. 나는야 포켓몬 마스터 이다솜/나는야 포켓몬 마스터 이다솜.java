import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> map = new HashMap<>();
        String[] arr = new String[n+1];
        for(int i = 0;i < n; i++){
            String str = br.readLine();
            map.put(str,i+1);
            arr[i+1] = str;
        }

        for(int i = 0; i < m; i++){
            String s = br.readLine();
            if(s.matches("^[a-zA-Z]*$")){
                sb.append(map.get(s)).append("\n");
            }else{
                sb.append(arr[Integer.parseInt(s)]).append("\n");
            }
        }
        System.out.println(sb);
    }
}