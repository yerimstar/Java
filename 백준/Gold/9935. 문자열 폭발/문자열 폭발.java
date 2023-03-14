import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> s = new Stack<>();
        boolean flag;
        String str1 = br.readLine();
        String str2 = br.readLine();
        for(int i = str1.length()-1; i >= 0; i--){
            s.add(str1.charAt(i));
            // 스택 크기가 폭발 문자열 길이보다 같거나 클 때
            if(s.size() >= str2.length()){
                flag = true;
                for(int j = 0; j < str2.length(); j++){
                    if(s.get(j+s.size()-str2.length()) != str2.charAt(str2.length()-1-j)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(int k = 0; k < str2.length(); k++){
                        s.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if(s.isEmpty()){
            System.out.println("FRULA");
        }else {
            while (!s.isEmpty()) {
                sb.append(s.pop());
            }
            System.out.println(sb);
        }
    }
}