import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        dp[1] = dp[2] = 1;

        for(int i=3; i<=N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        sb.append(dp[N]);

        System.out.print(sb);
    }
}