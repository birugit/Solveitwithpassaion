package com.fb;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * @author swamy on 12/29/20
 */
public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] intervals ={{0,30}, {5,10}, {15,20}};
        int rooms = findMeetingRooms(intervals);
        System.out.println(rooms);
    }

    private static int findMeetingRooms(int[][] intervals) {
        if(intervals.length ==0)
            return  0;

        //sort based on sart time
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        //create the heap
        PriorityQueue<Integer> allocator = new PriorityQueue<>((a,b)-> a-b);

        //add first element
        allocator.add(intervals[0][1]);
        //iterate over remaining elements
        for(int i=1 ;i<intervals.length; i++){
            // if the room due to free up the earliest is free, assign that room to the
            // meeting
            if(intervals[i][0] >= allocator.peek()){
                allocator.poll();
            }
            // if a new room is to be assigned, then also we add to the heap
            // if old room is allocated, then also we have to add to the heap with updated
            // end time.
            allocator.offer(intervals[i][1]);
        }
//the size of the heap tells the minimum rooms required
        return allocator.size();
    }
}
