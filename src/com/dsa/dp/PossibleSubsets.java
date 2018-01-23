package com.dsa.dp;

public class PossibleSubsets {

    public static void printSubsets(int n, String x){
        if(n==0){
            System.out.println(x);
            return;
        }else{
            for(int i=1;i<=n;i++){
                x = x + i;
                printSubsets(n - i, x);
                x = x.substring(0, x.length() - 1);
            }
        }
    }
    public static void main(String[] args) {
        int n =3;
        printSubsets(n,"");

    }

}