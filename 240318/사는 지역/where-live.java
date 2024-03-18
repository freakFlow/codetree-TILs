import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Person[] people;
    static Person ans;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        people = new Person[N];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            people[n] = new Person(st.nextToken(), st.nextToken(), st.nextToken());
        }

        ans = people[0];
        for(int n=1; n<N; n++){
            if(canExchange(people[n].name)) ans = people[n];
        }

        sb.append("name ").append(ans.name)
        .append("\naddr ").append(ans.addr)
        .append("\ncity ").append(ans.city);

        System.out.print(sb);
    }

    static boolean canExchange(String str){
        int len1 = ans.name.length();
        int len2 = str.length();
        int min = Math.min(len1, len2);

        for(int i=0; i<min; i++){
            char ch1 = ans.name.charAt(i);
            char ch2 = str.charAt(i);
            if(ch1 == ch2) continue;

            return (ch1 < ch2) ? true : false;
        }

        return (len1 < len2) ? true : false;
    }

    static class Person{
        String name;
        String addr;
        String city;

        Person(String name, String addr, String city){
            this.name = name;
            this.addr = addr;
            this.city = city;
        }
    }
}