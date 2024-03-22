import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, T;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[2 * N];

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<2*N; n++){
            if(n == N) st = new StringTokenizer(br.readLine());
            arr[n] = Integer.parseInt(st.nextToken());
        }

        T %= N;
        for(int t=0; t<T; t++){
            int temp = arr[2*N-1];
            for(int n=2*N-1; n>0; n--){
                arr[n] = arr[n-1];
            }
            arr[0] = temp;
        }

        for(int n=0; n<2*N; n++){
            if(n == N) sb.append('\n');
            sb.append(arr[n]).append(' ');
        }

        System.out.print(sb);
    }
}