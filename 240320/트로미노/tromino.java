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
    static int max;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                sum1(r, c);
                sum2(r, c);
            }
        }

        sb.append(max);

        System.out.print(sb);
    }

    static void sum1(int row, int col){
        int sum = 0;
        for(int c=col; c<col+3; c++){
            if(!isIn(row, c)){
                sum = 0;
                break;
            }
            sum += arr[row][c];
        }
        max = Math.max(max, sum);
        
        sum = 0;
        for(int r=row; r<row+3; r++){
            if(!isIn(r, col)){
                sum = 0;
                break;
            }
            sum += arr[r][col];
        }
        max = Math.max(max, sum);
    }

    static void sum2(int row, int col){
        for(int d=0; d<dr.length; d++){
            int nr = row + dr[d];
            int nc = col + dc[d];
            int nd = (d + 1) % 4;
            int nnr = row + dr[nd];
            int nnc = col + dc[nd];
            if(!isIn(nr, nc) || !isIn(nnr, nnc)){
                continue;
            }
            max = Math.max(max, arr[row][col] + arr[nr][nc] + arr[nnr][nnc]);
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<M;
    }
}