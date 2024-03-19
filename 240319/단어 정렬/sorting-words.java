import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] arr;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        for(int n=0; n<N; n++){
            arr[n] = br.readLine();
        }        
        Arrays.sort(arr);

        for(int n=0; n<N; n++){
            sb.append(arr[n]).append('\n');
        }

        System.out.print(sb);
    }
}