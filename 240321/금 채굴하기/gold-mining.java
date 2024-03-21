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

        for(int k=0; k<=N; k++){
            int cost = k * k + (k + 1) * (k + 1);
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    int coin = mining(r, c, k);
                    if(coin * M >= cost && coin > ans) ans = coin;
                }
            }
        }

        sb.append(ans);

        System.out.print(sb);
    }

    static int mining(int mr, int mc, int k){
        int coin = 0;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(distance(r, c, mr, mc) > k) continue;
                coin += arr[r][c];
            }
        }

        return coin;
    }

    static int distance(int r1, int c1, int r2, int c2){
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}