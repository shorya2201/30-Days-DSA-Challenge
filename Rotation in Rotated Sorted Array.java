// Java program to find number of
// rotations in a sorted and rotated
// array.
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    //Idea is to find minimum element index, that will be our answer and what 
    //better than Binary Search when it comes to implementing if there is
    // 'Find' and 'Sorted together'
    static int countRotations(int arr[], int low, int high)
    {
        //Basic Binary Search template
        if(high<low) return 0;
        if(high==low) return low;
        int mid = high+low/2;
        
        //if element is found at right side then return index
        if(mid<high && arr[mid+1]<arr[mid]) return mid+1;
        //if element is fount at left side then return index
        if(mid > low && arr[mid]<arr[mid-1]) return mid;
        //decide wheather to serch the array in right or left
        if(arr[mid]>arr[high]) return countRotations(arr,mid+1,high);
        
        return countRotations(arr,low,mid-1);
    }

    // Driver program 
    public static void main(String[] args)
    {
        int arr[] = { 15, 18, 2, 3, 6, 12 };
        int N = arr.length;

        System.out.println(countRotations(arr, 0, N - 1));
    }
}
// This code is coded by Shorya
