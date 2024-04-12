import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int ans;
    static HashSet<String> hs;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        hs = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            String num = st.nextToken();
            if(hs.contains(num)) continue;

            ans++;
            hs.add(num);
        }

        sb.append(ans);

        System.out.print(sb);
    }
}