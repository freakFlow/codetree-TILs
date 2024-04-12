import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;
    static HashMap<Integer, Long> hm;
    static long sum;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        hm = new HashMap<>();

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            long value = hm.getOrDefault(x, Long.MAX_VALUE);
            hm.put(x, Math.min(value, y));

            arr[n] = x;
        }

        for(int n=0; n<N; n++){
            sum += hm.get(arr[n]);
            hm.put(arr[n], 0l);
        }

        sb.append(sum);

        System.out.print(sb);
    }
}