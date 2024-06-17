import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static Map<String, String> hm;
    static String oper, k, v;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        hm = new HashMap<>();

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            oper = st.nextToken();
            k = st.nextToken();
            
            switch(oper){
                case "add":
                    v = st.nextToken();
                    hm.put(k, v);
                    break;
                case "remove":
                    hm.remove(k); break;
                case "find":
                    sb.append(hm.getOrDefault(k, "None")).append('\n'); break;
            }
        }

        System.out.print(sb);
    }
}