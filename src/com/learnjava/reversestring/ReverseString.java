package com.learnjava.reversestring;

/**
 * This program reverses every word of a string and display the reversed string
 * as an output. For example,
 * if we input a string as “Reverse the word of this string” then the output of
 * the program
 * would be: “esrever eht drow fo siht gnirts”.
 */
public class ReverseString {

    public String reverseWord(String word) {
        String result = "";
        for (int j = 0; j < word.length(); j++) {
            result += word.charAt(word.length() - j - 1);
        }
        return result;
    }

    public String reverseWordInMyString(String str) {
        String[] words = str.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            String reversedWord = reverseWord(words[i]);
            result += reversedWord + " ";
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        System.out.println(rs.reverseWordInMyString("Reverse every word in this string"));
    }
}
