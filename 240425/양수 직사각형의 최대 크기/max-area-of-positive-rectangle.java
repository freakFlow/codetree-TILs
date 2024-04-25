import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[][] arr;
    static Info start, end;
    static int max = -1;

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

        getStartInfo();

        sb.append(max);

        System.out.print(sb);
    }

    static void getStartInfo(){
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(arr[r][c] <= 0) continue;
                start = new Info(r, c);
                getEndInfo();
            }
        }
    }

    static void getEndInfo(){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(arr[r][c] <= 0) continue;
                end = new Info(r, c);
                if(isNotEnd()) continue;

                check();
            }
        }
    }

    static boolean isNotEnd(){
        return end.r<start.r || (end.r==start.r && end.c<start.c);
    }

    static void check(){
        boolean isAllPositive = true;

        for(int r=start.r; r<=end.r; r++){
            for(int c=start.c; c<=end.c; c++){
                if(arr[r][c] <= 0) isAllPositive = false;
            }
        }

        if(isAllPositive) max = Math.max(max, (end.r-start.r + 1) * (end.c-start.c + 1));
    }

    static class Info{
        int r, c;

        Info(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}