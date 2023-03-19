import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int num = 0;
            if(!s.equals("all") && !s.equals("empty")){
                num = Integer.parseInt(st.nextToken());
            }
            switch (s){
                case "add":
                    set.add(num);
                    break;
                case "remove":
                    set.remove(num);
                    break;
                case "check":
                    if(set.contains(num)){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "toggle":
                    if(set.contains(num)){
                        set.remove(num);
                    }else{
                        set.add(num);
                    }
                    break;
                case "all":
                    set.clear();
                    for(int j = 1; j <= 20; j++){
                        set.add(j);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }

        }
        System.out.println(sb);
    }
}