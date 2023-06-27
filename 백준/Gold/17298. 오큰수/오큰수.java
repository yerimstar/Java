import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for(int i = n-1; i >= 0; i--){
            if(stack.isEmpty()){
                ans[i] = -1;
                stack.push(arr[i]);
            }else{
                while(!stack.isEmpty()){
                    if(arr[i] < stack.peek()){
                        ans[i] = stack.peek();
                        break;
                    }else{
                        stack.pop();
                    }
                }
                if(stack.isEmpty()){
                    ans[i] = -1;
                }
                stack.push(arr[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}