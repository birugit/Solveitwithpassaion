package com.july;

/**
 Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

 Example:

 Input:  [1,2,1,3,2,5]
 Output: [3,5]
 Note:

 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class SingleNumberIII {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int[] res =SingleNumberIII.singleNumber(nums);
        for(int n: res){
            System.out.println(n);
        }
    }

    private static int[] singleNumber(int[] nums) {
        //T: O(N)
        //S: O(1)
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums)
            bitmask ^= num;

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums)
            if ((num & diff) != 0)
                x ^= num;

        return new int[]{x, bitmask^x};

        //T: O(N)
        //S:O(N)
       /* int[] res = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        int i =0;
        for(Map.Entry<Integer, Integer> m: map.entrySet()){
            if(m.getValue() == 1){
                res[i] = m.getKey();
                i++;
            }
        }
        return res;*/
    }
}
