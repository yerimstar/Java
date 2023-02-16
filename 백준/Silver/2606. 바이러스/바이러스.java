import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        LinkedList<Integer>[] arr = new LinkedList[n+1];
        boolean[] visited = new boolean[n+1];
        for(int i = 0; i < n+1; i++){
            arr[i] = new LinkedList<Integer>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        dfs(arr, visited, 1);
        System.out.println(cnt);
    }
    public static void dfs(LinkedList<Integer>[] arr, boolean[] visited, int start){
        if(visited[start])
            return;
        visited[start] = true;

        for(int i = 0; i < arr[start].size(); i++){
            if(!visited[arr[start].get(i)]) {
                cnt++;
                dfs(arr,visited,arr[start].get(i));
            }
        }
    }
}