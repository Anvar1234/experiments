package org.example.io_file_write_read.mnogochlen;

import java.util.Random;

public class Mnogochlen {

    private static int[] createIntArray(int k) {
        int[] ints = new int[k+1];
        Random random = new Random();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(0, 101);
        }
        return ints;
    }

    public static String createStringPolynomial(int k) {
        int[] intsArray = createIntArray(k);
        StringBuilder st = new StringBuilder();
        int count = intsArray.length-1;
        for (int i = 0; i < intsArray.length; i++) {
            if (count != 0) {
                st.append(intsArray[i]);
                st.append("*");
                st.append("x^");
                st.append(count--);
                st.append("+");
            } else st.append(intsArray[intsArray.length - 1]);
        }
        return st.toString();
    }
}