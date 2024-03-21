import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[][] arr;
    static int sr, sc, er, ec;
    static int max1, max2;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }


        max1 = max2 = Integer.MIN_VALUE;
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                findMax1(r, c);
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(pass(r, c)) continue;
                findMax2(r, c);
            }
        }

        sb.append(max1 + max2);

        System.out.print(sb);
    }

    static void findMax1(int row, int col){
        for(int r=row; r<N; r++){
            for(int c=col; c<M; c++){
                int sum = getSum(row, col, r, c);
                if(sum > max1){
                    max1 = sum;
                    sr = row;
                    sc = col;
                    er = r;
                    ec = c;
                }
            }
        }
    }

    static void findMax2(int row, int col){
        for(int r=row; r<N; r++){
            for(int c=col; c<M; c++){
                max2 = Math.max(max2, getSum(row, col, r, c));
            }
        }
    }

    static int getSum(int sr, int sc, int er, int ec){
        int sum = 0;
        for(int r=sr; r<=er; r++){
            for(int c=sc; c<=ec; c++){
                sum += arr[r][c];
            }
        }

        return sum;
    }

    static boolean pass(int r, int c){
        return r>=sr && r<=er && c>=sc && c<=ec;
    }
}