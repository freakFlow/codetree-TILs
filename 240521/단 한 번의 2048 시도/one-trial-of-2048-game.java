import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int N = 4;

    static int[][] arr;
    static String dir;


    public static void main(String[] args) throws IOException {
        arr = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dir = br.readLine();

        switch(dir){
            case "L": rotateRight();
            case "U": rotateRight();
            case "R": rotateRight();
        }

        int[][] temp = new int[N][N];
        for(int c=0; c<N; c++){
            int tr = N-1;
            for(int r=N-1; r>=0; r--){
                if(arr[r][c] == 0) continue;
                temp[tr--][c] = arr[r][c];
            }

            for(int r=N-1; r>0; r--){
                if(temp[r][c] == temp[r-1][c]){
                    temp[r][c] *= 2;
                    temp[r-1][c] = 0;
                }
            }

            tr = N-1;
            for(int r=N-1; r>=0; r--){
                if(temp[r][c] == 0) continue;
                arr[tr--][c] = temp[r][c];
            }

            for(int r=tr; r>=0; r--){
                arr[r][c] = 0;
            }
        }
        
        switch(dir){
            case "R": rotateRight();
            case "U": rotateRight();
            case "L": rotateRight();
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                sb.append(arr[r][c]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void rotateRight(){
        int[][] temp = new int[N][N];

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
}