package com.dsa;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class GetKSumSubsets {


    static void getSubsetsRec(List<Integer> list, List<Integer> partial_list, Integer target_sum, List<HashSet<Integer>> sets) {
        int sum = 0;
        for (Integer x : partial_list) {
            sum += x;
        }

        if (sum == target_sum && partial_list.size() > 0) {
            sets.add(new HashSet<Integer>(partial_list));
        } else if (sum > target_sum) {
            return;
        } else {
            for (int i = 0; i < list.size(); ++i) {
                ArrayList<Integer> new_partial_list = new ArrayList<Integer>(partial_list);
                new_partial_list.add(list.get(i));

                List<Integer> new_list = list.subList(i + 1, list.size());

                getSubsetsRec(new_list, new_partial_list, target_sum, sets);
            }
        }
    }

    static void getSubsets(List<Integer> list, Integer target_sum, List<HashSet<Integer>> sets) {
        List<Integer> partial_list = new ArrayList<Integer>();
        getSubsetsRec(list, partial_list, target_sum, sets);
    }

    public static void main(String[] args) {

        List<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(5);
        a.add(7);
        List<HashSet<Integer>> sets = new ArrayList<HashSet<Integer>>();
        getSubsets(a, 7, sets);
        for(int i=0; i<sets.size(); i++) {
            HashSet<Integer> set = sets.get(i);
            System.out.println("Set in index: " + i);
            for(Integer s: set) {
                System.out.println(s);
            }
        }
    }
}
