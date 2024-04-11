import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int BLANK = 0, GYUL = 1, BAD = 2;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N, K;
    static int[][] arr;
    static Info[] bads;
    static int[][] ans;

    static boolean[][] visited;
    static Queue<Info> q;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        bads = new Info[K];
        ans = new int[N][N];
        q = new ArrayDeque<>();

        int bIdx = 0;
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
                if(arr[r][c] == BAD) bads[bIdx++] = new Info(r, c);
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(arr[r][c] == GYUL){
                    ans[r][c] = -2;
                    continue;
                }
                ans[r][c] = -1;
            }
        }

        visited = new boolean[N][N];
        for(Info b : bads){
            visited[b.r][b.c] = true;
            ans[b.r][b.c] = 0;
            q.add(b);
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

            for(int d=0; d<dr.length; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];


                if(isIn(nr, nc) && !visited[nr][nc] && arr[nr][nc] == GYUL){
                    visited[nr][nc] = true;
                    ans[nr][nc] = ans[r][c] + 1;
                    q.add(new Info(nr, nc));
                }
            }
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static class Info{
        int r, c;

        Info(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}