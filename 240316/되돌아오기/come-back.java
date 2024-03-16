import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    static int s_x, s_y;
    static int x, y, d;
    static int time, ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        ans = -1;

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            d = toIdx(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            for(int i=0; i<dist; i++){
                time++;
                x += dx[d];
                y += dy[d];
                if(x == s_x && y == s_y) ans = time;
            }
            if(ans > -1) break;
        }

        sb.append(ans);
        
        System.out.print(sb);
    }

    static int toIdx(String str){
        switch(str){
            case "E": return 0;
            case "S": return 1;
            case "W": return 2;
            case "N": return 3;
        }

        return 0;
    }
}