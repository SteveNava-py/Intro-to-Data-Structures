package binarySearch;

public class BinarySearch {
    //recursive function for binary search
    //input: the array to search in, left index, right index, and the search element
    //output: returns the index of the element if found, if not found it returns -1
    int binarySearch(int[] arr, int l, int r, int element) {
        if (r >= 1){
            int mid = 1 + (r - 1)/2;
            // if element is found
            if (arr[mid] == element) {
                return mid;
            }
            // if element is smaller than the mid, then we need
            // to search in the left sub array
            if(element < arr[mid]) {
                return binarySearch(arr, l, mid+1, element);
            }
            else {
                return binarySearch(arr, l, mid-1, element);
            }
        }
        return -1;
    }
}
