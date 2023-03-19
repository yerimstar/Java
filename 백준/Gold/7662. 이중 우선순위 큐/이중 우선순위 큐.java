import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        int val = 0;
        for(int i = 0; i < t;i++){
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer,Integer> map = new TreeMap<>();

            for(int j = 0; j < k; j++){
                st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());
                if(op == 'I'){
                    // 처음 추가
                    if(map.get(num) == null){
                        map.put(num,1);
                    }
                    // 이미 값이 있는 경우 -> 개수만 증가
                    else{
                        map.put(num,map.get(num)+1);
                    }
                } else if (op == 'D') {
                    if(!map.isEmpty()){
                        // 최댓값
                        if(num == 1){
                            int maxKey = map.lastKey();
                            if(map.get(maxKey) ==1){
                                map.remove(maxKey);
                            }else{
                                map.put(maxKey,map.get(maxKey)-1);
                            }
                        }
                        // 최솟값
                        else if(num == -1){
                            int minKey = map.firstKey();
                            if(map.get(minKey) == 1){
                                map.remove(minKey);
                            }else{
                                map.put(minKey,map.get(minKey)-1);
                            }
                        }
                    }
                }
            }
            if(map.isEmpty()){
                sb.append("EMPTY").append("\n");
            }else{
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}