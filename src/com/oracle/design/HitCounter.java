package com.oracle.design;

public class HitCounter {
    private int[] times;
    private int[] hits;
    //Initialize your Data Structure
    public HitCounter(){
        times = new int[300];
        hits = new int[300];
    }

    public static void main(String[] args) {
        HitCounter h = new HitCounter();
        h.hit(1);
        h.hit(2);
        h.hit(3);
        h.hit(3);
        System.out.println(h.getHits(4));
        h.hit(300);
        System.out.println(h.getHits(300));
        System.out.println(h.getHits(301));

    }

    //Read hit count
    public void hit(int timestamp){
        int index = timestamp % 300;
        System.out.println("Index: "+index);
        if(times[index] != timestamp){
            times[index] = timestamp;
            hits[index] = 1;
        }else{
            hits[index]++;
        }
    }

    public int getHits(int timestamp){
        int total = 0;
        for(int i=0; i < 300; i++){
            if(timestamp - times[i] < 300){
                total += hits[i];
            }
        }
        return total;
    }

}

