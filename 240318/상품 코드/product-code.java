import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        Product p1 = new Product("codetree", "50");
        Product p2 = new Product();
        st = new StringTokenizer(br.readLine());
        p2.name = st.nextToken();
        p2.code = st.nextToken();

        sb.append("product ").append(p1.code).append(" is ").append(p1.name)
        .append("\nproduct ").append(p2.code).append(" is ").append(p2.name);

        System.out.print(sb);
    }

    static class Product{
        String name;
        String code;

        Product(){}
        Product(String name, String code){
            this.name = name;
            this.code = code;
        }
    }
}