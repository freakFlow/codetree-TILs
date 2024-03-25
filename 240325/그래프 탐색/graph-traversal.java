import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        visited[1] = true;
        dfs(1);

        sb.append(ans);

        System.out.print(sb);
    }

    static void dfs(int v){
        for(int child : graph[v]){
            if(!visited[child]){
                visited[child] = true;
                ans++;
                dfs(child);
            }
        }
    }
}