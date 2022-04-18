package com.company;

public class Main {

    //isAlive and join in multithreading---> this is used to know if the thread has ended or not coz we'll always want out main thread to end last

    //creating a thread
    static class  newThread implements Runnable{
        Thread t;
        String threadName;
        newThread(String threadName){
            this.threadName=threadName;
            t=new Thread(this,threadName);
        }
        @Override
        public void run(){
            for(int i =5;i>0;i--){
                System.out.println(t.getName()+" "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Exiting child thread");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        newThread nt= new newThread("One");
        newThread nt2=new newThread("Two");
        newThread nt3=new newThread("Three");
        nt.t.start();
        nt2.t.start();
        nt3.t.start();

        System.out.println("Thread One is alive: "+nt.t.isAlive());
        System.out.println("Thread Two is alive: "+nt2.t.isAlive());
        System.out.println("Thread Three is alive: "+nt3.t.isAlive());

        //wait for the thread to finish so that the main method will be executed and will end after the child thread has ended

        System.out.println("Waiting for the threads to finish");
        nt.t.join();
        nt2.t.join();
        nt3.t.join();

        //check if the thread is alive

        System.out.println("Thread One is alive: "+nt.t.isAlive());
        System.out.println("Thread Two is alive: "+nt2.t.isAlive());
        System.out.println("Thread Three is alive: "+nt3.t.isAlive());

        System.out.println("Exiting main thread");

        //as per the output this waited for the child thread to end before exiting the main thread.


    }
}