import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int N, T;
    static int[][] arr;
    static String str;
    static int row, col, d;
    static int sum;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        str = br.readLine();
        arr = new int[N][N];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        row = col = N / 2;
        d = 3;
        sum = arr[row][col];

        for(int t=0; t<T; t++){
            switch(str.charAt(t)){
                case 'L':
                    d = (d - 1 + 4) % 4; break;
                case 'R':
                    d = (d + 1) % 4; break;
                case 'F':
                    int nr = row + dr[d];
                    int nc = col + dc[d];
                    if(isIn(nr, nc)){
                        row = nr;
                        col = nc;
                        sum += arr[row][col];
                    }
            }
        }

        sb.append(sum);

        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}