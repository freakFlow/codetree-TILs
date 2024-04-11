import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String oper, k, v;
    static HashMap<String, String> hashMap;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        hashMap = new HashMap<>();

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            oper = st.nextToken();
            k = st.nextToken();
            if(st.hasMoreTokens()) v = st.nextToken();

            switch(oper){
                case "add":
                    hashMap.put(k, v); break;
                case "remove":
                    hashMap.remove(k); break;
                case "find":
                    sb.append(hashMap.getOrDefault(k, "None")).append('\n');
            }
        }

        System.out.print(sb);
    }
}