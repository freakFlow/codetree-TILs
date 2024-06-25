import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int MAX = 19;
    
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[MAX + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=MAX; i++){
            for(int j=1; j<=i; j++){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        sb.append(dp[N]);

        System.out.print(sb);
    }
}