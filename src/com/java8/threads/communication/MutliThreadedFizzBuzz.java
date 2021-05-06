package com.java8.threads.communication;

/**
 * @author swamy on 3/12/21
 */
public class MutliThreadedFizzBuzz {
    private int n;
    private int num=1;
    public  MutliThreadedFizzBuzz(int n)
    {
        this.num= n;
    }

    public synchronized void fizz() throws InterruptedException{
       // while(num<=n){
            if(num % 3 == 0 && num % 5 != 0){
                System.out.println("fizz");
                num++;
                notifyAll();
            }else{
                wait(1000);
            }
       // }
    }


    public synchronized void buzz() throws InterruptedException{
      //  while(num<=n){
            if(num%3 != 0 && num % 5 == 0){
                System.out.println("buzz");
                num++;
                notifyAll();
            }else{
                wait(1000);
            }
       // }
    }

    public synchronized void fizzbuzz() throws InterruptedException{
     //   while(num<=n){
            if(num%15 == 0){
                System.out.println("fizzbuzz");
                num++;
                notifyAll();
            }else{
                wait(1000);
            }
       // }
    }

    public synchronized void number() throws InterruptedException{
       // while(num<=n){
            if(num%3 != 0 && num % 5 != 0){
                System.out.println(num);
                num++;
                notifyAll();
            }else{
                wait(1000);
           // }
        }
    }
}
