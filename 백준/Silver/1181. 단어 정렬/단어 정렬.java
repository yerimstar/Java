import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()){
                    return s1.compareTo(s2);
                }
                return s1.length()-s2.length();
            }
        });
        for(int i = 0;i < n; i++){
            ts.add(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        for(String s : ts){
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}