import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int N, M;
    static int[][] arr;
    static int bombCol;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int m=0; m<M; m++){
            bombCol = Integer.parseInt(br.readLine()) - 1;

            bomb();

            drop();
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                sb.append(arr[r][c]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void bomb(){
        int br = -1;
        int bc = bombCol;

        for(int r=0; r<N; r++){
            if(arr[r][bc] > 0){
                br = r;
                break;
            }
        }

        if(br == -1) return;

        int bombSize = arr[br][bc];
        arr[br][bc] = 0;

        for(int bs=1; bs<bombSize; bs++){
            for(int d=0; d<dr.length; d++){
                int nr = br + dr[d] * bs;
                int nc = bc + dc[d] * bs;

                if(isIn(nr, nc)){
                    arr[nr][nc] = 0;
                }
            }
        }
    }

    static boolean isIn(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }

    static void drop(){
        int[] temp;
        int idx;

        for(int c=0; c<N; c++){
            temp = new int[N];
            idx = N-1;

            for(int r=N-1; r>=0; r--){
                if(arr[r][c] == 0) continue;
                temp[idx--] = arr[r][c];
            }

            for(int r=N-1; r>=0; r--){
                arr[r][c] = temp[r];
            }
        }
    }
}