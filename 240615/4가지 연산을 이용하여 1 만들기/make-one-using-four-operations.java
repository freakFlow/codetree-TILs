import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static Queue<Info> q;
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        q = new ArrayDeque<>();
        visited = new boolean[2 * N];

        visited[N] = true;
        q.add(new Info(N, 0));
        bfs();

        sb.append(ans);

        System.out.print(sb);
    }

    static void bfs(){
        while(!q.isEmpty()){
            Info curr = q.poll();
            int num = curr.num;
            int count = curr.count;

            if(num == 1){
                ans = count;
                return;
            }

            if(isIn(num - 1) && !visited[num - 1]){
                visited[num - 1] = true;
                q.add(new Info(num - 1, count + 1));
            }

            if(isIn(num + 1) && !visited[num + 1]){
                visited[num + 1] = true;
                q.add(new Info(num + 1, count + 1));
            }
           
            if(num % 2 == 0 && isIn(num / 2) && !visited[num / 2]) {
                visited[num / 2] = true;
                q.add(new Info(num / 2, count + 1));
            }

            if(num % 3 == 0 && isIn(num / 3) && !visited[num / 3]) {
                visited[num / 3] = true;
                q.add(new Info(num / 3, count + 1));
            }
        }
    }

    static boolean isIn(int num){
        return num>=0 && num<2*N;
    }

    static class Info{
        int num, count;

        Info(int num, int count){
            this.num = num;
            this.count = count;
        }
    }
}