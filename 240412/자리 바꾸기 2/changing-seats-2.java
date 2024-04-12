import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] seats;
    static Info[] info;
    static HashSet<Integer>[] counts;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        seats = new int[N+1];
        info = new Info[K];
        counts = new HashSet[N+1];

        for(int n=1; n<=N; n++){
            seats[n] = n;
            counts[n] = new HashSet<>();
            counts[n].add(n);
        }

        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            info[k] = new Info(a, b);
        }

        for(int i=0; i<3; i++){
            for(int k=0; k<K; k++){
                swap(info[k]);
            }
        }

        for(int n=1; n<=N; n++){
            sb.append(counts[n].size()).append('\n');
        }

        System.out.print(sb);
    }

    static void swap(Info i){
        int personA = seats[i.a];
        int personB = seats[i.b];

        counts[personA].add(i.b);
        counts[personB].add(i.a);

        seats[i.a] = personB;
        seats[i.b] = personA;
    }

    static class Info{
        int a, b;

        Info(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
}