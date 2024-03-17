import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int N;
    static char[][] mirror;
    static int K;
    static int r, c, d;
    static int ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        mirror = new char[N][N];
        for(int r=0; r<N; r++){
            String str = br.readLine();
            for(int c=0; c<N; c++){
                mirror[r][c] = str.charAt(c);
            }
        }
        K = Integer.parseInt(br.readLine()) - 1;

        d = K / N;
        if(d == 0){
            r = 0;
            c = K % N;
        }else if(d == 1){
            r = K % N;
            c = N - 1;
        }else if(d == 2){
            r = N - 1;
            c = K % N;
        }else{
            r = K % N;
            c = 0;
        }

        while(isIn(r, c)){
            if(mirror[r][c] == '/'){
                if(d == 0 || d == 2) d = (d + 1) % 4;
                else d = (d - 1 + 4) % 4;
            }else{
                if(d == 0 || d == 2) d = (d - 1 + 4) % 4;
                else d = (d + 1) % 4;
            }
            r += dr[d];
            c += dc[d];
            ans++;
        }

        sb.append(ans);
        
        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}