import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int N;
    static int x, y;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int idx = toIdx(st.nextToken());
            int mul = Integer.parseInt(st.nextToken());
            x += dx[idx] * mul;
            y += dy[idx] * mul;
        }

        sb.append(x).append(' ').append(y);
        System.out.print(sb);
    }

    static int toIdx(String str){
        switch(str){
            case "W": return 0;
            case "S": return 1;
            case "N": return 2;
            default: return 3;
        }
    }
}