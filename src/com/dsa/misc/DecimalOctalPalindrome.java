package com.dsa.misc;

public class DecimalOctalPalindrome {

    public String DecimalTooctal(int num) {
        String oct = "";
        while (num > 0) {
            int x = num % 8;
            num = num / 8;
            oct += x;
        }
        return oct;
    }

    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public void findBothPalindrome(int start, int end) {
        for (int i = start; i <= end; i++) {
            String decimal = String.valueOf(i);
            if (isPalindrome(decimal)) {
                String oct = DecimalTooctal(i);
                if (isPalindrome(oct)) {
                    System.out.print(oct + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        DecimalOctalPalindrome d = new DecimalOctalPalindrome();
        d.findBothPalindrome(1, 2000);
    }

}
