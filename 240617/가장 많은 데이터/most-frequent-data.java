import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static HashMap<String, Integer> hm;
    static Set<String> str;
    static int max;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        hm = new HashMap<>();
        str = new HashSet<>();

        for(int n=0; n<N; n++){
            String input = br.readLine();
            hm.put(input, hm.getOrDefault(input, 0) + 1);
            str.add(input);
        }

        for(String key : str){
            max = Math.max(max, hm.get(key));
        }

        sb.append(max);

        System.out.print(sb);
    }
}