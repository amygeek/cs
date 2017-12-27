package com.dsa;

import java.util.*;
import java.util.Arrays;

public class Lexicographic {
    public static void main(String a[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String:-");
        String str = sc.nextLine();
        System.out.println("Enter the length");
        int count = sc.nextInt();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < str.length(); i = i + 1) {
            if (str.length() - i >= count) {
                list.add(str.substring(i, count + i));
            }
        }
        Collections.sort(list);
        System.out.println("Smallest subString:-" + list.get(0));
        System.out.println("Largest subString:-" + list.get(list.size() - 1));
        System.out.println("Largest subString:-" + list);
    }
}
