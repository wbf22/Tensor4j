package com.freedommuskrats.tensor4j.util;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.freedommuskrats.tensor4j.util.DDClassGenerator.genVerifyDimsMethod;

@Disabled
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
