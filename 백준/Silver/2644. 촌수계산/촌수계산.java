import com.sun.org.apache.bcel.internal.generic.LUSHR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0;
    static int res = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer>[] arr = new LinkedList[n + 1];
        for (int i = 0; i < n + 1; i++)
            arr[i] = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }

        dfs(arr, visited, s, e,0);
        System.out.println(res);
    }

    public static void dfs(LinkedList<Integer>[] arr, boolean[] visited, int s, int e,int cnt) {
        visited[s] = true;
        for (int i = 0; i < arr[s].size(); i++) {
            if (!visited[arr[s].get(i)]) {
                if (arr[s].get(i) == e){
                    res = cnt+1;
                    return;
                }
                dfs(arr, visited, arr[s].get(i), e,cnt+1);
            }
        }
    }
}