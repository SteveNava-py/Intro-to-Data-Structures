/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainV {
    public static void removePlural(ArrayList<String> arr) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<ArrayList>mainArr = new ArrayList();
        for(int i = 0; i < n; i++) {
            mainArr.add(new ArrayList());
            int d = in.nextInt();
            for(int j = 0; j < d; j++) {
                mainArr.get(i).add(in.nextInt());
            }
        }
        int q = in.nextInt();
        int r, c;
        for(int i = 0; i < q; i++){
            r = in.nextInt();
            c = in.nextInt();
            if(r <= mainArr.size() && c <= mainArr.get(r-1).size()) {
                System.out.println(mainArr.get(r - 1).get(c - 1));
            }
            else
                System.out.println("out of bounds");
            }
        }
    }*/

