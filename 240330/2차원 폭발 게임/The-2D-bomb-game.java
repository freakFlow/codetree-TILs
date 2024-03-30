import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;
    static int[][] arr;
    static int[][] temp;
    static int ans;

    public static void main(String[] args) throws IOException{
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
                drop();
            }
            rotate();
            drop();
        }

        bomb();

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(arr[r][c] > 0) ans++;
            }
        }

        sb.append(ans);

        System.out.print(sb);
    }

    static boolean bomb(){
        boolean keepGoing = false;

        for(int c=0; c<N; c++){
            int sr = 0;
            int er = 0;

            for(; er<N; er++){
                if(arr[er][c] == arr[sr][c]) continue;

                if(arr[sr][c] > 0 && er - sr >= M){
                    for(int r=sr; r<er; r++){
                        arr[r][c] = 0;
                        keepGoing = true;
                    }
                }

                sr = er;
            }

            if(arr[sr][c] > 0 && er - sr >= M){
                for(int r=sr; r<er; r++){
                    arr[r][c] = 0;
                    keepGoing = true;
                }
            }
        }

        return keepGoing;
    }

    static void drop(){
        temp = new int[N][N];

        for(int c=0; c<N; c++){
            int idx = N - 1;
            for(int r=N-1; r>=0; r--){
                if(arr[r][c] == 0) continue;
                temp[idx--][c] = arr[r][c];
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                arr[r][c] = temp[r][c];
            }
        }
    }

    static void rotate(){
        temp = new int[N][N];

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