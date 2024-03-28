import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int N, M;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int ans;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        queue = new ArrayDeque<>();

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                if(st.nextToken().equals("0")) visited[n][m] = true;
            }
        }

        visited[0][0] = true;
        queue.add(new int[]{0, 0});
        bfs();

        sb.append(ans);

        System.out.print(sb);
    }

    static void bfs(){
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for(int d=0; d<dr.length; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(!isIn(nr, nc) || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc});
                if(isGoal(nr, nc)) ans = 1;
            }
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<M;
    }

    static boolean isGoal(int r, int c){
        return r == N - 1 && c == M - 1;
    }
}