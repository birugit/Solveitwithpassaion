package com.july;

import java.util.Arrays;

/**
 You are given a char array representing tasks CPU need to do. It contains capital letters A to Z where each letter represents a different task. Tasks could be done without the original order of the array. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

 However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

 You need to return the least number of units of times that the CPU will take to finish all the given tasks.



 Example 1:

 Input: tasks = ["A","A","A","B","B","B"], n = 2
 Output: 8
 Explanation:
 A -> B -> idle -> A -> B -> idle -> A -> B
 There is at least 2 units of time between any two same tasks.
 */
public class TaskSchedule {

    public static void main(String[] args) {
        TaskSchedule t = new TaskSchedule();
        char[] tasks ={'A','A','A','B','B','B'};
        int n = 0;//2;
        System.out.println(t.leastInterval(tasks, n));
    }
    public int leastInterval(char[] tasks, int n) {
        // frequencies of the tasks
        //The maximum number of tasks is 26. Let's allocate an array frequencies of 26 elements to keep the frequency of each task.
        int[] frequencies = new int[26];

        //Iterate over the input array and store the frequency of task A at index 0, the frequency of task B at index 1, etc.
        for (int t : tasks) {
            frequencies[t - 'A']++;
        }

        //Sort the array and retrieve the maximum frequency f_max.
        // This frequency defines the max possible idle time: idle_time = (f_max - 1) * n.
        Arrays.sort(frequencies);

        // max frequency
        int f_max = frequencies[25];
        int idle_time = (f_max - 1) * n;

        //Pick the elements in the descending order one by one. At each step, decrease the idle time by min(f_max - 1, f) where f is a current frequency.
        // Remember, that idle_time is greater or equal to 0.
        for (int i = frequencies.length - 2; i >= 0 && idle_time > 0; --i) {
            idle_time -= Math.min(f_max - 1, frequencies[i]);
        }
        idle_time = Math.max(0, idle_time);

        //Return busy slots + idle slots: len(tasks) + idle_time.
        return idle_time + tasks.length;
    }
}
