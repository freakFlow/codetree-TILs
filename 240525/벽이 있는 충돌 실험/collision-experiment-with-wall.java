import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int T;
    static int N, M;
    static Info[] marble;
    static boolean[] isBroken;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            marble = new Info[M+1];
            isBroken = new boolean[M+1];

            for(int m=1; m<=M; m++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                int d = getDir(st.nextToken());
                marble[m] = new Info(r, c, d);
            }

            for(int n=0; n<2*N; n++){
                arr = new int[N][N];

                // 1. 깨지지 않은 구슬 움직이기
                for(int m=1; m<=M; m++){
                    if(isBroken[m]) continue;
                    
                    Info curr = marble[m];
                    int nr = curr.r + dr[curr.d];
                    int nc = curr.c + dc[curr.d];

                    if(isIn(nr, nc)){
                        curr.r = nr;
                        curr.c = nc;
                    }else{
                        curr.d = (curr.d - 2 + 4) % 4;
                    }

                    // 2. 겹치는 지 확인
                    int num = arr[curr.r][curr.c];
                    if(num == 0) arr[curr.r][curr.c] = m;
                    else{
                        isBroken[m] = true;
                        if(num > 0){
                            isBroken[num] = true;
                            arr[curr.r][curr.c] = -1;
                        }
                    }
                }
            }

            int count = 0;
            for(int m=1; m<=M; m++){
                if(!isBroken[m]) count++;
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static int getDir(String str){
        switch(str){
            case "R": return 0;
            case "D": return 1;
            case "L": return 2;
            case "U": return 3;
        }

        return -1;
    }

    static class Info{
        int r, c, d;

        Info(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}