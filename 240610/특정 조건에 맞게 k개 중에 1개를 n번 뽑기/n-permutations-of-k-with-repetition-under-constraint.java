import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int K, N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        makeNum(0);

        System.out.print(sb);
    }

    static void makeNum(int idx){
        if(idx == N){
            for(int n=0; n<N; n++){
                sb.append(arr[n]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=1; i<=K; i++){
            if(idx > 1 && i == arr[idx-1] && i == arr[idx-2]) continue;

            arr[idx] = i;
            makeNum(idx + 1);
        }
    }
}