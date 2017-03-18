package com.dsa;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * Java program to remove given character from a given String using loops and recursion,
 * asked as coding question to Java programmers.
 *
 * @author Javin Paul
 */
public class RemoveCharFromString {

//    private static final Logger logger = LoggerFactory.getLogger(RemoveCharFromString.class);

    public static String remove(String word, char unwanted){
        StringBuilder sb = new StringBuilder();
        char[] letters = word.toCharArray();

        for(char c : letters){
            if(c != unwanted ){
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static String removeRecursive(String word, char ch){
        int index = word.indexOf(ch);
        if(index == -1){
            return word;
        }
        return removeRecursive(word.substring(0, index) + word.substring(index +1, word.length()), ch);
    }

    public static void main (String[] arg) {
        String s = "abc";
        System.out.println(s);
        String s1 = remove(s, 'a');
        String s2 = removeRecursive(s, 'a');
        System.out.println(s1);
        System.out.println(s2);
    }
}


