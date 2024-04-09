import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] num;
    static int sum;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        num = new int[2*N];

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<num.length; n++){
            num[n] = Integer.parseInt(st.nextToken());
            sum += num[n];
        }

        combination(0, 0, 0);

        sb.append(min);

        System.out.print(sb);
    }

    static void combination(int idx, int start, int subSum){
        if(idx == N){
            min = Math.min(min, Math.abs(sum - 2 * subSum));
            return;
        }

        for(int i=start; i<num.length; i++){
            combination(idx + 1, i + 1, subSum + num[i]);
        }
    }
}