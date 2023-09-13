
package com.mycompany.laboratoryactivity1;

import java.util.Scanner;


abstract class Language {
    public void display () {
        System.out.println("This is Java Programming!");
    }
}


public class LaboratoryActivity1 extends Language{
    public static void main(String[] args) {
        //Example 1
        
        Scanner sc = new Scanner(System.in);
//        
//        System.out.print("Input a nonnegative integer: ");
//        int input = sc.nextInt();
//
//        
//        System.out.println("The factorial of " + input + " is " + factorial(input));

    //Example 2
    
//        LaboratoryActivity1 obj = new LaboratoryActivity1();
//        obj.display();


    //Example 3
    
//        System.out.print("Enter a word: ");
//        String word = sc.nextLine();
//    
//        System.out.println("Is " + word + " a palindrome? " + isPalindrome(word));

    //Example 4
    
//        char s = RandomCharacter.getRandomCharacter();
//        System.out.println("The random character is " + s);
    
    
    }
    
    public static boolean isPalindrome(String s){
        if (s.length() <= 1) return true;
        else if (s.charAt(0) != s.charAt(s.length()-1)) return false;
        else return isPalindrome(s.substring(1, s.length()-1));
    }
    
    
    public static long factorial(int n)  {
        if (n == 0) return 1;
        else return n * factorial(n-1);
    }
    
    public static int sumDigits(long n) {
        int sum = 0;
        while ( n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    } 
    
    public static void displaySortedNumbers(double num1, double num2, double num3) {
        double[] input = {num1, num2, num3};
        
        for (int i = 0; i < 3; i++) {
            int min_idx = i;
            for (int j = i + 1; j < 3; j++) {
                if (input[i] > input[j]) {
                    min_idx = j;
                }
            }
            
            double temp = input[min_idx];
            input[min_idx] = input[i];
            input[i] = temp;
        }
        
        System.out.println("SORTED NUMBERS");
        System.out.print("[");
        for (int i = 0; i < 3; i++) {
           System.out.print(" " + input[i] + " ");
        }
        System.out.println("]");
    }
    
    public static double celsiusToFahrenheit(double celsius) {
        return (9.0 / 5) * celsius + 32;
    }
    
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (((fahrenheit - 32) * 5.0) / 9);
    }
    
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }
    
    public static double meterToFoot(double meter) {
        return meter / 0.305;
    }
}



