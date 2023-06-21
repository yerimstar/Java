import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String s = br.readLine();
            if(s.equals(".")){
                break;
            }
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[') {
                    stack.push(c);
                }else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        flag=false;
                        break;
                    } else {
                        stack.pop();
                    }
                }else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        flag=false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(flag && stack.isEmpty()){
                sb.append("yes").append("\n");
            }else{
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }
}