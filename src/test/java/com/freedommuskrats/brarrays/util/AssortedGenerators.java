package com.freedommuskrats.brarrays.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

import static com.freedommuskrats.brarrays.util.DDClassGenerator.*;

public class AssortedGenerators {



    @Test
    void genVerifyDimensionMethods() {


        int methodToGen = 32;
        String fileString = "";

        for (int dim = 4; dim <= methodToGen; dim++) {
            fileString += genVerifyDimsMethod( dim);

        }

        System.out.println(fileString);
    }

    @Test
    void testStuff() {
        System.out.println("\\n");
    }
}