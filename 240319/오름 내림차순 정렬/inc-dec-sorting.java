import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Integer[] arr;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = new Integer(st.nextToken());
        }

        Arrays.sort(arr);
        for(int n=0; n<N; n++){
            sb.append(arr[n]).append(' ');
        }
        sb.append('\n');

        Arrays.sort(arr, Collections.reverseOrder());
        for(int n=0; n<N; n++){
            sb.append(arr[n]).append(' ');
        }

        System.out.print(sb);
    }
}