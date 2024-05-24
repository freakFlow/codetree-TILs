import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int BLANK = 0;

    static int[][] slashDir = {{}, {3, 2, 1, 0}, {1, 0, 3, 2}};
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N;
    static int[][] arr;
    static int ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r=0; r<N; r++){
            startSim(r, 0, 0);
            startSim(r, N-1, 2);
        }

        for(int c=0; c<N; c++){
            startSim(0, c, 1);
            startSim(N-1, c, 3);
        }

        sb.append(ans);

        System.out.print(sb);
    }

    static void startSim(int r, int c, int d){
        int time = 0;
        r -= dr[d];
        c -= dc[d];

        while(true){
            r += dr[d];
            c += dc[d];
            time++;

            if(!isIn(r, c)) break;
            
            if(arr[r][c] != BLANK){
                d = changeDir(d, arr[r][c]);
            }
        }

        ans = Math.max(ans, time);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static int changeDir(int dir, int slash){
        return slashDir[slash][dir];
    }
}