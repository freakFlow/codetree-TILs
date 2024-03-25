import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static char[] arr;
    static int size;
    static int ans;

    public static void main(String[] args) throws IOException{
        arr = br.readLine().toCharArray();
        size = arr.length;
        
        ans = encoding();

        for(int i=1; i<size; i++){
            shift();
            ans = Math.min(ans, encoding());
        }

        sb.append(ans);

        System.out.print(sb);
    }

    static void shift(){
        char temp = arr[size-1];
        for(int i=size-1; i>0; i--){
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }

    static int encoding(){
        char ch = arr[0];
        int seq = 1;
        int len = 0;
        
        for(int i=1; i<size; i++){
            if(arr[i] == ch){
                seq++;
            }else{
                len += 2;
                if(seq > 9) len++;

                ch = arr[i];
                seq = 1;
            }
        }

        len += 2;
        if(seq > 9) len++;

        return len;
    }
}