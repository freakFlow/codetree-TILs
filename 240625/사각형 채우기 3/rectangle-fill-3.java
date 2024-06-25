import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int MAX = 1000, DIV = 1_000_000_007;

    static int N;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new long[MAX + 1];

        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 7;

        for(int i=3; i<=MAX; i++){
            long result = (2 * dp[i-1] + 3 * dp[i-2]) % DIV;
            for(int j=0; j<i-2; j++){
                result += 2 * dp[j];
                result %= DIV;
            }
            dp[i] = result;
        }        

        sb.append(dp[N]);

        System.out.print(sb);
    }
}