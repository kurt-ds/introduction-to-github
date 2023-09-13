/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratoryactivity1;

/**
 *
 * @author delossantosap
 */
public class RandomCharacter {
    public static char getRandomCharacter(char ch1, char ch2) {
        return (char) (ch1 + Math.random() * (ch2 - ch1 + 1));
    }
    
    public static char getRandomLowerCaseLetter() {
        return getRandomCharacter('a', 'z');
    }
    
    public static char getRandomUpperCaseLetter() {
        return getRandomCharacter('A', 'Z');
    }
    
    public static char getRandomDigitCharacter() {
        return getRandomCharacter('0', '9');
    }
    
    public static char getRandomCharacter() {
        return getRandomCharacter('\u0000', '\uFFFF');
    }
}
