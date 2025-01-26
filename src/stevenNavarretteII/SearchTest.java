package stevenNavarretteII;

import java.util.Arrays; //import array library for java

public class SearchTest {
    public static void main(String[] args) {
        int[] numKeys = {5000, 10000, 20000, 25000}; //create int list of keys

        for (int size : numKeys) {
            int[] list = generateList(size);
            int target = size + 1; //test worst-case scenario

            //create object of stopwatch class to measure time for linear search
            Stopwatch stopwatch = new Stopwatch();
            linearSearch(list, target);
            double linearTime = stopwatch.elapsedTime();
            System.out.println("Linear search time for " + size + " elements: " + linearTime + " ms"); //print linear search time in ms

            //this part of the code is to measure time for binary search
            Arrays.sort(list); //makes the list sorted for binary search
            stopwatch = new Stopwatch();
            binarySearch(list, target);
            double binaryTime = stopwatch.elapsedTime();
            System.out.println("Binary search time for " + size + " elements: " + binaryTime + " ms"); //print binary search time in ms
        }
    }

    //generate list from 1 to numkeys
    public static int[] generateList(int numkeys) {
        int[] list = new int[numkeys];
        for (int i = 0; i < numkeys; i++) {
            list[i] = i + 1;
        }
        return list;
    }

    //linear search
    public static int linearSearch(int[] list, int key) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == key) {
                return i; //this is to return index if found
            }
        }
        return -1; //this is to return -1 if not found
    }

    //binary search
    public static int binarySearch(int[] list, int key) {
        int left = 0;
        int right = list.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list[mid] == key) {
                return mid; //this is to return index if found
            } else if (list[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; //this is to return -1 if not found
    }
}
