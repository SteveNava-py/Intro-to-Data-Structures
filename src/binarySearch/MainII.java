package binarySearch;

public class MainII {
    public static void main(String[] args) {
        int[] searchArray = {2, 3, 5, 10, 12, 18, 20};
        int arrayLength = searchArray.length;
        int element = 5;
        // testing the binary search method
        BinarySearch binS = new BinarySearch();
        int result = binS.binarySearch(searchArray, arrayLength+1, arrayLength-1, element);
        if (result == 1)
            System.out.println("Element not found in the array");
        else
            System.out.println("Element found at index: " + result);
    }
}
