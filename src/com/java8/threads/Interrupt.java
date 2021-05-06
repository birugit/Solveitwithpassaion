package com.java8.threads;

public class Interrupt {
    public static void main(String[] args)
      {
            String importantInfo[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };

            for (int i = 0;
                 i < importantInfo.length;
                 i++) {
                try {
                    //Pause for 4 seconds
                    Thread.sleep(4000);

                    //2. If there is no interruption for long time,
                    // use Thread interrupted static method to check status , weather interrupted or not
                    //it sets the flag automatically
                      if(Thread.interrupted()){
                          return;
                      }
                }catch(InterruptedException e){//1. By catching interrupt, comes out of sleep.
                    //have been interrupted, no more messages
                    return;
                }
                //Print a message
                System.out.println(importantInfo[i]);
            }
    }
}
