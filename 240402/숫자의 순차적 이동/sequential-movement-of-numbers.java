import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dc = {1, 0, -1, 0, -1, 1, -1, 1};

    static int N, M;
    static int[][] arr;
    static Position[] position;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        position = new Position[N * N + 1];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
                position[arr[r][c]] = new Position(r, c);
            }
        }

        for(int m=0; m<M; m++){
            for(int p=1; p<position.length; p++){
                int r = position[p].r;
                int c = position[p].c;

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

                Position pos = position[arr[r][c]];
                position[arr[r][c]] = position[max];
                position[max] = pos;

                arr[mr][mc] = arr[r][c];
                arr[r][c] = max;
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

    static class Position{
        int r, c;
        
        Position(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}