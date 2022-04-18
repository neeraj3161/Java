package com.company;

public class Main {

    //using extend class method
    static class newThread extends Thread{
        newThread(){
            //this call to super invoked the following thread constructor public Thread(String threadName)
            super("Demo thread");
            System.out.println("Child thread: "+this);
        }

        @Override
        public void run() {
            for(int i=5;i>0;i--){
                try {

                    System.out.println("Child thread: "+i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Exiting child thread");
        }
    }

    public static void main(String[] args) {
            newThread nt = new newThread();
            nt.start();
            for(int i=5;i>0;i--){
                try {
                    System.out.println("Main Thread: "+i);

                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        System.out.println("Exiting main thread");
    }

}