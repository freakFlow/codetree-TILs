import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};
    static final int SIZE = 4001;

    static int T;
    static int N;
    static Marble[] marble;
    static boolean[] isDead;
    static int[][] arr;
    static int lastTime;

    public static void main(String[] args) throws IOException{
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            marble = new Marble[N+1];
            isDead = new boolean[N+1];
            arr = new int[SIZE][SIZE];
            lastTime = -1;

            for(int n=1; n<=N; n++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken()) * 2 + 2000;
                int c = Integer.parseInt(st.nextToken()) * 2 + 2000;
                int w = Integer.parseInt(st.nextToken());
                int d = toDir(st.nextToken());

                marble[n] = new Marble(r, c, w, d);
            }

            for(int time=1; time<SIZE; time++){
                for(int n=1; n<=N; n++){
                    // 죽은 구슬이면 패스
                    if(isDead[n]) continue;

                    // 산 구슬 이동
                    marble[n].move();

                    int nr = marble[n].r;
                    int nc = marble[n].c;
                    // 만약 범위를 벗어났으면 죽은 구슬로 체크
                    if(!isIn(nr, nc)) {
                        isDead[n] = true;
                        continue;
                    }
                    
                    // 이미 격자에 다른 구슬이 있으면 비교
                    int idx = arr[nr][nc];
                    if(idx > 0 && idx < n){
                        lastTime = time;

                        if(marble[n].w >= marble[idx].w){
                            arr[nr][nc] = n;
                            isDead[idx] = true;
                        }else{
                            isDead[n] = true;
                        }
                    }else{
                        arr[nr][nc] = n;
                    }
                }
            }

            sb.append(lastTime).append('\n');
        }

        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<SIZE && c>=0 && c<SIZE;
    }

    static int toDir(String str){
        switch(str){
            case "U": return 0;
            case "R": return 1;
            case "D": return 2;
            case "L": return 3;
        }

        return -1;
    }

    static class Marble{
        int r, c, w, d;

        Marble(int r, int c, int w, int d){
            this.r = r;
            this.c = c;
            this.w = w;
            this.d = d;
        }

        void move(){
            r += dr[d];
            c += dc[d];
        }
    }
}