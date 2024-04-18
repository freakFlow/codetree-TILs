import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] dr = {{1, 1}, {0, -1}, {0, 1}, {0, 1}, {0, 0}, {1, 2}};
    static int[][] dc = {{0, 1}, {1, 1}, {1, 1}, {1, 0}, {1, 2}, {0, 0}};

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
                for(int d=0; d<dr.length; d++){
                    int sum = arr[r][c];
                    boolean in = true;
                    for(int i=0; i<2; i++){
                        int nr = r + dr[d][i];
                        int nc = c + dc[d][i];
                        if(isIn(nr, nc)) sum += arr[nr][nc];
                        else in = false;
                    }

                    if(in) max = Math.max(max, sum);
                }
            }
        }

        sb.append(max);

        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<M;
    }
}