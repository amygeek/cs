package com.dsa;

import java.util.HashMap;

class ProbabilityOfAlive
{
    public static double probabilityOfAlive(int x, int y, int n) {
        if (x < 0 || x > (n - 1) || y < 0 || y > (n - 1) || n < 1) {
            return 0.0;
        }
        return probabilityOfAlive(x, y, n, n, new HashMap<String, Double>());
    }

    private static double probabilityOfAlive(int x, int y, int n, int step, HashMap<String, Double> map) {
        if (0 == step) {
            return 1.0;
        }
        // if the state is already calculated, return from HashMap
        StringBuffer sb = new StringBuffer();
        sb.append(x + ",");
        sb.append(y + ",");
        sb.append(step + ".");
        String key = sb.toString();

        if (map.containsKey(key)) {
            return map.get(key);
        }
        // calculate the probability of a state
        double probability = 0.0;
        if (x > 0) {
            probability += 0.25 * probabilityOfAlive(x - 1, y, n, step - 1, map);
        }
        if (x < (n - 1)) {
            probability += 0.25 * probabilityOfAlive(x + 1, y, n, step - 1, map);
        }
        if (y > 0) {
            probability += 0.25 * probabilityOfAlive(x, y - 1, n, step - 1, map);
        }
        if (y < (n - 1)) {
            probability += 0.25 * probabilityOfAlive(x, y + 1, n, step - 1, map);
        }
        // save the result to HashMap and return
        map.put(key, probability); return probability;
    }

    public static void main(String[] args) {
        System.out.println("probability1 = " + probabilityOfAlive(0, 0, 1));
        System.out.println("probability2 = " + probabilityOfAlive(0, 0, 2));
        System.out.println("probability3 = " + probabilityOfAlive(0, 0, 3));
        System.out.println("probability4 = " + probabilityOfAlive(1, 1, 3));

    }
}