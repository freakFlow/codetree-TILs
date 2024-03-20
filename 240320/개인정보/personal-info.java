import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static Info[] info = new Info[5];

    public static void main(String[] args) throws IOException{
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int height = Integer.parseInt(st.nextToken());
            double weight = Double.parseDouble(st.nextToken());
            info[i] = new Info(name, height, weight);
        }

        Arrays.sort(info, new Comparator<Info>(){
            public int compare(Info i1, Info i2){
                return i1.name.compareTo(i2.name);
            }
        });

        sb.append("name\n");
        for(Info i : info){
            sb.append(i.name).append(' ')
            .append(i.height).append(' ')
            .append(String.format("%.1f", i.weight)).append('\n');
        }

        Arrays.sort(info, new Comparator<Info>(){
            public int compare(Info i1, Info i2){
                return -Integer.compare(i1.height, i2.height);
            }
        });

        sb.append("\nheight\n");
        for(Info i : info){
            sb.append(i.name).append(' ')
            .append(i.height).append(' ')
            .append(String.format("%.1f", i.weight)).append('\n');
        }

        System.out.print(sb);
    }

    static class Info{
        String name;
        int height;
        double weight;

        Info(String name, int height, double weight){
            this.name = name;
            this.height = height;
            this.weight = weight;
        }
    }
}