import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static HashSet<Integer> hs;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        hs = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            hs.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(hs.contains(num) ? 1 : 0).append(' ');
        }

        System.out.print(sb);
    }
}