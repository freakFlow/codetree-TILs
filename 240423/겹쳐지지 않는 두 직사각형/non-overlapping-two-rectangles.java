import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[][] arr;
    static Info s1, e1, s2, e2;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        makeRectangle1();

        sb.append(max);

        System.out.print(sb);
    }

    static void makeRectangle1(){
        for(int r1=0; r1<N; r1++){
            for(int c1=0; c1<M; c1++){
                s1 = new Info(r1, c1);
                for(int r2=r1; r2<N; r2++){
                    for(int c2=c1; c2<M; c2++){
                        e1 = new Info(r2, c2);
                        makeRectangel2();
                    }
                }
            }
        }
    }

    static void makeRectangel2(){
        for(int r1=0; r1<N; r1++){
            for(int c1=0; c1<M; c1++){
                s2 = new Info(r1, c1);
                for(int r2=r1; r2<N; r2++){
                    for(int c2=c1; c2<M; c2++){
                        e2 = new Info(r2, c2);
                        if(!overlapped()){
                            max = Math.max(max, getSum());
                        }
                    }
                }
            }
        }
    }

    static boolean overlapped(){
        boolean[][] overlap = new boolean[N][M];
        for(int r=s1.r; r<=e1.r; r++){
            for(int c=s1.c; c<=e1.c; c++){
                overlap[r][c] = true;
            }
        }

        for(int r=s2.r; r<=e2.r; r++){
            for(int c=s2.c; c<=e2.c; c++){
                if(overlap[r][c]) return true;
            }
        }

        return false;
    }

    static int getSum(){
        int sum = 0;
        for(int r=s1.r; r<=e1.r; r++){
            for(int c=s1.c; c<=e1.c; c++){
                sum += arr[r][c];
            }
        }
        for(int r=s2.r; r<=e2.r; r++){
            for(int c=s2.c; c<=e2.c; c++){
                sum += arr[r][c];
            }
        }

        return sum;
    }

    static class Info{
        int r, c;

        Info(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}