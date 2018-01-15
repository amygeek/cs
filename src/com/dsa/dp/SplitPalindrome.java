package com.dsa.dp;

import java.util.HashMap;

public class SplitPalindrome {

    static HashMap<String,Integer> solutions = new HashMap<String, Integer>();

    public int splitDP(String x){
        if(x=="" || isPalindrome(x)){
//			System.out.println(x);
            return 0;
        }else{
            int cuts = Integer.MAX_VALUE;
            for (int i = 1; i <x.length() ; i++) {
                int leftSolution =0;
                int rightSolution = 0;
                String leftPart = x.substring(0,i);
                String rightPart = x.substring(i,x.length());
                if(solutions.containsKey(leftPart)){
                    leftSolution = solutions.get(leftPart);
                }else{
                    leftSolution = splitDP(leftPart);
                    solutions.put(leftPart,leftSolution);
                }
                if(solutions.containsKey(rightPart)){
                    rightSolution = solutions.get(rightPart);
                }else{
                    rightSolution = splitDP(rightPart);
                    solutions.put(rightPart,rightSolution);
                }
                cuts  = Math.min(1+ leftSolution  + rightSolution,cuts);
            }
            return cuts;
        }
    }

    public int splitRecursion(String x){
        if(x=="" || isPalindrome(x)){
//			System.out.println(x);
            return 0;
        }else{
            int cuts = Integer.MAX_VALUE;
            for (int i = 1; i <x.length() ; i++) {
                cuts  = Math.min(1+ splitRecursion(x.substring(0, i)) + splitRecursion(x.substring(i, x.length())),cuts);
            }
            return cuts;
        }
    }
    public boolean isPalindrome(String s){
        int n = s.length();
        for (int i=0;i<(n / 2) + 1;++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "cdcdddcdadcdcdcd";
        SplitPalindrome s = new SplitPalindrome();
        long startTime = System.currentTimeMillis();
        System.out.println("Recursion- Cuts Required: " + s.splitRecursion(a));
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Recursion- Time Taken(ms): " + elapsedTime);
        startTime = System.currentTimeMillis();
        System.out.println("Dynamic Programming- Cuts Required: "+  s.splitDP(a));
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        System.out.println("Dynamic Programming- Time Taken(ms): " + elapsedTime);

    }

}