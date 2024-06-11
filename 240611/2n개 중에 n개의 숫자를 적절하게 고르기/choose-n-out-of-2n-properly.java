import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] nums;
    static int total;
    static int ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new int[2*N];
        ans = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<2*N; n++){
            nums[n] = Integer.parseInt(st.nextToken());
            total += nums[n];
        }

        divide(0, 0, 0);

        sb.append(ans);

        System.out.print(sb);
    }

    static void divide(int idx, int start, int sum){
        if(idx == N){
            ans = Math.min(ans, Math.abs(total - 2 * sum));
            return;
        }

        for(int i=start; i<2*N; i++){
            divide(idx + 1, i + 1, sum + nums[i]);
        }
    }
}