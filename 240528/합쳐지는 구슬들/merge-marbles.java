import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N, M, T;
    static Info[] marbles;
    static int[][] arr;
    static int count, max;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        marbles = new Info[M+1];

        for(int m=1; m<=M; m++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = getDir(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            marbles[m] = new Info(m, r, c, d, w);
        }

        for(int t=0; t<T; t++){
            arr = new int[N][N];

            for(int m=1; m<=M; m++){
                Info curr = marbles[m];
                if(curr.isBroken) continue;

                int nr = curr.r + dr[curr.d];
                int nc = curr.c + dc[curr.d];

                if(isIn(nr, nc)){
                    curr.r = nr;
                    curr.c = nc;
                }else{
                    curr.d = (curr.d + 2) % 4;
                }

                if(arr[curr.r][curr.c] > 0){
                    int idx = arr[curr.r][curr.c];
                    curr.w += marbles[idx].w;
                    marbles[idx].isBroken = true;
                }
                arr[curr.r][curr.c] = m;
            }
        }

        for(int m=1; m<=M; m++){
            Info curr = marbles[m];
            if(curr.isBroken) continue;
            
            count++;
            max = Math.max(max, curr.w);
        }

        sb.append(count).append(' ').append(max);

        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static int getDir(String str){
        switch(str){
            case "R" : return 0;
            case "D" : return 1;
            case "L" : return 2;
            case "U" : return 3;
        }

        return -1;
    }

    static class Info{
        int idx, r, c, d, w;
        boolean isBroken;

        Info(int idx, int r, int c, int d, int w){
            this.idx = idx;
            this.r = r;
            this.c = c;
            this.d = d;
            this.w = w;
            this.isBroken = false;
        }
    }
}