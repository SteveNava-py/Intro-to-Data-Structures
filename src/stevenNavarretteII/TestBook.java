package stevenNavarretteII; /**
 * COSC 2351 - Template code for stevenNavarretteII.TestBook Class that will
 * be used to use the functionalities implemented in the stevenNavarretteII.Book
 * class
 * @Dr.Zaki
 */

import java.util.Arrays; //import library for arrays
import java.util.Random; //import library for generating random list
import java.util.Scanner; //import library for user input

public class TestBook {

    public static void main(String[] args){
        //Generate an array of Books (similar to the one in the assignment description)
        //Test the equals method
        //Test the compareTo method by invoking the Arrays.sort()
        //Show the output results of your testing

        Scanner scanner = new Scanner(System.in);
        System.out.print("how many elements would you like to sort? : "); //user input to allow the user to determine how many elements he'd like to test
        int numElements = scanner.nextInt();

        int[] randomList = generateRandomList(numElements);
        int[] reverseList = generateReverseList(numElements);
        int[] halfSortedList = generateHalfSortedList(numElements);

        runSortTests(randomList, "random list");
        runSortTests(reverseList, "reverse list");
        runSortTests(halfSortedList, "half sorted list");
    }

    //to generate the random list
    public static int[] generateRandomList(int size) {
        Random random = new Random();
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = random.nextInt(size);
        }
        return list;
    }

    //to generate the reverse list
    public static int[] generateReverseList(int size) {
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = size - i;
        }
        return list;
    }

    //to generate the 50% list
    public static int[] generateHalfSortedList(int size) {
        int[] list = new int[size];
        for (int i = 0; i < size / 2; i++) {
            list[i] = i;
        }
        Random random = new Random();
        for (int i = size / 2; i < size; i++) {
            list[i] = random.nextInt(size);
        }
        return list;
    }

    //test all sort and measure time
    public static void runSortTests(int[] list, String listType) {
        System.out.println("\ntesting w/ " + listType);

        //selection Sort
        int[] selectionList = Arrays.copyOf(list, list.length);
        Stopwatch stopwatch = new Stopwatch();
        SortingAlgorithms.selectionSort(selectionList);
        System.out.println("selection sort: " + stopwatch.elapsedTime() + " ms");

        //bubble Sort
        int[] bubbleList = Arrays.copyOf(list, list.length);
        stopwatch = new Stopwatch();
        SortingAlgorithms.bubbleSort(bubbleList);
        System.out.println("bubble sort time: " + stopwatch.elapsedTime() + " ms");

        //recursive merge Sort
        int[] mergeRecursiveList = Arrays.copyOf(list, list.length);
        stopwatch = new Stopwatch();
        SortingAlgorithms.mergeSortRecursive(mergeRecursiveList, 0, mergeRecursiveList.length - 1);
        System.out.println("recursive merge sort: " + stopwatch.elapsedTime() + " ms");

        //non-Recursive merge Sort
        int[] mergeNonRecursiveList = Arrays.copyOf(list, list.length);
        stopwatch = new Stopwatch();
        SortingAlgorithms.mergeSortNonRecursive(mergeNonRecursiveList);
        System.out.println("non-recursive merge sort time: " + stopwatch.elapsedTime() + " ms");
    }
}

