import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N;
    static int sr, sc;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        arr = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        sb.append(arr[sr][sc]).append(' ');

        while(true){
            int mr = -1, mc = -1;

            for(int d=0; d<dr.length; d++){
                int nr = sr + dr[d];
                int nc = sc + dc[d];

                if(isIn(nr, nc) && arr[nr][nc] > arr[sr][sc]){
                    mr = nr;
                    mc = nc;
                    break;
                }
            }

            if(mr == -1) break;
            sb.append(arr[mr][mc]).append(' ');
            sr = mr;
            sc = mc;
        }

        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}