import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Top{
        private int height;
        private int num;

        public Top(int height,int num){
            this.height = height;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Top> stack = new Stack<Top>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < n;i++){
            int num = Integer.parseInt(st.nextToken());
            if(stack.isEmpty()){
               stack.push(new Top(num,i+1));
               sb.append(0).append(" ");
            }else{
                while(!stack.isEmpty()){
                    if(num > stack.peek().height){
                        stack.pop();
                    }else{
                        sb.append(stack.peek().num).append(" ");
                        break;
                    }
                }
                if(stack.isEmpty()){
                    sb.append(0).append(" ");
                }
                stack.push(new Top(num, i+1));
            }
        }
        System.out.println(sb);
    }
}