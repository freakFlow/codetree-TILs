import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Info[] info;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        info = new Info[N];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            info[n] = new Info(name, height, weight);
        }

        Arrays.sort(info, new Comparator<Info>(){
            public int compare(Info i1, Info i2){
                if(i1.height == i2.height){
                    return Integer.compare(i2.weight, i1.weight);
                }
                return Integer.compare(i1.height, i2.height);
            }
        });

        for(Info i : info){
            sb.append(i.name).append(' ')
            .append(i.height).append(' ')
            .append(i.weight).append('\n');
        }

        System.out.print(sb);
    }

    static class Info{
        String name;
        int height, weight;

        Info(String name, int height, int weight){
            this.name = name;
            this.height = height;
            this.weight = weight;
        }
    }
}