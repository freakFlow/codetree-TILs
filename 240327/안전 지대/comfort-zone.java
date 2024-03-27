import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int N, M;
    static int[][] town;
    static boolean[][] visited;
    static int K, maxSafeArea, safeArea;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        town = new int[N][M];
        K = 1;

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                town[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=1; k<=100; k++){
            visited = new boolean[N][M];
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if(town[n][m] > k) continue;
                    visited[n][m] = true;
                }
            }
            safeArea = 0;

            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if(visited[n][m]) continue;
                    visited[n][m] = true;
                    safeArea++;
                    dfs(n, m);
                }
            }

            if(safeArea == 0) break;

            if(safeArea > maxSafeArea){
                maxSafeArea = safeArea;
                K = k;
            }
        }

        sb.append(K).append(' ').append(maxSafeArea);

        System.out.print(sb);
    }

    static void dfs(int r, int c){
        for(int d=0; d<dr.length; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(!isIn(nr, nc) || visited[nr][nc]) continue;
            visited[nr][nc] = true;
            dfs(nr, nc);
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<M;
    }
}