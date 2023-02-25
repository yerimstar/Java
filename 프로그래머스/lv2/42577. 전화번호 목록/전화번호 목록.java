import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        for(String pn:phone_book){
            set.add(pn);
        }
        for(String pn:phone_book){
            for(int i = 0; i < pn.length(); i++){
                if(set.contains(pn.substring(0,i))){
                    return false;
                }
            }
        }
        return true;
    }
}