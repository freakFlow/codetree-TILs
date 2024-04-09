import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    static int N, M;
    static int[][] arr;
    static int maxHeight;
    static boolean[][] visited;
    static int K, safe;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                arr[n][m] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, arr[n][m]);
            }
        }

        for(int k=1; k<maxHeight; k++){
            visited = new boolean[N][M];
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if(arr[n][m] <= k) visited[n][m] = true;
                }
            }

            int count = 0;

            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if(visited[n][m]) continue;

                    count++;
                    visited[n][m] = true;
                    dfs(n, m);
                }
            }

            if(count > safe){
                safe = count;
                K = k;
            }
        }

        sb.append(K).append(' ').append(safe);

        System.out.print(sb);
    }

    static void dfs(int r, int c){
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