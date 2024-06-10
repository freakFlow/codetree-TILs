import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, K;
    static int[] arr;
    static int ans;

    static int[] horseIdx;
    static int[] horse;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        horseIdx = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        setHorseIdx(0);

        sb.append(ans);

        System.out.print(sb);
    }

    static void setHorseIdx(int idx){
        if(idx == N){
            raceStart();
            return;
        }

        for(int i=0; i<K; i++){
            horseIdx[idx] = i;
            setHorseIdx(idx + 1);
        }
    }

    static void raceStart(){
        horse = new int[K];

        for(int n=0; n<N; n++){
            horse[horseIdx[n]] += arr[n];
        }

        int count = 0;
        for(int k=0; k<K; k++){
            if(horse[k] >= M-1) count++;
        }

        ans = Math.max(ans, count);
    }
}