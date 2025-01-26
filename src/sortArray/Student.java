package sortArray;

public class Student implements Comparable{
    private String name;
    private double gpa;

    //constructor
    public Student(String name, double gpa){
        this.name = name;
        this.gpa = gpa;
    }

    public int compareTo(Object t){
        if (this.gpa > ((Student)t).gpa)
            return 1;
        else if (this.gpa < ((Student)t).gpa)
            return -1;
        else
            return 0;
        //to compare names
        //return this.name.compareTo(((sortArray.Student)t).name);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getGpa(){
        return gpa;
    }

    public void setGpa(double gpa){
        this.gpa = gpa;
    }
}
