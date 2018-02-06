import java.text.DecimalFormat;
import java.util.Arrays;

public class main
{
    public static void main(String args[])
    {
        long start     = 0;
        double seconds = 0.0;

        //Start of the Performance testing;
        start = System.nanoTime();

        //Variable Handles
        int[] arr = new int[10];

        //Generates 10 Random Numbers in the range 1 -20
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = (int)(Math.random()*10000 + 10);

        }//end for loop
        System.out.println("Numbers Generated: " + Arrays.toString(arr));

        start = System.nanoTime() - start;
        seconds            = (double) start / 1000000000.0;
        System.out.println("Linear Time Total : "
                + new DecimalFormat("#.##########").format(seconds)
                + " Seconds");
        System.out.println("");
    }
}
