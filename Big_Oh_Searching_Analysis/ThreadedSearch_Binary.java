/*
 * To change this license header, choose License Headers in Project 
 * Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import static hello.Hello.create_arr;
import static hello.Hello.create_key;
import static hello.Hello.linear_search_full;
import static hello.Hello.binary_search_full;
import java.text.DecimalFormat;

/**
 *
 * @author Can
 */
public class ThreadSearch_Binary implements Runnable {
    
    Hello mainSc = new Hello();
    public void run()
    {
        int count              = 0;
        long search_start      = 0;
        double seconds         = 0.0;
        
        int dynamic_array_size  = 100;
        double []arr            = mainSc.create_arr(dynamic_array_size);
        int key                 = mainSc.create_key(dynamic_array_size);
        System.out.println("");
        
        try{
            while(count < 6)
            {
                Thread.yield();
                Thread.sleep(200);
                System.gc();
                count++;
            }
            
        System.out.println("RunnableThread starting :"
                + ": BINARY SEARCH THREADED");
            
        /*
            Linear search start
        */
        search_start       = System.nanoTime();
        binary_search_full(arr,key,dynamic_array_size);
        count = 0;
        search_start       = System.nanoTime() - search_start;
        seconds            = (double) search_start / 1000000000.0;
        System.out.println("Binary Time Total : " 
                           + new DecimalFormat("#.##########").format(seconds) 
                           + " Seconds");
        System.out.println("");
        //Linear search end................................................... 
            
        } catch (InterruptedException exc) {
            System.out.println("RunnableThread interruped.");
        }
        System.out.println("RunnableThread BINARY terminating.\n");
    }
    
}
