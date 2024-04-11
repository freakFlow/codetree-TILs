import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static HashMap<String, Integer> hashMap;
    static int max;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        hashMap = new HashMap<>();

        for(int n=0; n<N; n++){
            String key = br.readLine();
            int count = hashMap.getOrDefault(key, 0);
            max = Math.max(max, count + 1);
            hashMap.put(key, count + 1);
        }

        sb.append(max);

        System.out.print(sb);
    }
}