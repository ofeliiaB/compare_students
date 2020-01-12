package com.company;

import java.util.*;

class Student{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}
class SortByGP implements Comparator<Student>{


    @Override
    public int compare(Student o1, Student o2) {
        int answer=0;
        if(o1.getCgpa()-o2.getCgpa()>0){
            answer= -1;
        }else if(o1.getCgpa()-o2.getCgpa()<0){
            answer = 1;
        }else{
            int fNameDif = o1.getFname().compareTo(o2.getFname());

            if(fNameDif>0){
                answer=1;
            }else if(fNameDif<0){
                answer=-1;
            }else{
                int idFid = o1.getId()-o2.getId();
                if(idFid>0){
                    answer= 1;
                }else if(idFid<0){
                    answer =-1;
                }
            }
        }

        return answer;
    }
}

public class Main
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        studentList.sort(new SortByGP());


        for(Student st: studentList){
            System.out.println(st.getFname());
        }
    }
}
