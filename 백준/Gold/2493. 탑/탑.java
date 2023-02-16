import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Top{
    private int num;
    private int index;

    Top(int num, int index){
        this.num = num;
        this.index = index;
    }

    public int getNum() {
        return num;
    }

    public int getIndex() {
        return index;
    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Top> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int num = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()){
                if(stack.peek().getNum() < num){
                    stack.pop();
                }else{
                    break;
                }
            }
            if(stack.isEmpty()){
                sb.append("0").append(" ");
            }else{
                sb.append(stack.peek().getIndex()).append(" ");
            }
            stack.push(new Top(num,i));

        }
        System.out.println(sb);
    }
}