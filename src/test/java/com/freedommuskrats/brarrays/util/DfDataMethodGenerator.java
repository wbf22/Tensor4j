package com.freedommuskrats.brarrays.util;

public class DfDataMethodGenerator {


    public static void main(String[] args) {
        int dims = 5;

        for (int i = 1; i <= dims; i++) {
            System.out.print("    public Tensor" + i + "d get" + "(");
            System.out.print("int " + 'x' + (i));
            System.out.println(") {");

            System.out.println("        if getH[x" + (i+1) + "];");
            System.out.println("        return getH[x" + (i+1) + "];");


            System.out.println("    }");
            System.out.println();
        }
    }
}
