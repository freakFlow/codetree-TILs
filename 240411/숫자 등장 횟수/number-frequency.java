import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static HashMap<String, Integer> hashMap;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        hashMap = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            String num = st.nextToken();
            int count = hashMap.getOrDefault(num, 0);
            hashMap.put(num, count + 1);
        }

        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++){
            String key = st.nextToken();
            sb.append(hashMap.getOrDefault(key, 0)).append(' ');
        }

        System.out.print(sb);
    }
}