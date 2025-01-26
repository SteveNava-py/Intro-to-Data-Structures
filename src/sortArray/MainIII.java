package sortArray;

import java.util.Arrays;

public class MainIII {
    public static void main(String[] args){
        Student[] stds = new Student[3];
        stds[0] = new Student("El Donte", 3.0);
        stds[1] = new Student("Negro Angelo", 4.0);
        stds[2] = new Student("Trash", 3.5);
        Arrays.sort(stds);
        for(int i = 0 ; i < 3 ; i++){
            System.out.println("sortArray.Student name is: " + stds[i].getName() + " and their gpa is: " +
                    stds[i].getGpa());
        }
    }
}
