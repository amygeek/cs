package com.dsa;

public class EmptyOrNullString {
    public static void main(String a[])
    {
        String s1=null;
        String s2="abc";
        String s3="";
        System.out.println("Result of firstString: "+isNullOrEmpty(s1));
        System.out.println("Result of secondString: "+isNullOrEmpty(s2));
        System.out.println("Result of thirdString: "+isNullOrEmpty(s3));
    }
    /**
     * Checks for null or empty.
     * @author dixit
     * @param data true/ false
     */
    public static boolean isNullOrEmpty(String data) {
        boolean retStatus = true;
        if (data != null && !"".equals(data.trim())) retStatus = false;
        return retStatus;
    }
}