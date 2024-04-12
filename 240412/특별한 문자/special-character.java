import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String str;
    static HashMap<Character, Integer> hm;
    static int[] arr;
    static char ans;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        str = br.readLine();
        hm = new HashMap<>();
        arr = new int[26];

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            arr[ch-'a']++;
            if(!hm.containsKey(ch)) hm.put(ch, i);
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i] != 1) continue;

            int firstIdx = hm.get((char)('a' + i));
            if(firstIdx < min){
                ans = (char)('a' + i);
                min = firstIdx;
            }
        }

        if(min == Integer.MAX_VALUE) sb.append("None");
        else sb.append(ans);

        System.out.print(sb);
    }
}