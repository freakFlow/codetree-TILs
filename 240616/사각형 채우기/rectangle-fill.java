import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int MAX = 1000, DIV = 10_007;

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[MAX + 1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=MAX; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % DIV;
        }

        sb.append(dp[N]);

        System.out.print(sb);
    }
}