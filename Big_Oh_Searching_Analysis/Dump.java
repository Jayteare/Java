/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javacontest;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Can
 */
public class JavaContest {

        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String dataT = "0 50 50 36 52 51 51 \n70 25\t34 100 99 52 49";
        String dataK = "1 2 1 2 8 9 8 9 4 4 6 6";
        String dataTT = "28 50 -10 4.5 36 52 51 51 \\n70 25\\t101 abc 1 2 3 def";
        String correcT = "28 50 36 52 51 51 70 25 1 2 3 ";
        Scanner input = new Scanner(dataTT);
        String dumpP = "";
        String data_ = "";

        int i = 0;
        double mean = 0.0;
        int i_Count = 0;
        int split_count = 0;

        while(input.hasNext())
        {
            data_ += input.next() + " ";
            i++;
        }
        String[] splitedD = data_.split("\\s+");

        double[] data = new double[i];
        int count_ = 0;

        for(int j = 0; j < i; j++)
        {
            if(!splitedD[j].matches("^-?\\d+$"))
            {
                splitedD[j] = splitedD[j].replaceAll("\\\\", "/");
                splitedD[j] = splitedD[j].replaceAll("[a-z]", "");

                

                if(splitedD[j].contains("."))
                {
                    splitedD[j] = "-1";
                    i_Count++;
                }
                
               String[] split_ = splitedD[j].split("/");
               for(int l = 0; l < split_.length; l++)
               {
                    //System.out.println("asd: " + split_[l]);
                    if(!split_[l].matches(""))
                    {
                        dumpP += split_[l] + " ";
                        split_count++;
                    }
                        
               }
                
               count_++;
            }

            try
            {

                int check_ = Integer.parseInt(splitedD[j]);
                if(check_ <= 0 || check_ > 100)
                {
                    splitedD[j] = "-1";
                }
                data[j] = Double.parseDouble(splitedD[j]);
            }
            catch(NumberFormatException e)
            {

            }

        }
        
        
        String[] splitedD2= dumpP.split("\\s+");
        
        double[] adD = new double[splitedD2.length];
        for(int k = 0; k < adD.length; k++)
        {
            adD[k] = Double.parseDouble(splitedD2[k]);
        }
        
        double[] nData = new double[adD.length + data.length];
        
        for(int k = 0; k < adD.length; k++)
        {
            nData[k] = adD[k];
        }
        
        int zeroJ = 0;
        
        for(int k = adD.length; k < nData.length;k++)
        {
            nData[k] = data[zeroJ];
            zeroJ++;
        }
        
        mean = mean(nData);
        System.out.printf("Mean is %5.2f ", mean);
        mean = Math.floor(mean);
        Arrays.sort(data);
        int index = Math.abs(Arrays.binarySearch(data, mean));
        System.out.print("Closest values are: " + (int)data[index]);
        for(int j = index; j < data.length; j++)
        {
            if(data[index] == data[j])
            {
                System.out.print(", " + (int)data[j]);
            }
        }
        System.out.println("");
        if(count_ >0)
        System.out.println("Bad Data Count was: " + count_);
    }

    public static double mean(double[] m)
    {
        double sum = 0;
        int count = 0;
        for (int i = 0; i < m.length; i++)
        {
            if(m[i] < 0)
                count++;
            else
                sum += m[i];
        }
        return sum / (m.length-count);
    }
}

