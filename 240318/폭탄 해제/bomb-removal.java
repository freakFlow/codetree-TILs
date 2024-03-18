import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        Info info = new Info(st.nextToken(), st.nextToken(), st.nextToken());

        sb.append("code : ").append(info.code)
        .append("\ncolor : ").append(info.color)
        .append("\nsecond : ").append(info.second);

        System.out.print(sb);
    }

    static class Info{
        String code;
        String color;
        String second;

        Info(String code, String color, String second){
            this.code = code;
            this.color = color;
            this.second = second;
        }
    }
}