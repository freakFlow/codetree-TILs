import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[][] arr;
    static int ans;

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

        for(int r=0; r<N; r++){
            int now = arr[r][0];
            int count = 1;
            boolean isHappy = false;
            for(int c=1; c<N; c++){
                if(arr[r][c] == now){
                    count++;
                    continue;
                }

                if(count >= M) isHappy = true;
                now = arr[r][c];
                count = 1;
            }

            if(count >= M) isHappy = true;
            if(isHappy) ans++;
        }

        for(int c=0; c<N; c++){
            int now = arr[0][c];
            int count = 1;
            boolean isHappy = false;
            for(int r=1; r<N; r++){
                if(arr[r][c] == now){
                    count++;
                    continue;
                }

                if(count >= M) isHappy = true;
                now = arr[r][c];
                count = 1;
            }

            if(count >= M) isHappy = true;
            if(isHappy) ans++;
        }

        sb.append(ans);

        System.out.print(sb);
    }
}