import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static HashMap<String, String> hm;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        hm = new HashMap<>();

        for(int n=1; n<=N; n++){
            String str = br.readLine();
            hm.put(str, toStr(n));
            hm.put(toStr(n), str);
        }

        for(int m=0; m<M; m++){
            sb.append(hm.get(br.readLine())).append('\n');
        }

        System.out.print(sb);
    }

    static String toStr(int num){
        StringBuilder temp = new StringBuilder();
        temp.append(num);

        return temp.toString();
    }
}