import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int N;
    static int[][] arr;
    static int[][] temp;
    static int mr, mc;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        temp = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        mr = Integer.parseInt(st.nextToken()) - 1;
        mc = Integer.parseInt(st.nextToken()) - 1;

        int bomb = arr[mr][mc];
        arr[mr][mc] = 0;
        for(int b=1; b<bomb; b++){
            for(int d=0; d<dr.length; d++){
                int nr = mr + dr[d] * b;
                int nc = mc + dc[d] * b;
                if(isIn(nr, nc)) arr[nr][nc] = 0;
            }
        }

        for(int c=0; c<N; c++){
            int tempR = N - 1;
            for(int r=N-1; r>=0; r--){
                if(arr[r][c] == 0) continue;
                temp[tempR--][c] = arr[r][c]; 
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                arr[r][c] = temp[r][c];
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

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}