import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int SIZE = 6, MAX = 4;

    static char[] str;
    static int[] toNum;
    static int ans;

    public static void main(String[] args) throws IOException {
        str = br.readLine().toCharArray();
        toNum = new int[SIZE];

        combination(0);

        sb.append(ans);

        System.out.print(sb);
    }

    static void combination(int idx){
        if(idx == SIZE){
            calculate();
            return;
        }

        for(int i=1; i<=MAX; i++){
            toNum[idx] = i;
            combination(idx+1);
        }
    }

    static void calculate(){
        int result = toNum[str[0]-'a'];

        for(int i=1; i<str.length; i+=2){
            switch(str[i]){
                case '+':
                    result += toNum[str[i+1]-'a']; break;
                case '-':
                    result -= toNum[str[i+1]-'a']; break;
                case '*':
                    result *= toNum[str[i+1]-'a']; break;
            }
        }

        ans = Math.max(ans, result);
    }
}