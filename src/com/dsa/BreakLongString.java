package com.dsa;

public class BreakLongString {
    public static void main(String a[]) {
        String dn = "aaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbcccccccccccccdddddddddddeeeeeee";
        StringBuffer legend = new StringBuffer();
        if (dn.length() >= 20) {
            String[] lines = Split(dn, 20, dn.length());
            for (int j = 0; j < lines.length; j++) {
                legend.append(lines[j]);
                if (j != lines.length - 1) {
                    legend.append("\n");
                }
            }
        }
        System.out.println("legend:\n"+legend);
    }
    private static String[] Split(String text, int chunkSize, int maxLength) {
        char[] data = text.toCharArray();
        int len = Math.min(data.length, maxLength);
        String[] result = new String[(len + chunkSize - 1) / chunkSize];
        int linha = 0;
        for (int i = 0; i < len; i += chunkSize) {
            result[linha] = new String(data, i, Math.min(chunkSize, len - i));
            linha++;
        }
        return result;
    }
}