package com.array;
/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Solution
 * Take minimum size of two array. Possible number of partitions are from 0 to m in m size array.
 * Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
 * Now try to find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition around which lies the median.
 *
 * Time complexity is O(log(min(x,y))
 * Space complexity is O(1)
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation/4
 */
public class MedianOfSortedArrays {
    public static void main(String[] args) {
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 18, 19, 21, 25};

        MedianOfSortedArrays mm = new MedianOfSortedArrays();

        System.out.println( mm.findMedianSortedArrays(x, y));
    }

    /**
     * Time complexity is O(log(min(x,y))
     *  Space complexity is O(1)
     * @param first
     * @param second
     * @return
     */
    private double findMedianSortedArrays(int[] first, int[] second) {
        int x = first.length;
        int y = second.length;

        int low=0;
        int high = x;
        double avg = 0;
        while(low < high){
            int partitionX = (low + high )/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            int MIN = Integer.MAX_VALUE;
            int MAX = Integer.MAX_VALUE;
            int maxLeftX = (partitionX==0)? MIN:first[partitionX - 1];
            int minRightX = (partitionX==x)? MAX: first[partitionX];

            int maxLeftY = (partitionY==0)? MIN: second[partitionY - 1];
            int minRightY = (partitionY==y)? MAX : second[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((x + y) % 2 == 0){//even input
                 return   avg = (Math.max(maxLeftY, maxLeftX)+ Math.min(minRightY, minRightX))/2;
                }else{
                   return avg = Math.max(maxLeftX, maxLeftY);
                }
            }else if(maxLeftX > minRightY ){
                high = partitionX -1;
            }else{
                low = partitionX +1;
            }
        }

        return avg;
    }
}
