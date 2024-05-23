import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final char WALL = '#';

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int N;
    static int sr, sc, sd;
    static char [][] arr;
    static int ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        sd = 0;
        arr = new char[N][N];

        for(int r=0; r<N; r++){
            String row = br.readLine();
            for(int c=0; c<N; c++){
                arr[r][c] = row.charAt(c);
            }
        }

        int curr_r = sr, curr_c = sc, curr_d = sd;

        while(true){
            int nr = curr_r + dr[curr_d];
            int nc = curr_c + dc[curr_d];

            // 1. 격자 밖으로 탈출
            if(!isIn(nr, nc)){
                ans++;
                break;
            }

            // 2. 벽인 경우 반시계 회전
            if(arr[nr][nc] == WALL){
                curr_d = (curr_d - 1 + 4) % 4;
            }else{
                // 3. 이동
                curr_r = nr;
                curr_c = nc;
                ans++;

                // 4. 오른쪽 벽이 없으면 시계 회전
                int right_d = (curr_d + 1) % 4;
                int right_r = curr_r + dr[right_d];
                int right_c = curr_c + dc[right_d];

                if(!isIn(right_r, right_c) || arr[right_r][right_c] != WALL) curr_d = right_d;
            }

            // 처음위치로 되돌아왔는지 체크
            if(curr_r==sr && curr_c==sc && curr_d==sd){
                ans = -1;
                break;
            }
        }

        sb.append(ans);

        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}