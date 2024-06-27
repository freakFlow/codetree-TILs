import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[][] arr;
    static int[][] ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        ans = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        ans[0][0] = arr[0][0];
        for(int c=1; c<N; c++){
            ans[0][c] = Math.min(arr[0][c], ans[0][c-1]);
        }
        for(int r=1; r<N; r++){
            ans[r][0] = Math.min(arr[r][0], ans[r-1][0]);
        }

        for(int r=1; r<N; r++){
            for(int c=1; c<N; c++){
                ans[r][c] = Math.min(arr[r][c], Math.max(ans[r-1][c], ans[r][c-1]));
            }
        }

        sb.append(ans[N-1][N-1]);

        System.out.print(sb);
    }
}