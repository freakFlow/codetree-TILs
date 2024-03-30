import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N = 4;
    static int[][] arr;
    static int[][] temp;
    static int dir;

    public static void main(String[] args) throws IOException{
        arr = new int[N][N];
        temp = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        String str = br.readLine();
        switch(str){
            case "L": dir = 3; break;
            case "U": dir = 2; break;
            case "R": dir = 1; break;
            default: dir = 0;
        }

        for(int i=0; i<dir; i++){
            rotate();
        }

        down();

        for(int i=0; i<N-dir; i++){
            rotate();
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                sb.append(arr[r][c]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void rotate(){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                temp[c][N-1-r] = arr[r][c];
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                arr[r][c] = temp[r][c];
            }
        }
    }

    static void down(){
        for(int c=0; c<N; c++){
            int[] col = new int[N];
            int idx = N-1;

            for(int r=N-1; r>=0; r--){
                if(arr[r][c] == 0) continue;
                col[idx--] = arr[r][c];
            }

            for(int r=N-1; r>=0; r--){
                arr[r][c] = col[r];
            }

            for(int r=N-1; r>0; r--){
                if(arr[r][c] == arr[r-1][c]){
                    arr[r][c] *= 2;
                    arr[r-1][c] = 0;
                }
            }

            col = new int[N];
            idx = N-1;
            for(int r=N-1; r>=0; r--){
                if(arr[r][c] == 0) continue;
                col[idx--] = arr[r][c];
            }

            for(int r=N-1; r>=0; r--){
                arr[r][c] = col[r];
            }
        }
    }
}