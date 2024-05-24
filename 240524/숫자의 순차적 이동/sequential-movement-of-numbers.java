import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};

    static int N, M;
    static int numSize;
    static int[][] arr;
    static Info[] position;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numSize = N * N;
        arr = new int[N][N];
        position = new Info[numSize + 1];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                int num = Integer.parseInt(st.nextToken());
                arr[r][c] = num;
                position[num] = new Info(r, c);
            }
        }

        for(int m=0; m<M; m++){
            for(int num=1; num<=numSize; num++){
                Info numPos = position[num];
                int r = numPos.r;
                int c = numPos.c;

                int max = 0, mr = 0, mc = 0;
                for(int d=0; d<dr.length; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if(isIn(nr, nc) && arr[nr][nc] > max){
                        max = arr[nr][nc];
                        mr = nr;
                        mc = nc;
                    }
                }

                arr[mr][mc] = num;
                arr[r][c] = max;

                position[num] = position[max];
                position[max] = numPos;
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

    static class Info{
        int r, c;

        Info(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}