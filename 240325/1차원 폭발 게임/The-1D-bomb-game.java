import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] arr;
    static int[] temp;
    static int endIdx;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        temp = new int[N];
        endIdx = N;

        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(br.readLine());
        }

        while(true){
            boolean flag = false;

            int num = arr[0];
            int start = 0;
            int end = 0;
            int len = 0;
            for(int n=1; n<endIdx; n++){
                if(arr[n] == num){
                    end++;
                }else{
                    len = end - start + 1;
                    if(len >= M) {
                        bomb(start, end);
                        flag = true;
                    }
                    num = arr[n];
                    start = end = n;
                }
            }

            len = end - start + 1;
            if(len >= M){
                bomb(start, end);
                flag = true;
            }

            if(!flag || endIdx == 0) break;

            int tIdx = 0;
            for(int n=0; n<endIdx; n++){
                if(arr[n] == -1) continue;
                temp[tIdx++] = arr[n];
            }

            endIdx = tIdx;
            for(int n=0; n<endIdx; n++){
                arr[n] = temp[n];
            }
        }

        sb.append(endIdx).append('\n');
        for(int n=0; n<endIdx; n++){
            sb.append(arr[n]).append('\n');
        }

        System.out.print(sb);
    }

    static void bomb(int start, int end){
        for(int i=start; i<=end; i++){
            arr[i] = -1;
        }
    }
}