import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N, M;
    static int ans;
    
    static boolean[][] visited;
    static int[][] arr;
    static Queue<Info> q;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        arr = new int[N][M];
        q = new ArrayDeque<>();

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++){
                if(st.nextToken().equals("0")) visited[r][c] = true;
            }
        }

        visited[0][0] = true;
        q.add(new Info(0, 0));
        bfs();

        ans = arr[N-1][M-1];
        if(ans == 0) ans = -1;

        sb.append(ans);

        System.out.print(sb);
    }

    static void bfs(){
        while(!q.isEmpty()){
            Info curr = q.poll();
            int r = curr.r;
            int c = curr.c;

            for(int d=0; d<dr.length; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(isIn(nr, nc) && !visited[nr][nc]){
                    arr[nr][nc] = arr[r][c] + 1;
                    visited[nr][nc] = true;
                    q.add(new Info(nr, nc));
                }
            }
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<M;
    }

    static class Info{
        int r, c;

        Info(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}