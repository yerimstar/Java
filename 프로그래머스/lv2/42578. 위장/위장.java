import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] cl : clothes){
            map.put(cl[1], map.getOrDefault(cl[1],0) + 1);
        }
        int answer = 1;
        Iterator<Map.Entry<String,Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String,Integer> entry = iter.next();
            answer *= (entry.getValue()+1);
        }
        return answer - 1;
    }
}