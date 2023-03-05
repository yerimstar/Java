import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] lst;
    static int ans;
    public static int solution(int n, int[][] computers){
        int answer = 0;
        lst = new ArrayList[n];
        for(int i = 0; i < n; i++){
            lst[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && i != j) {
                    lst[i].add(j);
                }
            }
        }
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(n,i);
                ans++;
            }
        }
        return ans;
    }
    private static void dfs(int n,int num){
        for(int check : lst[num]){
            if(!visited[check]){
                visited[check] = true;
                dfs(n,check);
            }
        }
    }
}