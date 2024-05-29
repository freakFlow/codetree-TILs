import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] arr;
    static int ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        makeNum(0);

        sb.append(ans);

        System.out.print(sb);
    }

    static void makeNum(int idx){
        if(idx == N){
            if(isBeautiful()) ans++;
            return;
        }

        for(int i=1; i<=4; i++){
            arr[idx] = i;
            makeNum(idx + 1);
        }
    }

    static boolean isBeautiful(){
        int num = arr[0];
        int count = 1;

        for(int i=1; i<N; i++){
            if(arr[i] == num){
                count++;
                continue;
            }

            if(count % num != 0) return false;

            num = arr[i];
            count = 1;
        }

        return count % num == 0 ? true : false;
    }
}