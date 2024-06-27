import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[][] arr;
    static Info[][] ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        ans = new Info[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        ans[0][0] = new Info(arr[0][0], arr[0][0]);
        for(int c=1; c<N; c++){
            ans[0][c] = ans[0][c-1].getClone();
            ans[0][c].update(arr[0][c]);
        }
        for(int r=1; r<N; r++){
            ans[r][0] = ans[r-1][0].getClone();
            ans[r][0].update(arr[r][0]);
        }

        for(int r=1; r<N; r++){
            for(int c=1; c<N; c++){
                Info option1 = ans[r-1][c].getClone();
                option1.update(arr[r][c]);
                Info option2 = ans[r][c-1].getClone();
                option2.update(arr[r][c]);
                ans[r][c] = option1.diff < option2.diff ? option1 : option2;
            }
        }

        sb.append(ans[N-1][N-1].diff);

        System.out.print(sb);
    }

    static class Info{
        int min, max, diff;

        Info(int min, int max){
            this.min = min;
            this.max = max;
            diff = max - min;
        }

        void update(int num){
            min = Math.min(min, num);
            max = Math.max(max, num);
            diff = max - min;
        }

        Info getClone(){
            return new Info(this.min, this.max);
        }
    }
}