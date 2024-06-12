import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int INF = 10_001;

    static int N;
    static int[] arr;
    static int ans;

    static boolean[] row, col;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N * N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r * N + c] = Integer.parseInt(st.nextToken());
            }
        }

        row = new boolean[N];
        col = new boolean[N];

        findIt(0, 0, INF);

        sb.append(ans);

        System.out.print(sb);
    }

    static void findIt(int idx, int start, int min){
        if(idx == N){
            ans = Math.max(ans, min);
            return;
        }

        for(int i=start; i<N*N; i++){
            if(row[i / N] || col[i % N] || arr[i] < ans) continue;
            row[i / N] = true;
            col[i % N] = true;
            findIt(idx + 1, i + 1, Math.min(min, arr[i]));
            row[i / N] = false;
            col[i % N] = false;
        }
    }
}