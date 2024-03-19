import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static String T;
    static String[] arr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        T = st.nextToken();
        arr = new String[N];
        
        for(int n=0; n<N; n++){
            arr[n] = br.readLine();
        }

        Arrays.sort(arr);

        for(int n=0; n<N; n++){
            if(startWith(arr[n])){
                K--;
                if(K == 0) sb.append(arr[n]);
            }
        }
        
        System.out.print(sb);
    }

    static boolean startWith(String str){
        if(str.length() < T.length()) return false;

        for(int i=0; i<T.length(); i++){
            if(T.charAt(i) != str.charAt(i)) return false;
        }

        return true;
    }
}