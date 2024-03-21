import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {-1, -1, 1, 1};
    static int[] dc = {1, -1, -1, 1};
    static int N;
    static int[][] arr;
    static int sr, sc;
    static int ans;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                sr = r;
                sc = c;
                draw(r, c, 0, 0);
            }
        }

        sb.append(ans);

        System.out.print(sb);
    }

    static void draw(int r, int c, int d, int sum){
        int nr = r + dr[d];
        int nc = c + dc[d];

        if(!isIn(nr,nc)) return;

        sum += arr[nr][nc];
        if(d == 3 && nr == sr && nc == sc){
            ans = Math.max(ans, sum);
            return;
        }

        draw(nr, nc, d, sum);
        if(d < 3) draw(nr, nc, d + 1, sum);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}