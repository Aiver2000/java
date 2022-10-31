package demo1;

import java.util.Arrays;
import java.util.Comparator;


/*class Student implements Comparable<Student>{
    public int age;
    public String name;
    public double score;

    public Student(int age, String name, double score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        *//*if(this.age>o.age){
            return 1;
        }else if(this.age == o.age){
            return 0;
        }else {
            return -1;
        }*//*
        //return this.age-o.age;
        return this.age-o.age;
    }
}*/

class Student{
    public int age;
    public String name;
    public double score;

    public Student(int age, String name, double score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }


}

class AgeComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o2.age-o1.age;
    }
}
class ScoreComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return (int)(o1.score-o2.score);
    }
}
class NameComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}
public class Test {
    public static void main2(String[] args) {
        Student students = new Student(2,"lqx",22.3);
        Student students1 = new Student(22,"qqq",99);
//        if(students.compareTo(students1) >0){
//
//        }
        //System.out.println(students.compareTo(students1));
        AgeComparator ageComparator =new AgeComparator();
        System.out.println(ageComparator.compare(students,students1));

    }
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student(2,"lqx",22.3);
        students[1] = new Student(6,"aaa",99.0);
        students[2] = new Student(20,"bbb",57.9);
        System.out.println(Arrays.toString(students));
        AgeComparator ageComparator =new AgeComparator();
        NameComparator nameComparator = new NameComparator();
        ScoreComparator scoreComparator = new ScoreComparator();
        Arrays.sort(students,nameComparator);
        System.out.println(Arrays.toString(students));

    }
    public static void main1(String[] args) {
        int [] array = {1,2,5,3,9,3,7,5,6};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
