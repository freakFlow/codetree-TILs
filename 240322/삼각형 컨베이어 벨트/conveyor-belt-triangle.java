import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, T;
    static int[] arr;
    static int size;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        size = 3 * N;
        arr = new int[size];

        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int n=0; n<N; n++){
                arr[i * N + n] = Integer.parseInt(st.nextToken());
            }
        }

        T %= size;
        for(int t=0; t<T; t++){
            int temp = arr[size - 1];
            for(int i=size-1; i>0; i--){
                arr[i] = arr[i - 1];
            }
            arr[0] = temp;
        }

        for(int i=0; i<3; i++){
            for(int n=0; n<N; n++){
                sb.append(arr[i * N + n]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}