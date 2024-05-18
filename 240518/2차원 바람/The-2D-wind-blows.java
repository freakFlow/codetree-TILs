import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N, M, Q;
    static int[][] arr;
    static Info start, end;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken()) - 1;
            int sc = Integer.parseInt(st.nextToken()) - 1;
            int er = Integer.parseInt(st.nextToken()) - 1;
            int ec = Integer.parseInt(st.nextToken()) - 1;
            start = new Info(sr, sc);
            end = new Info(er, ec);

            rotate();
            convert();
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                sb.append(arr[r][c]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void rotate(){
        int r = start.r;
        int c = start.c;
        int temp = arr[r][c];
        
        int d = 1;
        while(true){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(!isIn(nr, nc) || outOfRange(nr, nc)){
                d = (d - 1 + 4) % 4;
                continue;
            }

            arr[r][c] = arr[nr][nc];
            r = nr;
            c = nc;

            if(r == start.r && c == start.c) break;
        }

        arr[start.r][start.c+1] = temp;
    }

    static void convert(){
        int[][] temp = new int[N][M];

        for(int r=start.r; r<=end.r; r++){
            for(int c=start.c; c<=end.c; c++){
                int sum = arr[r][c];
                int count = 1;
                for(int d=0; d<dr.length; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(isIn(nr, nc)){
                        sum += arr[nr][nc];
                        count++;
                    }
                }

                temp[r][c] = sum / count;
            }
        }

        for(int r=start.r; r<=end.r; r++){
            for(int c=start.c; c<=end.c; c++){
                arr[r][c] = temp[r][c];
            }
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<M;
    }

    static boolean outOfRange(int r, int c){
        return r<start.r || r>end.r || c<start.c || c>end.c;
    }

    static class Info{
        int r, c;

        Info(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}