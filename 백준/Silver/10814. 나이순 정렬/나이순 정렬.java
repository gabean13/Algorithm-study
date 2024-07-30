import java.util.*;
import java.io.*;
import java.util.Collections;

class Main {
    static class Person implements Comparable<Person>{
        int age;
        String name;

        public Person(int age, String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person person){
            if(person.age < age){
                return 1;
            }else if(person.age > age){
                return -1;
            }
            return 0;
        }

        @Override
        public String toString(){
            return this.age + " " + this.name;
        }
    }

	static public void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Person> list = new ArrayList<>();
        //1. 나이순정렬 나이가 큰 애들만 정렬 같은 애들은 정렬X
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Collections.sort(list);
        for(Person person : list){
            System.out.println(person);
        }
        
    }
}