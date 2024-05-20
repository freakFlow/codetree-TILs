import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N;
    static int[][] arr;
    static int bomb_r, bomb_c;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        bomb_r = Integer.parseInt(st.nextToken()) - 1;
        bomb_c = Integer.parseInt(st.nextToken()) - 1;

        int bomb = arr[bomb_r][bomb_c];
        arr[bomb_r][bomb_c] = 0;
        for(int b=1; b<bomb; b++){
            for(int d=0; d<dr.length; d++){
                int nr = bomb_r + dr[d] * b;
                int nc = bomb_c + dc[d] * b;

                if(isIn(nr, nc)) arr[nr][nc] = 0;
            }
        }

        int[][] temp = new int[N][N];
        for(int c=0; c<N; c++){
            int tr = N - 1;
            for(int r=N-1; r>=0; r--){
                if(arr[r][c] == 0) continue;
                temp[tr--][c] = arr[r][c];
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                sb.append(temp[r][c]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}