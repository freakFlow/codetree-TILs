import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;

    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N + 1];

        makeNum(0);

        System.out.print(sb);
    }

    static void makeNum(int idx){
        if(idx == N){
            for(int n=0; n<N; n++){
                sb.append(arr[n]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=N; i>0; i--){
            if(visited[i]) continue;
            visited[i] = true;
            arr[idx] = i;
            makeNum(idx + 1);
            visited[i] = false;
        }
    }
}