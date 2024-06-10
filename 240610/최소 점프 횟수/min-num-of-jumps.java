import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] jump, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        jump = new int[N];
        ans = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            jump[n] = Integer.parseInt(st.nextToken());
        }

        jumpStart(0, 0);

        sb.append(ans[N-1] == 0 ? -1 : ans[N-1]);

        System.out.print(sb);
    }

    static void jumpStart(int idx, int count){
        if(idx >= N) return;

        if(ans[idx] > 0 && count > ans[idx]) return;

        ans[idx] = count;

        for(int i=1; i<=jump[idx]; i++){
            jumpStart(idx + i, count + 1);
        }
    }
}