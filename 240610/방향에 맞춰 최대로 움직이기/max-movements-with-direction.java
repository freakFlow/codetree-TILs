import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dr = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 0, 1, 1, 1, 0, -1, -1, -1};

    static int N;
    static int[][] num, dir;
    static int ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        num = new int[N][N];
        dir = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                num[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                dir[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;

        start(r, c, 0);

        sb.append(ans);

        System.out.print(sb);
    }

    static void start(int r, int c, int count){
        int d = dir[r][c];
        int nr = r + dr[d];
        int nc = c + dc[d];

        while(isIn(nr, nc)){
            if(num[nr][nc] > num[r][c]) start(nr, nc, count + 1);

            nr += dr[d];
            nc += dc[d];
        }

        ans = Math.max(ans, count);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}