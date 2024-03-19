import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static char[] str;

    public static void main(String[] args) throws IOException{
        str = br.readLine().toCharArray();
        Arrays.sort(str);
        for(int i=0; i<str.length; i++){
            sb.append(str[i]);
        }

        System.out.print(sb);
    }
}