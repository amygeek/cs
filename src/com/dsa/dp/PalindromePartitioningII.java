package com.dsa.dp;

import java.util.HashMap;

public class PalindromePartitioningII {

    static HashMap<String,Integer> map = new HashMap<String, Integer>();

    public int splitDP(String x){

        if( x == "" || isPalindrome(x)){
//			System.out.println(x);
            return 0;
        }else{

            int cuts = Integer.MAX_VALUE;

            for (int i = 1; i < x.length() ; i++) {

                int leftCut =0;
                int rightCut = 0;

                String leftStr = x.substring(0, i );
                String rightStr = x.substring(i, x.length());
                
                if(map.containsKey(leftStr)){
                    leftCut = map.get(leftStr);
                }else{
                    leftCut = splitDP(leftStr);
                    map.put(leftStr,leftCut);
                }
                if(map.containsKey(rightStr)){
                    rightCut = map.get(rightStr);
                }else{
                    rightCut = splitDP(rightStr);
                    map.put(rightStr,rightCut);
                }
                cuts  = Math.min( 1 + leftCut  + rightCut, cuts);
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
        PalindromePartitioningII s = new PalindromePartitioningII();
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