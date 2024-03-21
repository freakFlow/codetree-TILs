import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int ans;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0; k<N; k++){
            int cost = k * k + (k + 1) * (k + 1);
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    visited = new boolean[N][N];
                    int coin = mining(r, c, k);
                    if(coin * M >= cost) ans = coin;
                }
            }
        }

        sb.append(ans);

        System.out.print(sb);
    }

    static int mining(int row, int col, int k){
        int coin = arr[row][col];
        visited[row][col] = true;

        if(k == 0) return coin;

        for(int d=0; d<dr.length; d++){
            int nr = row + dr[d];
            int nc = col + dc[d];
            if(!isIn(nr, nc) || visited[nr][nc]) continue;

            coin += mining(nr, nc, k-1);
        }

        return coin;
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}