import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, 1, -1, 0};
    static int N, T;
    static int r, c, d;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = toIdx(st.nextToken());

        for(int t=0; t<T; t++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(isIn(nr, nc)){
                r = nr;
                c = nc;
            }else{
                d = 3 - d;
            }
        }

        sb.append(r).append(' ').append(c);
        
        System.out.print(sb);
    }

    static int toIdx(String str){
        switch(str){
            case "D": return 0;
            case "R": return 1;
            case "L": return 2;
            case "U": return 3;
            default: return 0;
        }
    }

    static boolean isIn(int r, int c){
        return r>0 && r<=N && c>0 && c<=N;
    }
}