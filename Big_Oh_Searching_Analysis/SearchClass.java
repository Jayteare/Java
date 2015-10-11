/*
 * To change this license header, choose License Headers in Project 
 * Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

/**
 *
 * @author Can
 */
public class SearchClass {
    
    public static int linear_Search(double []arr, int key)
    {
        int index     = 0;
        double n_key = (double) key;
        
        while(true)
        {
            if(n_key != arr[index])
                index++;
            else
                break;
        }
        
        return index;
    }
    
    public static int binary_Search(double []arr, int key)
    {
        double n_key = (double) key;
        int low  = 0;
        int high = (arr.length - 1);
        int mid  = 0;
        int miss = 0;
        
        while(low <= high)
        {
            mid = (low + high) / 2;
            
            if(arr[mid] < n_key)
            {
                low = mid + 1;
                miss++;
            }
            else if (arr[mid] > key)
            {
                high = mid - 1;
                miss++;
            }
            else
                break;
        }
        return miss;
    }
}
