import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        int[] lst = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            lst[i] = Integer.parseInt(st.nextToken());
            set.add(lst[i]);
        }

        int[] arr = new int[set.size()];
        int idx = 0;
        for(int num : set){
            arr[idx++] = num;
        }
        Arrays.sort(arr);

        for(int i = 0; i < n; i++){
            sb.append(Arrays.binarySearch(arr,lst[i])).append(" ");
        }
        System.out.println(sb);
    }
}