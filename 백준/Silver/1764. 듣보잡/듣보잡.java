import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> hs1 = new HashSet<>();
        for(int i = 0;i < n; i++){
            hs1.add(br.readLine());
        }
        HashSet<String> hs2 = new HashSet<>();
        for(int i = 0; i < m;i++){
            hs2.add(br.readLine());
        }
        TreeSet<String> ts = new TreeSet<>();
        hs1.retainAll(hs2);
        for(String s : hs1){
            ts.add(s);
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(ts.size());
        for(String s : ts){
            System.out.println(s);
        }
    }
}