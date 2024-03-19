import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[2 * N];

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<arr.length; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int max = 0;
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            if(arr[start] + arr[end] > max) max = arr[start] + arr[end];
            start++;
            end--;
        }

        sb.append(max);

        System.out.print(sb);
    }
}