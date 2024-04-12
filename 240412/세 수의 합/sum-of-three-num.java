import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] arr;
    static HashMap<Integer, Integer> hashMap;
    static int n1, n2, n3, c1, c2, c3;
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
            n1 = arr[i];
            c1 = hashMap.getOrDefault(n1, 0);
            if(c1 == 0) continue;
            for(int j=0; j<N; j++){
                n2 = arr[j];
                c2 = hashMap.getOrDefault(n2, 0);
                if(c2 == 0) continue;

                n3 = K - (n1 + n2);
                c3 = hashMap.getOrDefault(n3, 0);
                if(c3 == 0) continue;

                if(n1 == n2 && n2 == n3){
                    ans += c1 * (c1-1) * (c1-2) / 6;
                }else if(n1 == n2){
                    ans += c1 * (c1-1) / 2 * c3;
                }else if(n2 == n3){
                    ans += c2 * (c2-1) / 2 * c1;
                }else if(n1 == n3){
                    ans += c3 * (c3-1) / 2 * c2;
                }else{
                    ans += c1 * c2 * c3;
                }

                hashMap.remove(n1);
                hashMap.remove(n2);
                hashMap.remove(n3);
            }
        }

        sb.append(ans);

        System.out.print(sb);
    }
}