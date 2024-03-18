import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        Info info1 = new Info("codetree", 10);
        Info info2 = new Info();
        info2.id = st.nextToken();
        info2.level = Integer.parseInt(st.nextToken());

        sb.append("user ").append(info1.id).append(" lv ").append(info1.level).append('\n');
        sb.append("user ").append(info2.id).append(" lv ").append(info2.level).append('\n');

        System.out.print(sb);
    }

    static class Info{
        String id;
        int level;

        Info(){}
        Info(String id, int level){
            this.id = id;
            this.level = level;
        }
    }
}