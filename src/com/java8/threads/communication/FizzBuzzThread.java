package com.java8.threads.communication;

/**
 * @author swamy on 3/12/21
 */
public class FizzBuzzThread extends  Thread{
    MutliThreadedFizzBuzz obj;
    String method;

    public FizzBuzzThread(MutliThreadedFizzBuzz obj, String method){
        this.obj = obj;
        this.method = method;
    }

    public void run(){
        if("Fizz".equals(method)){
            try{
                obj.fizz();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if("Buzz".equals(method)){
            try{
                obj.buzz();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if("FizzBuzz".equals(method)){
            try{
                obj.fizzbuzz();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if("Number".equals(method)){
            try{
                obj.number();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
