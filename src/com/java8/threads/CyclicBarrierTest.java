package com.java8.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**CyclicBarrier is synchronization mechanism,
 * It allows multiple thread wait for each other at a common point(barrier) before executing
 *
 *CountDownLatch and CyclicBarrier same, But CountDownLatch cannot reset.
 *Use: map reduce
 * mutliplayer Game (wait for all players to join)
 * @author swamy on 3/11/21
 */
class CyclicBarrierTest implements Runnable{

    /**
     * Runnable task for each thread
     */
        CyclicBarrier cyclicBarrier;
        public CyclicBarrierTest(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }

        //Await is invoked to wait for other threads
        @Override
        public void run() {
            try{
        System.out.println(Thread.currentThread().getName()+"is waiting on barrier");
        cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+"is  crossed barrier");
            }catch (InterruptedException e){
                e.printStackTrace();
            }catch (BrokenBarrierException b){
                b.printStackTrace();
            }
        }

  public static void main(String[] args) {
    //creating cyclic Barrier with 3 parties, 3 threads need to wait
      CyclicBarrier c = new CyclicBarrier(3, new Runnable() {
          @Override
          public void run() {
System.out.println("All parties have arrived the barrier, lets execute");
          }
      });

      Thread t1 = new Thread(new CyclicBarrierTest(c), "Thread-1");
      Thread t2 = new Thread(new CyclicBarrierTest(c), "Thread-2");
      Thread t3 = new Thread(new CyclicBarrierTest(c), "Thread-3");
      t1.start();
      t2.start();
      t3.start();
  }
}
