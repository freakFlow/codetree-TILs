import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[][] arr;
    static int ans;

    static boolean[] row, col;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        row = new boolean[N];
        col = new boolean[N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        findMax(0, 0);

        sb.append(ans);

        System.out.print(sb);
    }

    static void findMax(int idx, int sum){
        if(idx == N){
            ans = Math.max(ans, sum);
            return;
        }

        for(int r=0; r<N; r++){
            if(row[r]) continue;
            row[r] = true;
            for(int c=0; c<N; c++){
                if(col[c]) continue;
                col[c] = true;
                findMax(idx + 1, sum + arr[r][c]);
                col[c] = false;
            }
            row[r] = false;
        }
    }
}