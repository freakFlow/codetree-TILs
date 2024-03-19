import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st1, st2;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arrA, arrB;
    static boolean ans;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arrA = new int[N];
        arrB = new int[N];
        ans = true;
        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());

        for(int n=0; n<N; n++){
            arrA[n] = Integer.parseInt(st1.nextToken());
            arrB[n] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        for(int n=0; n<N; n++){
            if(arrA[n] != arrB[n]){
                ans = false;
                break;
            }
        }

        sb.append(ans ? "Yes" : "No");

        System.out.print(sb);
    }
}