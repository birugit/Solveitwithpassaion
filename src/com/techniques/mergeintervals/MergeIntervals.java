package com.techniques.mergeintervals;

import java.util.*;

class Interval
{
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class MergeIntervals {

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
       MergeIntervals.merge(input);
        System.out.println("Merged Intervals");
       for(Interval interval: MergeIntervals.merge(input)){
            System.out.println("["+interval.start +" , "+interval.end +"]");
        }

        System.out.println("Inserted new  Interval");
        for(Interval interval: MergeIntervals.insert(input, new Interval(4, 6))){
            System.out.print("["+interval.start +" , "+interval.end +"]");
        }

//merge
        Interval[] input1 = new Interval[]{new Interval(1, 3), new Interval(5,6), new Interval(7, 9)};
        Interval[] input2 = new Interval[]{new Interval(2, 3), new Interval(5,7)};
        Interval[] result = MergeIntervals.merge(input1, input2);
        System.out.println("Interval Intersection");
        for(Interval interval: result)
            System.out.println("[" + interval.start + "," + interval.end + "]");

//Array intervals
        //Input: [[1,3],[2,6],[8,10],[15,18]]
        //Output: [[1,6],[8,10],[15,18]]
        int[][] arr ={{1,3}, {2,6}, {8,10}, {15, 18}};
        int[][] afterArr = MergeIntervals.merge(arr);
        System.out.println("Array Merge Interval");
        for(int[] ar:afterArr){
            System.out.println(ar[0]+"-"+ar[1]);
        }
    }

    /*
    Time: O N*logN  -> need to traverse each interval, so its O(N)  and sorting takes logN if it uses merger or Tim sort
    Space: O(N) -> need to return N intervals, so O(N) space, equal to merge sort space
    */
    private static List<Interval> merge(List<Interval> intervals) {
        //1. sort interval list based on start
        Collections.sort(intervals, (a,b) -> a.start - b.start);

        //2. if end time < start time of next interval, merge it
        List<Interval> mergedIntervals = new LinkedList<>();
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();

        int start = interval.start;
        int end = interval.end;
        while(intervalItr.hasNext()){
            interval = intervalItr.next();
            // Overlapping intervals, move the end if needed
            if(interval.start <= end){
                end = Math.max(interval.end, end);
            }else{// Disjoint intervals, add the new interval to the list
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergedIntervals.add(new Interval(start, end));

       return mergedIntervals;
    }
/*
Time: O(N) as we no need to sort and just traverse once
Space: O(N)
 */
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval){
        if(intervals == null || intervals.isEmpty())
            return Arrays.asList(newInterval);
        List<Interval> mergedIntervals = new ArrayList<>();

        int i=0;
        //skip all intervals that come before the newInterval
        while(i < intervals.size() && intervals.get(i).end < newInterval.start)
            mergedIntervals.add(intervals.get(i++));

        //merge all intervals that overlap with newInterval
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval.start = Math.min(intervals.get(i).start , newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        //insert the new interval
        mergedIntervals.add(newInterval);

        //add all the remaining intervals to the ouput
        while(i< intervals.size())
            mergedIntervals.add(intervals.get(i++));

        return mergedIntervals;
    }

    /**
     * Time: O(N+M)   iterating through the both arrays , its total no of intervals both arrays N and M
     * Space: O(1) Ignore the space of the result list
     * @param arr1
     * @param arr2
     * @return
     */
    public static Interval[] merge(Interval[] arr1, Interval[] arr2){
        List<Interval> result = new ArrayList<>();
        int i = 0, j = 0;
        while(i < arr1.length && j < arr2.length){
            //check if the interval arr[i] interacts with arr2[j]
            //check if one of the intervals start time lies within the other interval
            if((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end)
                    || (arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end)){
                //store the intersection part
                result.add(new Interval(Math.max(arr1[i].start, arr2[j].start), Math.min(arr1[i].end, arr2[j].end)));
            }

            //move next from the onterval which is finishing first
            if(arr1[i].end < arr2[j].end)
                i++;
            else
                j++;


        }
        return result.toArray(new Interval[result.size()]);
    }

//Arrays version
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        //sort intervals, to get first element in an ascending order
        Arrays.sort(intervals, (array1, array2) -> Integer.compare(array1[0], array2[0]));
        //create a list to record arrays
        List<int[]> result = new ArrayList<>();
        int[] curr_interval = intervals[0];
        result.add(curr_interval);
        for (int[] interval : intervals) {
            int curr_begin = curr_interval[0];
            int curr_end = curr_interval[1];
            int next_begin = interval[0];
            int next_end = interval[1];

            if (curr_end >= next_begin) {
                curr_interval[1] = Math.max(curr_end, next_end);
            } else {
                curr_interval = interval;
                result.add(curr_interval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
