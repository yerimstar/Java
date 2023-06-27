import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static class Top{
        private int height;
        private long cnt;

        public Top(int height,long cnt){
            this.height = height;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0;i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        long sum = 0;
        Stack<Top> stack = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            if(stack.isEmpty()){
                stack.push(new Top(arr[i],0));
            }else{
                long tmp = 0;
                while(!stack.isEmpty()){
                    if(arr[i] > stack.peek().height){
                        tmp = tmp + stack.peek().cnt + 1;
                        stack.pop();
                    }else{
                        break;
                    }
                }
                stack.push(new Top(arr[i],tmp));
                sum += tmp;
            }
        }
        System.out.println(sum);
    }
}