import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int size;
    static int count, maxSize;

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

                size = 1;
                visited[r][c] = true;
                dfs(r, c);

                if(size >= 4) count++;
                maxSize = Math.max(maxSize, size);
            }
        }

        sb.append(count).append(' ').append(maxSize);

        System.out.print(sb);
    }

    static void dfs(int r, int c){
        for(int d=0; d<dr.length; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(isIn(nr, nc) && !visited[nr][nc] && arr[r][c] == arr[nr][nc]){
                size++;
                visited[nr][nc] = true;
                dfs(nr, nc);
            }
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}