import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;
    static int count;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        makeNum(0);

        sb.append(count);

        System.out.print(sb);
    }

    static void makeNum(int digit){
        if(digit == N){
            check();
            return;
        }

        for(int i=1; i<=4; i++){
            arr[digit] = i;
            makeNum(digit + 1);
        }
    }

    static void check(){
        int idx = 0;
        while(idx < N){
            int num = arr[idx];
            int i = idx;
            for(; i<idx + num; i++){
                if(i >= N || arr[i] != num) return;
            }
            idx = i;
        }

        count++;
    }
}