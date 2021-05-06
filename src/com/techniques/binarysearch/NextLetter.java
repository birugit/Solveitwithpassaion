package com.techniques.binarysearch;

/**
 Given an array of lowercase letters sorted in ascending order, find the smallest letter in the given array greater than a given ‘key’.

 Assume the given array is a circular list, which means that the last letter is assumed to be connected with the first letter. This also means that the smallest letter in the given array is greater than the last letter of the array and is also the first letter of the array.

 Write a function to return the next letter of the given ‘key’.

 Example 1:

 Input: ['a', 'c', 'f', 'h'], key = 'f'
 Output: 'h'
 Explanation: The smallest letter greater than 'f' is 'h' in the given array.

 Input: ['a', 'c', 'f', 'h'], key = 'b'
 Output: 'c'
 Explanation: The smallest letter greater than 'b' is 'c'.
 Example 3:

 Input: ['a', 'c', 'f', 'h'], key = 'm'
 Output: 'a'
 Explanation: As the array is assumed to be circular, the smallest letter greater than 'm' is 'a'.
 Example 4:

 Input: ['a', 'c', 'f', 'h'], key = 'h'
 Output: 'a'
 Explanation: As the array is assumed to be circular, the smallest letter greater than 'h' is 'a'.
 */
public class NextLetter {
    public static void main(String[] args) {
        NextLetter n = new NextLetter();
        char[] chars ={'a', 'c', 'f', 'h'};//{'a', 'c', 'f', 'h'};
        char key = 'g';//'f';
        System.out.println(n.nextLetter(chars, key));
    }

    private char nextLetter(char[] chars, char key) {
        int n = chars.length;
        /**
         The array is considered circular, which means if the ‘key’ is bigger than the last letter of the array or
         if it is smaller than the first letter of the array, the key’s next letter will be the first letter of the array.
         */
        if( key < chars[0]||  key > chars[n -1])
            return chars[0];

            int start = 0, pivotal = 0, end = chars.length -1;
            while(start <= end){
                pivotal = start + (end - start)/2;
                if(key < chars[pivotal]){
                    end = pivotal - 1;
                }else {//if( key > chars[pivotal]){
                    /**
                     next biggest letter which can’t be equal to the ‘key’.
                      This means that we will ignore the case where key == arr[middle].
                     To handle this case, we can update our start range to start = middle +1.
                     */
                    start = pivotal + 1;
                }

            }
/**
 In the end, instead of returning the element pointed out by start,
 we have to return the letter pointed out by start % array_length.
 Imagine that the last letter of the array is equal to the ‘key’.
 In that case, we have to return the first letter of the input array.


 */
System.out.println(start%n);
            return chars[start %n];


    }
}
