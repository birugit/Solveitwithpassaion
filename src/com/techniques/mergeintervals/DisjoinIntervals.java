package com.techniques.mergeintervals;

import java.util.TreeMap;

/**
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
 *
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 *
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 *
 *
 * Follow up:
 *
 * What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 */
public class DisjoinIntervals {
    public static void main(String[] args) {
        DisjoinIntervals d = new DisjoinIntervals();
      //  1, 3, 7, 2, 6
        d.addNum(1);

        System.out.println(d.getIntervals());
        d.addNum(3);

        System.out.println( d.getIntervals());
        d.addNum(7);
        System.out.println( d.getIntervals());
        d.addNum(2);
        System.out.println( d.getIntervals());
        d.addNum(6);
        System.out.println( d.getIntervals());
        d.addNum(4);
        System.out.println( d.getIntervals());

      /*  for(int[] n: res){
            for(int i:n){
                System.out.println(i);
            }
        }*/
    }

    class Interval{
        Integer start;
        Integer end;
        public Interval(Integer key, Integer val){
            this.start = key;
            this.end = val;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    TreeMap<Integer, Interval> tree;
    /** Initialize your data structure here. */
    public DisjoinIntervals() {
        tree = new TreeMap<>();


    }

    public void addNum(int val) {
        if(tree.containsKey(val))
            return;
        Integer l = tree.lowerKey(val);
        Integer h = tree.higherKey(val);
        if(l != null && h != null && tree.get(l).end + 1 == val && h == val + 1) {//2. 2
            tree.get(l).end = tree.get(h).end;
            tree.remove(h);
        } else if(l != null && tree.get(l).end + 1 >= val) {//4. 4
            tree.get(l).end = Math.max(tree.get(l).end, val);
        } else if(h != null && h == val + 1) {//3. 6
            tree.put(val, new Interval(val, tree.get(h).end));
            tree.remove(h);
        } else {//1. 1,3,7
            tree.put(val, new Interval(val, val));
        }
    }

    public int[][] getIntervals() {
    //public List<Interval> getIntervals() {// if we need to return list
      //  return new ArrayList<>(tree.values());
       int[][] res = new int[tree.size()][2];
        int i = 0;
        for(Interval a:tree.values()){
            res[i][0] = a.start;
            res[i][1] = a.end;
            i++;
        }
        return res;

    }
}
