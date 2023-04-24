import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length(); i++){
            if(i == 0){
                stack.push(s.charAt(i));
            }else{
                if(stack.size() != 0 && stack.peek() == s.charAt(i)){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.size() == 0 ? 1: 0;
    }
}