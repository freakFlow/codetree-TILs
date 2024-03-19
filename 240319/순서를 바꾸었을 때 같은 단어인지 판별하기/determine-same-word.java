import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static char[] arr1, arr2;
    static boolean ans;

    public static void main(String[] args) throws IOException{
        ans = true;
        arr1 = br.readLine().toCharArray();
        arr2 = br.readLine().toCharArray();

        if(arr1.length != arr2.length) ans = false;
        else{
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            for(int i=0; i<arr1.length; i++){
                if(arr1[i] != arr2[i]){
                    ans = false;
                    break;
                }
            }
        }

        sb.append(ans ? "Yes" : "No");

        System.out.print(sb);
    }
}