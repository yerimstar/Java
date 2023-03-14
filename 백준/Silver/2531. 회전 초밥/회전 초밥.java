import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] plate = new int[n];
        for(int i = 0; i < n; i++){
            plate[i] = Integer.parseInt(br.readLine());
        }

        if(n == k){
            System.out.println(n);
            return;
        }

        int ans = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = n-k+1; i < n; i++){
            map.putIfAbsent(plate[i],0);
            map.put(plate[i],map.get(plate[i])+1);
        }
        map.putIfAbsent(plate[0],0);
        map.put(plate[0],map.get(plate[0])+1);
        int s = n-k+1;
        // i 추가 s 제거
        // s 없앨 때 쿠폰이라면 set에서 제거하지 말것
        for(int i = 0; i < n-1; i++){
            if(s == n)
                s = 0;

            if(map.get(plate[s]) != null){
                int val = map.get(plate[s])-1;
                if(val == 0){
                    map.remove(plate[s]);
                }else{
                    map.put(plate[s],val);
                }
            }
            map.putIfAbsent(plate[i+1],0);
            map.put(plate[i+1],map.get(plate[i+1])+1);

            if(map.containsKey(c)){
                ans = Math.max(ans,map.size());
            }else{
                ans = Math.max(ans,map.size()+1);
            }
            s++;
        }

        System.out.println(ans);
    }
}