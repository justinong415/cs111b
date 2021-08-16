/*
Author: Justin Ong
Date: 30 Sep 2017
Course: CS111B
Homework Assignment: #3
Objective:
  This Assignment does the following-
    1. Asks users to input a string through Scanner
    2. Check for sentinel data immediately after receiving input
    3. Filter method keep only alphanumeric characters
    4. Method that takes in one argument to check if word is a palindrome
*/
import java.util.Scanner;

class Palindrome
{
    public static String filter(String str)
    {
        String filtered = "";

        for(int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if(Character.isLetterOrDigit(c))
            {
                filtered += c;
            }
        }
        return(filtered.toLowerCase());
    }

    public static boolean palindromeCheck(String forward)
    {
        String reverse = "";
        int length = forward.length();

        for(int i = length - 1; i >= 0; i--)
        {
            reverse = reverse + forward.charAt(i);
        }

        if(forward.equals(reverse))
        {
            return true;
        }
        return false;
    }

    public static void main(String args[])
    {
        for(;;)
        {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter a string, or 'exit' to stop: ");
            String original = scan.nextLine();

            if(original.equals("exit")) break;

            String answer = original + " is NOT a palindrome!";
            if(palindromeCheck(filter(original)))
            {
                answer = original + " is a palindrome.";
            }

            System.out.println(answer);
        }

        System.out.println("Goodbye!");
    }
}