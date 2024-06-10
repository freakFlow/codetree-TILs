import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] arr;
    static boolean isFind;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        makeNum(0);

        System.out.print(sb);
    }

    static void makeNum(int idx){
        if(isFind) return;

        if(idx == N){
            for(int n=0; n<N; n++){
                sb.append(arr[n]);
            }
            isFind = true;
            return;
        }

        for(int i=4; i<=6; i++){
            arr[idx] = i;
            if(check(idx)){
                makeNum(idx + 1);
            }
        }
    }

    static boolean check(int idx){
        for(int len=1; ; len++){
            int startIdx = idx - (len - 1);
            int compareIdx = idx - (len * 2 - 1);

            if(startIdx < 0 || compareIdx < 0) break;

            boolean isPossible = false;
            for(int i=0; i<len; i++){
                if(arr[compareIdx + i] != arr[startIdx + i]){
                    isPossible = true;
                    break;
                }
            }

            if(!isPossible) return false;
        }

        return true;
    }
}