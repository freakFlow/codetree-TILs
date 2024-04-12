import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String oper, x;
    static HashSet<String> hs;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        hs = new HashSet<>();

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            oper = st.nextToken();
            x = st.nextToken();

            switch(oper){
                case "add":
                    hs.add(x); break;
                case "remove":
                    hs.remove(x); break;
                case "find":
                    sb.append(hs.contains(x)).append('\n');
            }
        }

        System.out.print(sb);
    }
}