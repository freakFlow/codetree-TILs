import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static HashMap<String, Integer> toIdx;
    static HashMap<Integer, String> toStr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        toIdx = new HashMap<>();
        toStr = new HashMap<>();

        for(int n=1; n<=N; n++){
            String str = br.readLine();
            toIdx.put(str, n);
            toStr.put(n, str);
        }

        for(int m=0; m<M; m++){
            String str = br.readLine();
            if(isNum(str)){
                sb.append(toStr.get(Integer.parseInt(str)));
            }else{
                sb.append(toIdx.get(str));
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static boolean isNum(String str){
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch < '0' || ch >'9') return false;
        }
        return true;
    }
}