import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] arr;
    static HashMap<Integer, Integer> hashMap;
    static int n1, n2, n3;
    static int ans;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        hashMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
            int count = hashMap.getOrDefault(arr[n], 0);
            hashMap.put(arr[n], count + 1);
        }

        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                n1 = arr[i];
                n2 = arr[j];
                n3 = K - (n1 + n2);

                minus(n1);
                minus(n2);
                int count = hashMap.getOrDefault(n3, 0);
                if(count > 0) ans += count;
                plus(n1);
                plus(n2);
            }
        }

        sb.append(ans / 3);

        System.out.print(sb);
    }

    static void minus(int key){
        if(!hashMap.containsKey(key)) return;
        int value = hashMap.get(key);
        hashMap.put(key, value - 1);
    }

    static void plus(int key){
        if(!hashMap.containsKey(key)) return;
        int value = hashMap.get(key);
        hashMap.put(key, value + 1);
    }
}