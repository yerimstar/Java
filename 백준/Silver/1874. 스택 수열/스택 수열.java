import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[n];
        for(int i = 0;i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int idx = 0;
        int num = 1;
        while(num <= n){
            if(stack.isEmpty()){
                stack.push(num);
                sb.append("+").append("\n");
                num++;
            }else{
                if(arr[idx] == stack.peek()){
                    stack.pop();
                    sb.append("-").append("\n");
                    idx++;
                }else{
                    stack.push(num);
                    sb.append("+").append("\n");
                    num++;
                }
            }
        }
        while(!stack.isEmpty()){
            if(arr[idx] == stack.peek()){
                stack.pop();
                sb.append("-").append("\n");
                idx++;
            }else{
                break;
            }
        }
        if(idx == n){
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }
    }
}