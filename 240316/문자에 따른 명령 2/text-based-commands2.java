import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int x, y;
    static int to;
    static String str;

    public static void main(String[] args) throws IOException {
        str = br.readLine();
        
        for(char ch : str.toCharArray()){
            switch(ch){
                case 'L':
                    to = (to - 1 + 4) % 4; break;
                case 'R':
                    to = (to + 1) % 4; break;
                case 'F':
                    x += dx[to];
                    y += dy[to];
            }
        }

        sb.append(x).append(' ').append(y);

        System.out.print(sb);
    }
}