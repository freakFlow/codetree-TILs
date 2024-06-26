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
        arr = new int[2*N];

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n+N] = Integer.parseInt(st.nextToken());
        }

        T %= 2*N;

        for(int t=0; t<T; t++){
            int temp = arr[2*N-1];
            for(int n=2*N-1; n>0; n--){
                arr[n] = arr[n-1];
            }
            arr[0] = temp;
        }

        for(int n=0; n<N; n++){
            sb.append(arr[n]).append(' ');
        }
        sb.append('\n');
        for(int n=0; n<N; n++){
            sb.append(arr[n+N]).append(' ');
        }

        System.out.print(sb);
    }
}