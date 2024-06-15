import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int WALL = 1, HUMAN = 2, SAFE = 3;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N, H, M;
    static int[][] arr;
    static int[][] ans;

    static boolean[][] visited;
    static Queue<Info> q;
    static int count;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        ans = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(arr[r][c] == HUMAN){
                    visited = new boolean[N][N];
                    q = new ArrayDeque<>();

                    visited[r][c] = true;
                    q.add(new Info(r, c, 0));
                    count = -1;
                    bfs();

                    ans[r][c] = count;
                }
            }
        }

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

            if(arr[r][c] == SAFE){
                count = w;
                return;
            }

            for(int d=0; d<dr.length; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(isIn(nr, nc) && !visited[nr][nc] && arr[nr][nc] != WALL){
                    visited[nr][nc] = true;
                    q.add(new Info(nr, nc, w + 1));
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