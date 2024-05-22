import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int BLANK = 0;

    static int N, M, K;
    static int[][] arr;
    static int[] height;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) - 1;
        arr = new int[N][N];
        height = new int[N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int c=0; c<N; c++){
            int h = 0;
            for(int r=0; r<N; r++){
                if(arr[r][c] == BLANK) continue;
                h++;
            }
            height[c] = h;
        }

        int maxHeight = 0;
        for(int c=K; c<K+M; c++){
            maxHeight = Math.max(maxHeight, height[c]);
        }

        for(int c=K; c<K+M; c++){
            arr[N - 1 - maxHeight][c] = 1;
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                sb.append(arr[r][c]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}