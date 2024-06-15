import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int BLANK = 0, GYUL = 1, ROTTEN = 2;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N, K;
    static int[][] arr;
    static int[][] ans;

    static boolean[][] visited;
    static Queue<Info> q;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        ans = new int[N][N];
        visited = new boolean[N][N];
        q = new ArrayDeque<>();

        int idx = 0;
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
                
                switch(arr[r][c]){
                    case BLANK:
                        ans[r][c] = -1; break;
                    case GYUL:
                        ans[r][c] = -2; break;
                    case ROTTEN:
                        visited[r][c] = true;
                        q.add(new Info(r, c, 0));
                }
            }
        }

        bfs();

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                sb.append(ans[r][c]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void bfs(){
        while(!q.isEmpty()){
            Info curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            int w = curr.w;

            for(int d=0; d<dr.length; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(isIn(nr, nc) && !visited[nr][nc] && arr[nr][nc] == GYUL){
                    visited[nr][nc] = true;
                    q.add(new Info(nr, nc, w + 1));
                    ans[nr][nc] = w + 1;
                }
            }
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static class Info{
        int r, c, w;

        Info(int r, int c, int w){
            this.r = r;
            this.c = c;
            this.w = w;
        }
    }
}