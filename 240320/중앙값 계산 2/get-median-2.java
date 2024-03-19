import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int n=0; n<N; n++){
            arr[n] = 100_001;
        }

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
            if(n % 2 == 0){
                Arrays.sort(arr);
                sb.append(arr[n/2]).append(' ');
            }
        }

        System.out.print(sb);
    }
}