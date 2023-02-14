import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n+1];
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        for(int i = 1; i < n+1; i++){
            if(!visited[i]) {
                dfs(i, arr, visited);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static void dfs(int start, ArrayList<Integer>[] arr, boolean[] visited){
        if(visited[start])
            return;
        visited[start] = true;
        for(int i = 0; i < arr[start].size(); i++){
            if(!visited[arr[start].get(i)]){
                dfs(arr[start].get(i),arr,visited);
            }
        }

    }
}