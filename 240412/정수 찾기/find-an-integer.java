import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static HashSet<String> hs;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        hs = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            hs.add(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++){
            sb.append(hs.contains(st.nextToken()) ? 1 : 0).append('\n');
        }

        System.out.print(sb);
    }
}