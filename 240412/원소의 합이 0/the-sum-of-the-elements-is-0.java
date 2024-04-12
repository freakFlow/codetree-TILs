import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int A=0, B=1, C=2, D=3;

    static int N;
    static int[][] arr;
    static HashMap<Integer, Integer> hm;
    static int ans;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[4][N];
        hm = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            st = new StringTokenizer(br.readLine());
            for(int n=0; n<N; n++){
                arr[i][n] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int sum = arr[A][i] + arr[B][j];
                int count = hm.getOrDefault(sum, 0);
                hm.put(sum, count + 1);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int sum = arr[C][i] + arr[D][j];
                ans += hm.getOrDefault(-sum, 0);
            }
        }

        sb.append(ans);

        System.out.print(sb);
    }
}