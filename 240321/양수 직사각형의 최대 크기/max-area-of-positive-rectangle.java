import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[][] arr;
    static int maxSize;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        maxSize = -1;

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        for(int sr=0; sr<N; sr++){
            for(int sc=0; sc<M; sc++){
                for(int er=sr; er<N; er++){
                    for(int ec=sc; ec<M; ec++){
                        if(hasOnlyPositive(sr, sc, er, ec)) maxSize = Math.max(maxSize, getSize(sr, sc, er, ec));
                    }
                }
            }
        }

        sb.append(maxSize);

        System.out.print(sb);
    }

    static boolean hasOnlyPositive(int sr, int sc, int er, int ec){
        for(int r=sr; r<=er; r++){
            for(int c=sc; c<=ec; c++){
                if(arr[r][c] < 1) return false;
            }
        }

        return true;
    }

    static int getSize(int sr, int sc, int er, int ec){
        return (er - sr + 1) * (ec - sc + 1);
    }
}