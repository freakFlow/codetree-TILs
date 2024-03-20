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
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            students[n] = new Student(height, weight, n + 1);
        }

        Arrays.sort(students, new Comparator<Student>(){
            public int compare(Student s1, Student s2){
                if(s1.height == s2.height){
                    if(s1.weight == s2.weight){
                        return Integer.compare(s1.number, s2.number);
                    }
                    return Integer.compare(s2.weight, s1.weight);
                }
                return Integer.compare(s2.height, s1.height);
            }
        });

        for(Student s : students){
            sb.append(s.height).append(' ')
            .append(s.weight).append(' ')
            .append(s.number).append('\n');
        }

        System.out.print(sb);
    }

    static class Student{
        int height, weight, number;

        Student(int height, int weight, int number){
            this.height = height;
            this.weight = weight;
            this.number = number;
        }
    }
}