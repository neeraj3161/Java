package com.company;

//creating multiple thread

    class newThread implements Runnable{
        Thread t;

        //constructor
        newThread(){
            //initialize the variable
            t= new Thread(this,"Multithread Example");
            System.out.println("MultiThread: "+t);
        }

        @Override
        public void run() {
            for(int i=5;i>0;i--){
                System.out.println("MultiThread: "+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Exiting Child Thread");
        }
    }

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //multiThreading
        newThread nt1=new newThread();
        newThread nt2=new newThread();
        newThread nt3=new newThread();
        nt1.t.start();
        nt2.t.start();
        nt3.t.start();


        //main thread

        for(int i=5;i>0;i--){
            System.out.println("Main Thread: "+i);
            Thread.sleep(100);
        }
        System.out.println("Exiting Main Thread");
    }
}