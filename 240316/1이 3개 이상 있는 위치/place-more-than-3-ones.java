import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
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
            for(int c=0; c<N; c++){
                int cnt = 0;
                for(int d=0; d<dx.length; d++){
                    int nr = r + dx[d];
                    int nc = c + dy[d];
                    if(isIn(nr, nc) && arr[nr][nc] == 1) cnt++;
                }
                if(cnt >= 3) ans++;
            }
        }

        sb.append(ans);
        
        System.out.print(sb);
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}