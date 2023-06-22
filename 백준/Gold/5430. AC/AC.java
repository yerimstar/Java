import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t;i++){
            String s = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
            ArrayDeque<Integer> q = new ArrayDeque<>();
            for(int j = 0;j < n;j++){
                q.offer(Integer.parseInt(st.nextToken()));
            }
            boolean flag = true;
            boolean check = true;
            for(int j = 0;j < s.length(); j++){
                if(s.charAt(j) == 'R'){
                    flag = !flag;
                }else if(s.charAt(j) == 'D'){
                    if(q.size() == 0){
                        sb.append("error").append("\n");
                        check = false;
                        break;
                    }
                    if(flag){
                        q.pollFirst();
                    }else{
                        q.pollLast();
                    }
                }
            }
            if(check){
                sb.append("[");
                if(q.size() != 0){
                    if(flag){
                        sb.append(q.pollFirst());
                        while(!q.isEmpty()){
                            sb.append(",").append(q.pollFirst());
                        }
                    }else{
                        sb.append(q.pollLast());
                        while(!q.isEmpty()){
                            sb.append(",").append(q.pollLast());
                        }
                    }
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}