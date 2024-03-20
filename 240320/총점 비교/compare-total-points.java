import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Student[] students;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        students = new Student[N];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            int s3 = Integer.parseInt(st.nextToken());
            students[n] = new Student(name, s1, s2, s3);
        }

        Arrays.sort(students);

        for(Student s : students){
            sb.append(s.name).append(' ')
            .append(s.s1).append(' ')
            .append(s.s2).append(' ')
            .append(s.s3).append('\n');
        }

        System.out.print(sb);
    }

    static class Student implements Comparable<Student>{
        String name;
        int s1, s2, s3;

        Student(String name, int s1, int s2, int s3){
            this.name = name;
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }

        public int compareTo(Student s){
            return Integer.compare(this.s1 + this.s2 + this.s3, s.s1 + s.s2 + s.s3);
        }
    }
}