import java.util.ArrayList;
import java.util.Arrays;

public class MainIV {
    public static void main(String[] args) {
        //testing 2d arrays
        ArrayList<ArrayList> mainArr = new ArrayList<>();
        mainArr.add(new ArrayList());
        mainArr.add(new ArrayList());
        mainArr.get(0).add(5);
        mainArr.get(0).add(10);
        mainArr.get(0).add(25);
        mainArr.get(1).add(20);
        mainArr.get(1).add(30);
        mainArr.get(1).add(40);

        for (int i = 0; i < mainArr.size(); i++) {
            for (int j = 0; j < mainArr.get(i).size(); j++)
                System.out.print(mainArr.get(i).get(j) + " ");
            System.out.println();
        }
        ArrayList<String> strArr = new ArrayList<>();
        strArr.add("dogs");
        strArr.add("cat");
        strArr.add("rain");
        strArr.add("apples");
        System.out.println(strArr);
        removePlural(strArr);
        System.out.println(strArr);
    }

    public static void removePlural(ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i);
            if (s.endsWith("s")) {
                arr.remove(i);
                i--; //i = i - 1
            }
        }
    }
}


