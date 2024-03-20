import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Person[] people;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        people = new Person[N];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            people[n] = new Person(name, height, weight);
        }

        Arrays.sort(people);

        for(int n=0; n<N; n++){
            sb.append(people[n].name).append(' ').append(people[n].height).append(' ')
            .append(people[n].weight).append('\n');
        }

        System.out.print(sb);
    }

    static class Person implements Comparable<Person>{
        String name;
        int height;
        int weight;

        Person(String name, int height, int weight){
            this.name = name;
            this.height = height;
            this.weight = weight;
        }

        public int compareTo(Person p){
            return Integer.compare(this.height, p.height);
        }
    }
}