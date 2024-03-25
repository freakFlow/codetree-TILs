import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int N, M, Q;
    static int[][] arr;
    static int[][] temp;
    static int r1, c1, r2, c2;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        temp = new int[N][M];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken()) - 1;
            c1 = Integer.parseInt(st.nextToken()) - 1;
            r2 = Integer.parseInt(st.nextToken()) - 1;
            c2 = Integer.parseInt(st.nextToken()) - 1;
            rotate();
            calAvg();
        }

        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                sb.append(arr[n][m]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void rotate(){
        int size = (r2 - r1 + c2 - c1) * 2;
        int[] part = new int[size];

        int r = r1, c = c1, d = 0;
        part[0] = arr[r][c];
        for(int i=1; i<size; i++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(isInBox(nr, nc)){
                r = nr;
                c = nc;
                part[i] = arr[r][c];
            }else{
                i--;
                d = (d + 1) % 4;
            }
        }

        int end = part[size - 1];
        for(int i=size-1; i>0; i--){
            part[i] = part[i-1];
        }
        part[0] = end;

        r = r1; 
        c = c1; 
        d = 0;
        arr[r][c] = part[0];
        for(int i=1; i<size; i++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(isInBox(nr, nc)){
                r = nr;
                c = nc;
                arr[r][c] = part[i];
            }else{
                i--;
                d = (d + 1) % 4;
            }
        }
    }

    static boolean isInBox(int r, int c){
        return r>=r1 && r<=r2 && c>=c1 && c<=c2;
    }

    static void calAvg(){
        for(int r=r1; r<=r2; r++){
            for(int c=c1; c<=c2; c++){
                int div = 1;
                int sum = arr[r][c];
                for(int d=0; d<dr.length; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(!isIn(nr, nc)) continue;
                    div++;
                    sum += arr[nr][nc];
                }
                temp[r][c] = sum / div;
            }
        }

        for(int r=r1; r<=r2; r++){
            for(int c=c1; c<=c2; c++){
                arr[r][c] = temp[r][c];
            }
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<M;
    }
}