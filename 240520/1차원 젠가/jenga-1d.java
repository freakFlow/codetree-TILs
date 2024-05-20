import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] blocks;
    static int s, e;
    static int size;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        blocks = new int[N];

        for(int n=0; n<N; n++){
            blocks[n] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<2; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()) - 1;
            e = Integer.parseInt(st.nextToken()) - 1;

            int[] temp = new int[N];
            int idx = 0;
            for(int n=0; n<N; n++){
                if((n>=s && n<=e) || blocks[n] == 0) continue;
                temp[idx++] = blocks[n];
            }

            size = idx;

            for(int n=0; n<N; n++){
                blocks[n] = temp[n];
            }
        }

        sb.append(size).append('\n');

        for(int n=0; n<N; n++){
            if(blocks[n] == 0) continue;
            sb.append(blocks[n]).append('\n');
        }

        System.out.print(sb);
    }
}