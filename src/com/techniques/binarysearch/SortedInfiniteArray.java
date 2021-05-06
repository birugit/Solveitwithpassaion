package com.techniques.binarysearch;

/**
 Given an infinite sorted array (or an array with unknown size), find if a given number ‘key’ is present in the array.
 Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.

 Since it is not possible to define an array with infinite (unknown) size, you will be provided with an interface ArrayReader to read elements of the array. ArrayReader.get(index) will return the number at index; if the array’s size is smaller than the index, it will return Integer.MAX_VALUE.

 Example 1:

 Input: [4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30], key = 16
 Output: 6
 Explanation: The key is present at index '6' in the array.
 Example 2:

 Input: [4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30], key = 11
 Output: -1
 Explanation: The key is not present in the array.
 Example 3:

 Input: [1, 3, 8, 10, 15], key = 15
 Output: 4
 Explanation: The key is present at index '4' in the array.
 Example 4:

 Input: [1, 3, 8, 10, 15], key = 200
 Output: -1
 Explanation: The key is not present in the array.
 */
public class SortedInfiniteArray {

    static class ArrayReader{
        int[] arr;
        public ArrayReader(int[] arr){
            this.arr = arr;
        }

        public int getNumber(int index){
            if(index>= arr.length)
                return Integer.MAX_VALUE;
            return arr[index];
        }
    }

    public static void main(String[] args) {
        SortedInfiniteArray s = new SortedInfiniteArray();
        int[] nums = {4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};//{1, 3, 8, 10, 15};//{4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
        ArrayReader reader = new ArrayReader(nums);
        int key = 16;//15;//11;//200;//
        System.out.println(s.search(reader, key));
    }

    private int search(ArrayReader reader, int key) {
       // int[] tmpArr = reader.arr;
        int res =searchExp(reader, key, 0,1);
        return res;
    }

    private int searchExp(ArrayReader reader, int key, int low, int high) {
        while(low <high) {
          int  mid = low + (high - low) / 2;

            if (key > reader.getNumber(mid)) {
                low = mid + 1;
            }else if(key < reader.getNumber(mid)){
                high = mid -1;
            }else {
                return mid;
            }
        }
        if(reader.getNumber(high) <= key) {
            low = high;
            high = 2 * high;
        }else
            return -1;
      return  searchExp(reader, key, low, high);
    }
}
