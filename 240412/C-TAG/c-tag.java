import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] A, B;
    static HashSet<String> hs;
    static int ans;

    static int[] strIdx = new int[3];

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new String[N];
        B = new String[N];
        hs = new HashSet<>();

        for(int n=0; n<N; n++){
            A[n] = br.readLine();
        }
        for(int n=0; n<N; n++){
            B[n] = br.readLine();
        }

        combination(0, 0);

        sb.append(ans);

        System.out.print(sb);
    }

    static void combination(int idx, int start){
        if(idx == strIdx.length){
            startDivide();
            return;
        }

        for(int i=start; i<M; i++){
            strIdx[idx] = i;
            combination(idx + 1, i + 1);
        }
    }

    static void startDivide(){
        hs.clear();
        StringBuilder temp;

        for(int n=0; n<N; n++){
            temp = new StringBuilder();
            for(int i=0; i<strIdx.length; i++){
                temp.append(A[n].charAt(strIdx[i]));
            }

            hs.add(temp.toString());
        }

        for(int n=0; n<N; n++){
            temp = new StringBuilder();
            for(int i=0; i<strIdx.length; i++){
                temp.append(B[n].charAt(strIdx[i]));
            }

            if(hs.contains(temp.toString())) return;
        }

        ans++;
    }
}