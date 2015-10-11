package hello;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Hello
{
    public static void main(String args[])
    {
        ThreadSearch_Linear instance_1 = new ThreadSearch_Linear();
        ThreadSearch_Binary instance_2 = new ThreadSearch_Binary();
        Thread thread_Search_Linear    = new Thread (instance_1);
        Thread thread_Search_Binary    = new Thread (instance_2);

        
        /* Dynamic Array Creation */
        int dynamic_array_size  = 100;
        double []arr            = create_arr(dynamic_array_size);
        int key                 = create_key(dynamic_array_size);
        
        /* System.NanoSecond timing variables */
        long start              = 0;
        long search_start       = 0;
        long elapsed_time       = 0; 
        double seconds          = 0.0;
        double binary_seconds   = 0.0;
        
        /* 
            OVERALL PROGRAM START 
        */
        start = System.nanoTime();
        
        /*
            Linear search start
        */
        search_start       = System.nanoTime();
        linear_search_full(arr,key,dynamic_array_size);
        search_start       = System.nanoTime() - search_start;
        seconds            = (double) search_start / 1000000000.0;
        System.out.println("Linear Time Total : " 
                           + new DecimalFormat("#.##########").format(seconds) 
                           + " Seconds");
        System.out.println("");
        //Linear search end...................................................
        
        /* 
            Binary search start 
        */
        search_start       = 0;
        search_start       = System.nanoTime();
        binary_search_full(arr,key,dynamic_array_size);
        search_start       = System.nanoTime() - search_start;
        binary_seconds     = (double) search_start / 1000000000.0;
        binary_seconds     = seconds - binary_seconds;
        System.out.println("Binary Time : " 
                           + new DecimalFormat("#.##########").
                           format(binary_seconds) + " Seconds");  
        System.out.println("");
        //Binary search end...................................................
        

        thread_Search_Linear.start(); // Starts parrallel threading...
        thread_Search_Binary.start(); // Starts parrallel threading...
        
        search_start       = 0;
        search_start       = System.nanoTime();
        binary_search_internal(arr,key,dynamic_array_size);
        search_start       = System.nanoTime() - search_start;
        binary_seconds     = (double) search_start / 1000000000.0;
        binary_seconds     = seconds - binary_seconds;
        System.out.println("Binary Time : " 
                           + new DecimalFormat("#.##########").
                           format(binary_seconds) + " Seconds");  
        System.out.println("");
        
        elapsed_time = System.nanoTime() - start;
        seconds = (double) elapsed_time / 1000000000.0;
        System.out.println("Overall Time : " 
                           + new DecimalFormat("#.##########").format(seconds) 
                           + " Seconds" + " " 
                           + "Before threaded delayed runs.");     
    }
    
    /*
    
        INT - CREATE_ARR
        Creates an dynamic sized array with given size parameters and returns 
        the local created array
    
    */
    public static double[] create_arr(int dynamic_array_size)
    {   
        double []arr = new double[dynamic_array_size];
        double input_dex = 0.0;
        
        for(int index = 0; index < dynamic_array_size ; index++)
        {
            /* 
                IF STATEMENT -
                This statement is designed to force java garbage collection
                to run to clear the memory dumb on lower-end array sized.
               
                <NOTE> This style does not work with array sizes < 100.
                Only stable with linear search times under array sizes < 100
            
            */
            if(index == 0 || index == 100 || index == 1000)
            {
                System.gc();
            }

            arr[index] = input_dex; 
            input_dex++;
        }
        
        return arr;
    }   
    /*
    
        INT - CREATE_KEY
        Creates an local key based on the given size parameters for the array
        as an dynamic element and returns the generated key.
    
    */
    public static int create_key(int dynamic_array_size)
    {
        int key = 0;
        key = (int) (Math.random()* dynamic_array_size);
        return key;
    }
    
    /* */
    public static void linear_search_full(double[] arr, int key, 
                                         int dynamic_array_size)
    {
        int linear_search_single_miss = 0;
        int linear_search_miss        = 0;
        
        long search_start             = 0; 
        double seconds                = 0.0;
        
        System.out.println(" -* LINEAR SEARCH START *-");
        System.out.println(" ");
        System.out.println("Array Size" + "\tMiss amount" + "\tKey " 
                           + "\tTotal Miss"); 
        for(int index = 0; index < 5; index++)
        {
            search_start = System.nanoTime();
            arr = new double[dynamic_array_size];
            arr = create_arr(dynamic_array_size);
            key = create_key(dynamic_array_size);
            linear_search_single_miss += SearchClass.linear_Search(arr, key);
            linear_search_miss += linear_search_single_miss;
            
            System.out.print(    dynamic_array_size + "\t\t" 
                               + linear_search_single_miss + "\t\t" 
                               + key + "\t\t" 
                               + linear_search_miss + "\t");
            
            search_start       = System.nanoTime() - search_start;
            seconds            = (double) search_start / 1000000000.0;
            System.out.println(new DecimalFormat("#.##########")
                               .format(seconds) + " Seconds");
            
            dynamic_array_size *= 10;
            linear_search_single_miss = 0;
        }
         
        System.out.println("Total Miss amount : " + linear_search_miss);
        
        //LINEAR SEARCH END
    }
    
        /* */
    public static void binary_search_full(double[] arr, int key, 
                                          int dynamic_array_size)
    {
        int binary_search_single_miss = 0;
        int binary_search_miss        = 0;
        
        long search_start             = 0; 
        double seconds                = 0.0;
        
        System.out.println(" -* BINARY SEARCH START *-");
        System.out.println(" ");
        System.out.println("Array Size" + "\tMiss amount" + "\tKey " 
                           + "\tTotal Miss"); 
        for(int index = 0; index < 5; index++)
        {
            search_start = System.nanoTime();
            arr = new double[dynamic_array_size];
            arr = create_arr(dynamic_array_size);
            key = create_key(dynamic_array_size);
            binary_search_single_miss += SearchClass.binary_Search(arr, key);
            binary_search_miss += binary_search_single_miss;
            
            System.out.print(    dynamic_array_size + "\t\t" 
                               + binary_search_single_miss + "\t\t" 
                               + key + "\t\t" 
                               + binary_search_miss + "\t");
            
            search_start       = System.nanoTime() - search_start;
            seconds            = (double) search_start / 1000000000.0;
            System.out.println(new DecimalFormat("#.##########")
                               .format(seconds) + " Seconds");
            
            dynamic_array_size *= 10;
            binary_search_single_miss = 0;
        }
         
        System.out.println("Total Miss amount : " + binary_search_miss);
        
        //BINARY SEARCH END
    }
    
            /* */
    public static void binary_search_internal(double[] arr, int key, 
                                              int dynamic_array_size)
    {   
        long search_start             = 0; 
        double seconds                = 0.0;
        
        System.out.println(" -* BINARY SEARCH INTERNAL START *-");
        System.out.println(" ");
        for(int index = 0; index < 5; index++)
        {
            search_start = System.nanoTime();
            arr = new double[dynamic_array_size];
            arr = create_arr(dynamic_array_size);
            key = create_key(dynamic_array_size);
            int search = Arrays.binarySearch(arr,key);
            System.out.print("Search: " + search + " ");
            
            search_start       = System.nanoTime() - search_start;
            seconds            = (double) search_start / 1000000000.0;
            System.out.println(new DecimalFormat("#.##########")
                               .format(seconds) + " Seconds");
            
            dynamic_array_size *= 10;
        }
        
        //BINARY SEARCH END
    }
}
