import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[][] arr;
    static int ans;

    static int[] sequence;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        ans = Integer.MAX_VALUE;

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        sequence = new int[N - 1];
        visited = new boolean[N];

        start(0);

        sb.append(ans);

        System.out.print(sb);
    }

    static void start(int idx){
        if(idx == N - 1){
            int from = 0;
            int cost = 0;
            for(int i=0; i<N-1; i++){
                int to = sequence[i];
                cost += arr[from][to];
                from = to;
            }
            ans = Math.min(ans, cost + arr[from][0]);
            return;
        }

        for(int i=1; i<N; i++){
            if(visited[i]) continue;
            sequence[idx] = i;
            visited[i] = true;
            start(idx + 1);
            visited[i] = false;
        }
    }
}