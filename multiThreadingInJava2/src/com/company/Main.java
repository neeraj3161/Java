package com.company;

//first method to create a thread by using runnable

class newThread implements Runnable{
    Thread t;
    newThread(){
        //this means that you are telling the new thread to call the run method in this object
        t= new Thread(this,"Demo thread");
        //gives the thread details
        System.out.println("Child thread: "+t);
    }


    //the run method below with start or is the entry point of the new thread(second thread)
    @Override
    public void run() {
        for(int i =5;i>0;i--){
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

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //instantiating the child thread class
        newThread nt = new newThread();
        //start will call the run method
        nt.t.start();
        for(int i=5;i>0;i--){
            System.out.println("Main thread: "+i);

            Thread.sleep(1000);
        }

        System.out.println("Main thread exiting");
    }
}