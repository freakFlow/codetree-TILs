import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int N;
    static int[][] arr;
    static int[][] temp;
    static int max;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        temp = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                init();
                bomb(r, c);
                drop();
                check();
            }
        }

        sb.append(max);

        System.out.print(sb);
    }

    static void init(){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                temp[r][c] = arr[r][c];
            }
        }
    }

    static void bomb(int br, int bc){
        int bombSize = temp[br][bc];
        temp[br][bc] = 0;

        for(int bs=1; bs<bombSize; bs++){
            for(int d=0; d<dr.length; d++){
                int nr = br + dr[d] * bs;
                int nc = bc + dc[d] * bs;

                if(isIn(nr, nc)) temp[nr][nc] = 0;
            }
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static void drop(){
        for(int c=0; c<N; c++){
            int[] col = new int[N];
            int idx = N - 1;
            for(int r=N-1; r>=0; r--){
                if(temp[r][c] == 0) continue;
                col[idx--] = temp[r][c];
            }

            for(int r=N-1; r>=0; r--){
                temp[r][c] = col[r];
            }
        }
    }

    static void check(){
        int twin = 0;

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(temp[r][c] == 0) continue;
                for(int d=0; d<2; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(isIn(nr, nc) && temp[r][c] == temp[nr][nc]) twin++;
                }
            }
        }

        max = Math.max(max, twin);
    }
}