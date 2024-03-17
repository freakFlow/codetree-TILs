import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int N, M;
    static int[][] arr;
    static int row, col, d;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                arr[r][c] = -1;
            }
        }
        
        arr[row][col] = 0;
        for(int i=1; i<N*M; i++){
            int nr = row + dr[d];
            int nc = col + dc[d];
            if(!isIn(nr, nc) || arr[nr][nc] > -1){
                i--;
                d = (d + 1) % 4;
                continue;
            }
            row = nr;
            col = nc;
            arr[row][col] = i % 26;
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                sb.append((char)('A' + arr[r][c])).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<M;
    }
}