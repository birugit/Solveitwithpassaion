package com.techniques.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicates {
    public static void main(String[] args) {
        SubsetWithDuplicates s = new SubsetWithDuplicates();
        int[] nums ={1, 2, 3};
        List<List<Integer>> res=s.findSubsetsWithDuplicates(nums);
        System.out.println(res);
    }
    private List<List<Integer>> findSubsetsWithDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        resList.add(new ArrayList<>());
        int startIndex = 0, endIndex=0;
        for(int i=0; i< nums.length; i++){
            startIndex = 0;
            //if current and the previous elements are same, create new subsets only from the subsets added in the previous step
            if(i > 0 && nums[i] == nums[i - 1])
                startIndex = endIndex + 1;
            endIndex = resList.size() - 1;
          //  int size = resList.size();
            for(int j=startIndex; j<= endIndex; j++){
                //create a new subset from the existing subsets and add the current element to it
                List<Integer> set = new ArrayList<>(resList.get(j));
                set.add(nums[i]);
                resList.add(set);
            }
        }

        return resList;

    }
}
