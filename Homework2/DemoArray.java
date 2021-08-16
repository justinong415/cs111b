/*
Author: Justin Ong
Date: 21 Sep 2017
Course: CS111B
Homework Assignment: #2
Objective:
  This Assignment does the following-
    1. Creates an array with 100 elements
    2. Has static method 'fillup' plug random numbers between 1-500 into array
    3. Has static method "average" to calculate and return average of array
    4. Has static method "largest" to find and return largest number in array
    5. Has static method "smallest" to return the smallest number in array
    6. Has static method "printArray" that prints all the numbers in array
*/
import java.util.Arrays;
import java.util.Random;

class DemoArray
{
    public static void main(String args[])
    {
        int array[] = new int[100];
        fillup(array);

        System.out.println("The average of the array is: " + average(array));
        System.out.println("The largest int in the array is: " + largest(array));
        System.out.println("The smallest int in the array is: " + smallest(array));
        System.out.println("The elements in the array are: " + "\n" + printArray(array));
    }

    public static int[] fillup(int[] fillupArrayVar)
    {
        int[] filledupArray = fillupArrayVar;

        Random rand = new Random();
        for (int i = 0; i < filledupArray.length; i++)
        {
            int n = rand.nextInt(500) + 1;
            filledupArray[i] += n;
        }

        return filledupArray;
    }

    public static int average(int[] averageArrayVar)
    {
        int[] avgArray = averageArrayVar;
        int total = 0;
        int avg = 0;

        for (int i = 0; i < avgArray.length; i++)
        {
            total += avgArray[i];
        }

        avg = (total / avgArray.length);
        return avg;
    }

    public static int largest(int[] maxArrayVar)
    {
        int[] maxArray = maxArrayVar;
        int max = 0;

        for (int i = 0; i < maxArray.length; i++)
        {
            if(max < maxArray[i])
            {
                max = maxArray[i];
            }
        }
        return max;
    }

    public static int smallest (int[] smallestArrayVar)
    {
        int[] smallArray = smallestArrayVar;
        int small = 501;

        for (int i = 0; i < smallArray.length; i++)
        {
            if(small > smallArray[i])
            {
                small = smallArray[i];
            }
        }
        return small;
    }

    public static String printArray(int[] printArrayVar)
    {
        int[] arrayToPrint = printArrayVar;
        return Arrays.toString(arrayToPrint);
    }
}

// Output



