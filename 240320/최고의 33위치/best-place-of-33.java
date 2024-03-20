import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] arr;
    static int max;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r=0; r<N; r++){
            if(r + 3 > N) continue;
            for(int c=0; c<N; c++){
                if(c + 3 > N) continue;
                max = Math.max(max, countCoins(r, c));
            }
        }

        sb.append(max);

        System.out.print(sb);
    }

    static int countCoins(int row, int col){
        int coin = 0;
        for(int r=row; r<row+3; r++){
            for(int c=col; c<col+3; c++){
                coin += arr[r][c];
            }
        }

        return coin;
    }
}