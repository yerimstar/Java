import java.util.*;

class Solution {
    static class Word{
        String word;
        int idx;

        public Word(String word, int idx) {
            this.word = word;
            this.idx = idx;
        }
    }
    static int answer;
    public static int solution(String begin, String target, String[] words) {
        for(String word : words) {
            if (target.equals(word)) {
                answer++;
            }
        }
        if(answer == 1){
            answer = 0;
            bfs(begin,target,words);
            return answer;
        }
        return 0;
    }
    private static void bfs(String begin, String target, String[] words){
        boolean[] visited = new boolean[words.length];
        Queue<Word> q = new ArrayDeque<>();
        q.offer(new Word(begin,0));

        while(!q.isEmpty()){
            Word cur = q.poll();
            answer = cur.idx;
            if(target.equals(cur.word))
                return;
            for(int i = 0; i < words.length; i++){
                if(visited[i])
                    continue;
                if(checkWord(cur.word,words[i])){
                    visited[i] = true;
                    q.offer(new Word(words[i],cur.idx+1));
                }
            }
        }
    }
    private static boolean checkWord(String check, String word){
        int cnt = 0;
        for(int i = 0; i < check.length(); i++){
            if(check.charAt(i) != word.charAt(i)){
                cnt++;
            }
        }
        if(cnt == 1){
            return true;
        }else {
            return false;
        }
    }
}




   