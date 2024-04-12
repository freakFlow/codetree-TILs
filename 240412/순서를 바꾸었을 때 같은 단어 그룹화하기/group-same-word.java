import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static HashMap<String, Integer> hm;
    static int max;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        hm = new HashMap<>();

        for(int n=0; n<N; n++){
            char[] arr = br.readLine().toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);

            int count = hm.getOrDefault(key, 0);
            hm.put(key, count + 1);
            max = Math.max(max, count + 1);
        }

        sb.append(max);

        System.out.print(sb);
    }
}