import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static int N, M, T;
    static int[][] arr;
    static int[][] marble;
    static int count;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        marble = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            marble[r][c] = 1;
        }

        for(int t=0; t<T; t++){
            int[][] temp = new int[N][N];

            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(marble[r][c] == 0) continue;

                    int mr = 0;
                    int mc = 0;
                    int max = 0;

                    for(int d=0; d<dr.length; d++){
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if(isIn(nr, nc) && arr[nr][nc] > max){
                            max = arr[nr][nc];
                            mr = nr;
                            mc = nc;
                        }
                    }
                    temp[mr][mc]++;
                }
            }

            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(temp[r][c] == 1) marble[r][c] = 1;
                    else marble[r][c] = 0;
                }
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(marble[r][c] > 0) count++;
            }
        }

        sb.append(count);

        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}