import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] num;
    static int ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            num[n] = Integer.parseInt(st.nextToken());
        }

        simulate(0, 0);

        sb.append(ans);

        System.out.print(sb);
    }

    static void simulate(int idx, int result){
        if(idx == M){
            ans = Math.max(ans, result);
            return;
        }

        for(int i=0; i<N; i++){
            simulate(idx + 1, result ^ num[i]);
        }
    }
}