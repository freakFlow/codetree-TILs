import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int BOMB = 0;

    static int N, M, K;
    static int[][] arr;
    static int ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0; k<K; k++){
            while(bomb()){
                gravity();
            }
            rotateRight();
            gravity();
        }

        if(bomb()) gravity();

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(arr[r][c] == BOMB) continue;
                ans++;
            }
        }

        sb.append(ans);

        System.out.print(sb);
    }

    static boolean bomb(){
        boolean hasBomb = false;

        for(int c=0; c<N; c++){
            int start = N-1;
            int count = 1;
            if(arr[start][c] == BOMB) continue;

            for(int r=N-2; r>=0; r--){
                if(arr[r][c] == BOMB) break;

                if(arr[r][c] == arr[start][c]){
                    count++;
                    continue;
                }

                if(count >= M){
                    hasBomb = true;
                    for(int i=start; i>r; i--){
                        arr[i][c] = BOMB;
                    }
                }

                start = r;
                count = 1;
            }

            if(count >= M){
                hasBomb = true;
                for(int i=start; i>=0; i--){
                    arr[i][c] = BOMB;
                }
            }
        }

        return hasBomb;
    }

    static void gravity(){
        int[][] temp = new int[N][N];

        for(int c=0; c<N; c++){
            int tr = N-1;
            for(int r=N-1; r>=0; r--){
                if(arr[r][c] == BOMB) continue;

                temp[tr--][c] = arr[r][c];
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                arr[r][c] = temp[r][c];
            }
        }
    }

    static void rotateRight(){
        int[][] temp = new int[N][N];

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                temp[c][N-1-r] = arr[r][c];
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                arr[r][c] = temp[r][c];
            }
        }
    }
}