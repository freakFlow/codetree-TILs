import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        makeNum(0, 1);

        System.out.print(sb);
    }

    static void makeNum(int idx, int start){
        if(idx == M){
            for(int m=0; m<M; m++){
                sb.append(arr[m]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=start; i<=N; i++){
            arr[idx] = i;
            makeNum(idx + 1, i + 1);
        }
    }
}