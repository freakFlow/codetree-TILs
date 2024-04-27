import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int LEFT = 0, RIGHT = 1;
    static int N, M, Q;
    static int[][] arr;
    static int r, d;

    public static void main(String[] args) throws IOException{
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
            r = Integer.parseInt(st.nextToken()) - 1;
            d = st.nextToken().equals("L") ? LEFT : RIGHT;

            shift(r, d);

            int row = r;
            int dir = d;
            while(row>0 && check(row, row-1)){
                row--;
                dir = 1 - dir;
                shift(row, dir);
            }
            row = r;
            dir = d;
            while(row<N-1 && check(row, row+1)){
                row++;
                dir = 1 - dir;
                shift(row, dir);
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                sb.append(arr[r][c]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static boolean check(int row, int to){
        for(int c=0; c<M; c++){
            if(arr[row][c] == arr[to][c]) return true;
        }

        return false;
    }

    static void shift(int row, int wind){
        if(wind == LEFT) shiftLeft(row);
        else shiftRight(row);
    }

    static void shiftLeft(int row){
        int temp = arr[row][M-1];
        
        for(int c=M-1; c>0; c--){
            arr[row][c] = arr[row][c-1];
        }
        arr[row][0] = temp;
    }

    static void shiftRight(int row){
        int temp = arr[row][0];

        for(int c=0; c<M-1; c++){
            arr[row][c] = arr[row][c+1];
        }
        arr[row][M-1] = temp;
    }
}