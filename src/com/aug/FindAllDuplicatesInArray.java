package com.aug;
/**
 Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements that appear twice in this array.

 Could you do it without extra space and in O(n) runtime?

 Example:
 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [2,3]
 */

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {
    public static void main(String[] args) {
        FindAllDuplicatesInArray f = new FindAllDuplicatesInArray();
int[] nums = {4,3,2,7,8,2,3,1};
       System.out.println(f.findDuplicates(nums));
    }

    //O(n)
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int ele=Math.abs(nums[i]);
            if(nums[ele-1]<0){
                result.add(Math.abs(ele));
            }
            nums[ele-1]=-nums[ele-1];
        }
        return result;
    }

    //faster
    public List<Integer> findDuplicatesFaster(int[] nums) {
        int[] fra = new int[nums.length+1];
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int n:nums)
            fra[n]++;
        for(int i=0;i<fra.length;i++){
            if(fra[i]==2)
                result.add(i);
        }
        return result;
    }
}
