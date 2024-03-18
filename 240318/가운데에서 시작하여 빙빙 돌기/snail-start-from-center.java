import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    static int[][] arr;
    static int x, y, d;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        x = y = N / 2;
        arr[x][y] = 1;

        for(int i=2; i<=N*N; i++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            int nd = (d - 1 + 4) % 4;
            int nnx = nx + dx[nd];
            int nny = ny + dy[nd];
            x = nx;
            y = ny;
            arr[x][y] = i;
            if(arr[nnx][nny] == 0){
                d = nd;
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                sb.append(arr[r][c]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<N;
    }
}