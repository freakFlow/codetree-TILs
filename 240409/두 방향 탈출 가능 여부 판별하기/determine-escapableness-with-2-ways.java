import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int[] dr = {0, 1};
    static final int[] dc = {1, 0};

    static int N, M;
    static boolean[][] visited;
    static int ans;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                if(st.nextToken().equals("0")) visited[n][m] = true;
            }
        }

        visited[0][0] = true;
        dfs(0, 0);

        sb.append(ans);

        System.out.print(sb);
    }

    static void dfs(int r, int c){
        if(r == N-1 && c == M-1){
            ans = 1;
            return;
        }

        for(int d=0; d<dr.length; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(isIn(nr, nc) && !visited[nr][nc]){
                visited[nr][nc] = true;
                dfs(nr, nc);
            }
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<M;
    }
}