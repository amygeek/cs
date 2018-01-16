package com.dsa.string;

import java.util.*;

public class LetterCombinationsOnPhone {

    Map<Integer,List<String>> map;

    public List<String> letterCombinations(String digits) {

        map = new HashMap<Integer,List<String>>();

        this.map.put(2,new ArrayList<String>(Arrays.asList("a","b","c")));
        this.map.put(3,new ArrayList<String>(Arrays.asList("d","e","f")));
        this.map.put(4,new ArrayList<String>(Arrays.asList("g","h","i")));
        this.map.put(5,new ArrayList<String>(Arrays.asList("j","k","l")));
        this.map.put(6,new ArrayList<String>(Arrays.asList("m","n","o")));
        this.map.put(7,new ArrayList<String>(Arrays.asList("p","q","r","s")));
        this.map.put(8,new ArrayList<String>(Arrays.asList("t","u","v")));
        this.map.put(9,new ArrayList<String>(Arrays.asList("w","x","y","z")));
        return comb(digits);

    }
    public List<String> comb(String digits) {

        List<String> result = new LinkedList<String>();

        if(digits.length() == 0) {
            result.add(new String(""));

        } else if(digits.length() == 1) {

            List<String> ret = new LinkedList<String>();
            for(String c: map.get(Integer.parseInt(digits))) {
                ret.add(c);
            }
            return ret;

        } else {
            for(String s : comb(digits.substring(1))) {
                for(String c: map.get(Integer.parseInt(digits.substring(0,1)))) {
                    result.add(c + s);
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {

        LetterCombinationsOnPhone LCOfPhone = new LetterCombinationsOnPhone();

        //[adg, bdg, cdg, aeg, beg, ceg, afg, bfg, cfg, adh, bdh, cdh, aeh, beh, ceh, afh, bfh, cfh, adi, bdi, cdi, aei, bei, cei, afi, bfi, cfi]
        System.out.println(LCOfPhone.letterCombinations("234"));

    }
}
