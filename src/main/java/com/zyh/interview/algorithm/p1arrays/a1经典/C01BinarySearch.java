/**
 * @author zhanyuhao
 * @time 2023/2/7 13:46
 */
package com.zyh.interview.algorithm.p1arrays.a1经典;

public class C01BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 6, 8, 9, 11, 13, 14};
        int data = 13;
        int result = binSearch(arr, data);
        System.out.println(result);
    }

    private static int binSearch(int[] arr, int data) {
        int l = 0, r = arr.length - 1; //[l ... r] 之间搜索data
        while(l <= r){
            int mid = l + ((r - l) >> 1);
            if(arr[mid] == data)
                return mid;
            else if(arr[mid] < data)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}
