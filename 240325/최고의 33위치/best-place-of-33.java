import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] arr;
    static int maxCoin;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        maxCoin = Integer.MIN_VALUE;

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r=0; r<N; r++){
            if(r + 2 >= N) continue;
            for(int c=0; c<N; c++){
                if(c + 2 >= N) continue;
                boxing(r, c);
            }
        }

        sb.append(maxCoin);

        System.out.print(sb);
    }

    static void boxing(int row, int col){
        int sum = 0;
        for(int r=row; r<row+3; r++){
            for(int c=col; c<col+3; c++){
                sum += arr[r][c];
            }
        }

        maxCoin = Math.max(maxCoin, sum);
    }
}