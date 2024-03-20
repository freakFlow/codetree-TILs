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
            if(isHappyRow(r)) ans++;
        }

        for(int c=0; c<N; c++){
            if(isHappyCol(c)) ans++;
        }

        sb.append(ans);

        System.out.print(sb);
    }

    static boolean isHappyRow(int row){
        int before = arr[row][0];
        int cnt = 1;
        if(cnt == M) return true;
        for(int c=1; c<N; c++){
            if(arr[row][c] == before){
                cnt++;
                if(cnt == M) return true;
            }else{
                before = arr[row][c];
                cnt = 1;
            }
        }
        return false;
    }

    static boolean isHappyCol(int col){
        int before = arr[0][col];
        int cnt = 1;
        if(cnt == M) return true;
        for(int r=1; r<N; r++){
            if(arr[r][col] == before){
                cnt++;
                if(cnt == M) return true;
            }else{
                before = arr[r][col];
                cnt = 1;
            }
        }
        return false;
    }
}