import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dc = {2, 1, -1, -2, -2, -1, 1, 2};

    static int N;
    static int sr, sc, er, ec;
    static int ans;

    static int[][] arr;
    static boolean[][] visited;
    static Queue<Info> q;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        er = Integer.parseInt(st.nextToken()) - 1;
        ec = Integer.parseInt(st.nextToken()) - 1;

        arr = new int[N][N];
        visited = new boolean[N][N];
        q = new ArrayDeque<>();
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                arr[r][c] = -1;
            }
        }

        arr[sr][sc] = 0;
        visited[sr][sc] = true;
        q.add(new Info(sr, sc));
        bfs();

        ans = arr[er][ec];
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