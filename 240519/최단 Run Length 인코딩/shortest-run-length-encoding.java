import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[] string;
    static int size;
    static int ans;

    public static void main(String[] args) throws IOException {
        string = br.readLine().toCharArray();
        size = string.length;
        ans = Integer.MAX_VALUE;

        for(int i=0; i<size; i++){
            shift();
            ans = Math.min(ans, encoding());
        }

        sb.append(ans);

        System.out.print(sb);
    }

    static void shift(){
        char temp = string[size-1];
        for(int i=size-1; i>0; i--){
            string[i] = string[i-1];
        }
        string[0] = temp;
    }

    static int encoding(){
        int num = 0;
        char ch = string[0];
        int count = 1;

        for(int i=1; i<size; i++){
            if(ch == string[i]) count++;
            else{
                ch = string[i];
                count = 1;
                num += 2;
            }
        }

        if(count > 9) num += 3;
        else num += 2;

        return num;
    }
}