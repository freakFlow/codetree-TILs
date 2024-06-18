import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, K;
    static long[] arr;
    static HashMap<Long, Integer> hm;
    static int ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N];
        hm = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Long.parseLong(st.nextToken());
            hm.put(arr[n], hm.getOrDefault(arr[n], 0) + 1);
        }

        for(int n=0; n<N; n++){
            long key = K - arr[n];
            int count = hm.getOrDefault(key, 0);

            if(count == 0) continue;

            ans += count;
            if(key == arr[n]) ans--;
        }

        sb.append(ans / 2);

        System.out.print(sb);
    }
}