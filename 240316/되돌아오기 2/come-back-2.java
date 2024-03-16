import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static String order;
    static int x, y, d;
    static int time;
    static int ans;

    public static void main(String[] args) throws IOException {
        order = br.readLine();
        d = 3;
        ans = -1;

        for(char ch : order.toCharArray()){
            switch(ch){
                case 'L':
                    d = (d - 1 + 4) % 4; break;
                case 'R':
                    d = (d + 1) % 4; break;
                case 'F':
                    x += dx[d];
                    y += dy[d];
            }
            time++;
            if(x == 0 && y == 0){
                ans = time;
                break;
            }
        }

        sb.append(ans);
        
        System.out.print(sb);
    }
}