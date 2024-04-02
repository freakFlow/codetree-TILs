import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};
    static final int BLANK = 0, SLASH = 1, BSLASH = 2;

    static int N;
    static int[][] arr;
    static int sr, sc, sd;
    static int time;
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
            // 1. 오른쪽에서 시작
            sr = r;
            sc = N;
            sd = 2;
            time = 0;

            start();

            // 2. 왼쪽에서 시작
            sr = r;
            sc = -1;
            sd = 0;
            time = 0;
            
            start();
        }

        for(int c=0; c<N; c++){
            // 3. 위쪽에서 시작
            sr = -1;
            sc = c;
            sd = 1;
            time = 0;

            start();

            // 4. 아래에서 시작
            sr = N;
            sc = c;
            sd = 3;
            time = 0;

            start();
        }

        sb.append(max);

        System.out.print(sb);
    }

    static void start(){
        while(true){
            sr += dr[sd];
            sc += dc[sd];
            time++;

            // 격자를 벗어난 경우 끝
            if(!isIn(sr, sc)) break;

            // 빈 칸이 경우 그대로 진행
            if(arr[sr][sc] == BLANK) continue;

            // 칸막이가 있는 경우 방향 바꾸기
            if(arr[sr][sc] == SLASH) sd = 3 - sd;
            else if(sd < 2) sd = 1 - sd;
            else sd = 5 - sd;
        }

        max = Math.max(max, time);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}