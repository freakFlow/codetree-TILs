import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(br.readLine());
        }

        int size = N;
        while(true){
            boolean endLoop = true;
            int[] temp = new int[size];
            int tIdx = 0;

            int start = 0;
            int end = 1;
            while(end < size){
                if(arr[start] == arr[end]){
                    end++;
                    continue;
                }

                if(end - start >= M){
                    for(int n=start; n<end; n++){
                        arr[n] = 0;
                    }
                    endLoop = false;
                }
                start = end;
            }

            if(end - start >= M){
                for(int n=start; n<end; n++){
                    arr[n] = 0;
                }
                endLoop = false;
            }

            if(endLoop) break;

            for(int n=0; n<size; n++){
                if(arr[n] == 0) continue;
                temp[tIdx++] = arr[n];
            }

            for(int n=0; n<tIdx; n++){
                arr[n] = temp[n];
            }

            size = tIdx;
        }

        sb.append(size).append('\n');

        for(int n=0; n<size; n++){
            sb.append(arr[n]).append('\n');
        }

        System.out.print(sb);
    }
}