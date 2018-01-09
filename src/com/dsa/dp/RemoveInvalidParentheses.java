package com.dsa.dp;

import java.util.List;
import java.util.ArrayList;

public class RemoveInvalidParentheses {

    public static void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) {
                stack++;
            }

            if (s.charAt(i) == par[1]) {
                stack--;
            }
            if (stack >= 0) continue;

            for (int j = last_j; j <= i; ++j) {
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
                }
            }

            return;
        }


        String reversed = new StringBuilder(s).reverse().toString();
        //System.out.println(reversed);
        if (par[0] == '(') // finished left to right
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else // finished right to left
            ans.add(reversed);
    }

    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        //String s = "()())()";   //[(())(), ()()()]
        String s = "(()(()";     //[(()), ()()]
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        System.out.print(ans);
    }
}
