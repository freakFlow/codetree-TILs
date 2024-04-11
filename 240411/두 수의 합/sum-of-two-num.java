import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static long[] arr;
    static HashMap<Long, Integer> hashMap;
    static int ans;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N];
        hashMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            long num = Long.parseLong(st.nextToken());
            arr[n] = num;
            int count = hashMap.getOrDefault(num, 0);
            hashMap.put(num, count + 1);
        }

        for(int n=0; n<N; n++){
            long num1 = arr[n];
            int count1 = hashMap.getOrDefault(num1, 0);
            if(count1 == 0) continue;

            long num2 = K - num1;
            int count2 = hashMap.getOrDefault(num2, 0);
            if(count2 == 0) continue;

            if(num1 == num2){
                ans += count1 * (count1 - 1) / 2;
            }else{
                ans += count1 * count2;
            }

            hashMap.put(num1, 0);
            hashMap.put(num2, 0);
        }

        sb.append(ans);

        System.out.print(sb);
    }
}