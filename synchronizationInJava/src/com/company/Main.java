package com.company;

public class Main {

    //non synchronized class
   static class callme{
        synchronized void call(String msg) throws InterruptedException {
            System.out.print("["+msg);
            Thread.sleep(1000);
            System.out.println("]");
        }
    }

   static class caller implements Runnable{

        String msg;
        callme target;
        Thread t;

        public caller(String msg, callme target) {
            this.msg = msg;
            this.target = target;
            t= new Thread(this);
        }



        @Override
        public void run() {

            try {
                target.call(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }



    public static void main(String[] args) throws InterruptedException {

        callme target = new callme();
        caller c1= new caller("Hello",target);
        caller c2= new caller("Synchronized",target);
        caller c3= new caller("World",target);
        c1.t.start();
        c2.t.start();
        c3.t.start();


        //wait for other thread to end before ending the main thread

        c1.t.join();
        c2.t.join();
        c3.t.join();


  //non synchronized output
    // [World
    // [Hello
    //[Synchronized
      //]
       //]
      // ]


        //output after adding the synchronized keyword before the function which only allows one thread to enter at a time and behaves like a monitor

       // [Hello]
        //[Synchronized]
        //[World]
   }
}