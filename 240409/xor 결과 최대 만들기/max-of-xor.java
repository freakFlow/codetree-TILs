import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] num;
    static int[] arr;
    static int max;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            num[n] = Integer.parseInt(st.nextToken());
        }

        combination(0, 0);

        sb.append(max);

        System.out.print(sb);
    }

    static void combination(int idx, int start){
        if(idx == M){
            int result = num[arr[0]];

            for(int m=1; m<M; m++){
                result ^= num[arr[m]];
            }

            max = Math.max(max, result);

            return;
        }

        for(int i=start; i<N; i++){
            arr[idx] = i;
            combination(idx + 1, i + 1);
        }
    }
}