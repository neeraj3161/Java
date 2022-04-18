package com.company;



public class Main {

    public static void main(String[] args) {
	        //controlling the main thread using the thread class
        //getting the current thread
        Thread t= Thread.currentThread();
        System.out.println("Current thread: "+t);
        t.setName("My thread");
        System.out.println("After name change: "+t);

        for(int i=0;i<6;i++){
            System.out.println(t+ "thread is running!!");
            //asking the thread to sleep/wait for 1 sec after each print
            //now this thread can through an exception if some other thread is trying to come or interrupt while this thread is sleeping so to prevent this interruption we use try and catch to handle the error
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//A thread group is a data structure that controls the state of
//a collection of threads as a whole.

//the sleep method above ask or allows the thread to suspend for the mentioned milliseconds general form for which is static void sleep(milliseconds) throws InterrupedExcetion
//you can also specify the sleep in terms of milli and nano seconds the general form for which is static void sleep(milli,nano) throws InterruptedException