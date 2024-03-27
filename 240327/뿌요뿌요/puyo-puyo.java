import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int bomb, max, block;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(visited[r][c]) continue;
                visited[r][c] = true;
                block = 1;
                dfs(r, c);
                if(block > 3) bomb++;
                max = Math.max(max, block);
            }
        }

        sb.append(bomb).append(' ').append(max);

        System.out.print(sb);
    }

    static void dfs(int r, int c){
        int num = arr[r][c];

        for(int d=0; d<dr.length; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(isIn(nr, nc) && !visited[nr][nc] && arr[nr][nc] == num){
                visited[nr][nc] = true;
                block++;
                dfs(nr, nc);
            }
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}