import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int N, M;
    static int r, c, d;
    static int[][] ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = new int[N][M];

        ans[r][c] = 1;
        for(int i=2; i<=N*M; i++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(isIn(nr, nc) && ans[nr][nc] == 0){
                ans[nr][nc] = i;
                r = nr;
                c = nc;
            }else{
                d = (d + 1) % 4;
                i--;
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                sb.append(ans[r][c]).append(' ');
            }
            sb.append('\n');
        }
        
        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<M;
    }
}