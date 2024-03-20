import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Element[] element;
    static int[] ans;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine().trim());
        element = new Element[N];
        ans = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            element[n] = new Element(n, Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(element);

        for(int n=0; n<N; n++){
            ans[element[n].index] = n + 1;
        }

        for(int n=0; n<N; n++){
            sb.append(ans[n]).append(' ');
        }

        System.out.print(sb);
    }

    static class Element implements Comparable<Element>{
        int index, value;

        Element(int index, int value){
            this.index = index;
            this.value = value;
        }

        public int compareTo(Element e){
            if(this.value == e.value){
                return Integer.compare(this.index, e.index);
            }
            return Integer.compare(this.value, e.value);
        }
    }
}