import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0;i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        int num = n+1;
        int sum = Integer.MAX_VALUE;
        for(int i = 1; i < n+1; i++){
            int ans = bfs(i);
            if(sum > ans){
                num = i;
                sum = ans;
            }
        }
        System.out.println(num);
    }
    private static int bfs(int x){
        Queue<Integer> q = new ArrayDeque<>();
        int[] visited = new int[n+1];
        q.offer(x);
        while(!q.isEmpty()){
            int num = q.poll();
            for(int k : arr[num]){
                if(visited[k] == 0 && x != k){
                    q.offer(k);
                    visited[k] = visited[num] + 1;
                }
            }
        }
        int sum = 0;
        for(int i = 1; i < n+1; i++){
            sum += visited[i];
        }
        return sum;
    }
}