import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2-i1;
            }
        });
        for(int i = 0; i < s.length(); i++){
            pq.add(s.charAt(i)-'0');
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        System.out.println(sb);
    }
}