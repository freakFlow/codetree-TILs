import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, T;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[3 * N];

        for(int n=0; n<3*N; n++){
            if(n % N == 0) st = new StringTokenizer(br.readLine());
            arr[n] = Integer.parseInt(st.nextToken());
        }

        T %= 3 * N;

        for(int t=0; t<T; t++){
            int temp = arr[3 * N - 1];
            for(int n=3*N-1; n>0; n--){
                arr[n] = arr[n-1];
            }
            arr[0] = temp;
        }

        for(int n=0; n<3*N; n++){
            if(n == N || n == 2*N) sb.append('\n');
            sb.append(arr[n]).append(' ');
        }

        System.out.print(sb);
    }
}