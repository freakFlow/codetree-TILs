import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static Info[] lines;
    static int ans;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        lines = new Info[N];
        ans = 1;

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            lines[n] = new Info(x1, x2);
        }

        for(int i=N; i>1; i--){
            arr = new int[i];

            combination(0, 0);

            if(ans > 1) break;
        }

        sb.append(ans);

        System.out.print(sb);
    }

    static void combination(int idx, int start){
        if(idx == arr.length){
            check();
            return;
        }

        for(int i=start; i<N; i++){
            arr[idx] = i;
            combination(idx + 1, i + 1);
        }
    }

    static void check(){
        boolean[] temp = new boolean[1001];

        for(int i=0; i<arr.length; i++){
            Info line = lines[arr[i]];

            for(int x=line.x1; x<=line.x2; x++){
                if(temp[x]) return;

                temp[x] = true;
            }
        }

        ans = arr.length;
    }

    static class Info{
        int x1, x2;

        Info(int x1, int x2){
            this.x1 = x1;
            this.x2 = x2;
        }
    }
}