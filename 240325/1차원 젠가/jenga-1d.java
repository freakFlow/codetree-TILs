import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;
    static int[] temp;
    static int s, e;
    static int size;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];
        size = N;

        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<2; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken())-1;
            e = Integer.parseInt(st.nextToken())-1;

            int idx = 0;
            for(int n=0; n<size; n++){
                if(n>=s && n<=e) continue;
                temp[idx++] = arr[n];
            }

            size = idx;
            for(int n=0; n<size; n++){
                arr[n] = temp[n];
            }
        }

        sb.append(size).append('\n');
        for(int n=0; n<size; n++){
            sb.append(arr[n]).append('\n');
        }

        System.out.print(sb);
    }
}