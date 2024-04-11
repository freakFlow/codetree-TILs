import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int ans;

    static boolean[] visited;
    static Queue<Info> q;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        visited = new boolean[3 * N / 2 + 1];
        q = new ArrayDeque<>();

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
            int time = curr.time;

            if(num == 1){
                ans = time;
                break;
            }

            int temp = num + 1;
            if(isIn(temp) && !visited[temp]){
                visited[temp] = true;
                q.add(new Info(temp, time + 1));
            }

            temp = num - 1;
            if(isIn(temp) && !visited[temp]){
                visited[temp] = true;
                q.add(new Info(temp, time + 1));
            }

            temp = num / 2;
            if(num % 2 == 0 && isIn(temp) && !visited[temp]){
                visited[temp] = true;
                q.add(new Info(temp, time + 1));
            }

            temp = num / 3;
            if(num % 3 == 0 && isIn(temp) && !visited[temp]){
                visited[temp] = true;
                q.add(new Info(temp, time + 1));
            }
        }
    }

    static boolean isIn(int num){
        return num>=0 && num<visited.length;
    }

    static class Info{
        int num;
        int time;

        Info(int num, int time){
            this.num = num;
            this.time = time;
        }
    }
}