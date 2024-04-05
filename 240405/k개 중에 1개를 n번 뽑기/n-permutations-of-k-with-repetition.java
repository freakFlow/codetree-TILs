import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int K, N;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        combination(0);

        System.out.print(sb);
    }

    static void combination(int idx){
        if(idx == N){
            for(int n=0; n<N; n++){
                sb.append(arr[n]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int k=1; k<=K; k++){
            arr[idx] = k;
            combination(idx + 1);
        }
    }
}