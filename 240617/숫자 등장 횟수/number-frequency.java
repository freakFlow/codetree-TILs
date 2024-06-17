import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static HashMap<String, Integer> hm;
    static String key;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        hm = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            key = st.nextToken();
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }

        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++){
            sb.append(hm.getOrDefault(st.nextToken(), 0) + " ");
        }

        System.out.print(sb);
    }
}